import java.util.*;


public class Graph<N, W> implements IGraph<N, W>
{
  private ArrayList<INode<N>> nodes;
  private ArrayList<IEdge<N, W>> edges;

  public Graph()
  {
    nodes = new ArrayList<INode<N>>();
    edges = new ArrayList<IEdge<N, W>>();
  }

  public INode<N>[] getNodeSet()
  {
    INode<N>[] node_set = (INode<N>[])new Node[nodes.size()];
    for (int i =0; i < node_set.length; i++)
    {
      node_set[i] = nodes.get(i);
    }
    return node_set;
  }

  public int getEdgeSetSize()
  {
    return edges.size();
  }

  public int getNodeSetSize()
  {
    return nodes.size();
  }


  public INode<N>[] getNeighbors(INode<N> n)
  {
    ArrayList<INode<N>> neighbors = new ArrayList<INode<N>>();
    for (int i = 0; i < edges.size(); i++)
    {
      if (edges.get(i).getSource() == n)
      {
        neighbors.add(edges.get(i).getDestination());
      }
    }
    INode<N>[] neighbor_array = (INode<N>[])new INode[neighbors.size()];
    for (int i=0; i < neighbors.size(); i++)
    {
      neighbor_array[i] = neighbors.get(i);
    }
    return neighbor_array;
  }

  public INode<N> addNode (N v)
  {
    INode<N> new_node = new Node<N>(v);
    for (int i =0; i < nodes.size(); i++)
    {
      if (nodes.get(i).getValue().equals(v) )
      {
        return new_node;
      }
    }
    nodes.add(new_node);
    return new_node;
  }

  public IEdge<N, W>[] getEdgeSet()
  {
    IEdge<N, W>[] edge_array = (Edge<N, W>[])new Edge[edges.size()];
    for (int i=0; i < edges.size(); i++)
    {
      edge_array[i] = edges.get(i);
    }
    return edge_array;
  }

  public IEdge<N, W>[] getEdgesFrom(INode<N> n)
  {
    ArrayList<IEdge<N, W>> node_edges = new ArrayList<IEdge<N, W>>();
    for (int i = 0; i < edges.size(); i++)
    {
      if (edges.get(i).getSource() == n)
      {
        node_edges.add(edges.get(i));
      }
    }
    IEdge<N, W>[] edge_array = (Edge<N, W>[])new Edge[node_edges.size()];
    for (int i = 0; i < edge_array.length; i++)
    {
      edge_array[i] = node_edges.get(i);
    }
    return edge_array;
  }

  public IEdge<N, W>[] getEdgesTo(INode<N> n)
  {
    ArrayList<IEdge<N, W>> node_edges = new ArrayList<IEdge<N, W>>();
    for (int i = 0; i < edges.size(); i++)
    {
      if (edges.get(i).getDestination() == n)
      {
        node_edges.add(edges.get(i));
      }
    }
    IEdge<N, W>[] edge_array = (Edge<N, W>[])new Edge[node_edges.size()];
    for (int i = 0; i < edge_array.length; i++)
    {
      edge_array[i] = node_edges.get(i);
    }
    return edge_array;
  }

  public void addEdge(INode<N> s, INode<N> d, W w)
  {
    IEdge<N, W> new_edge = new Edge<N, W>(s, d, w);
    for (int i =0; i < edges.size(); i++)
    {
      if (edges.get(i).getSource().equals(s) && edges.get(i).getDestination().equals(d) && edges.get(i).getWeight().equals(w))
      {
        return;
      }
    }
    edges.add(new_edge);
  }

  public void clearNodes()
  {
    for (int i =0; i< nodes.size(); i++)
    {
      nodes.get(i).clearVisited();
    }
  }

  public boolean neighborsVisited(INode<N> n) // returns true if all the neighbors have been visited already or if there are no neighbors
  {
    INode<N>[] neighbor_array = (INode<N>[])this.getNeighbors(n);
    boolean r = true;
    if (neighbor_array == null ) { return true; }
    for (int i = 0; i < neighbor_array.length; i++)
    {
      Node<N> node = (Node<N>) neighbor_array[i];
      if (!node.visitedStatus())
      {
        r= false;
      }
    }
    return r;


  }


  public static void main (String[] args) // method to test the class.
  {
    IGraph<Double, Integer> graph = new Graph<Double, Integer>();
    graph.addNode(1.1);
    INode<Double> n1 = new Node<Double>(1.1);
    graph.addNode(2.2);
    INode<Double> n2 = new Node<Double>(2.2);
    graph.addNode(3.3);
    INode<Double> n3 = new Node<Double>(3.3);
    graph.addNode(4.4);
    INode<Double> n4 = new Node<Double>(4.4);
    graph.addEdge(n1, n2, 400);
    graph.addEdge(n2, n3, 45);
    graph.addEdge(n3, n4, 40);
    graph.addEdge(n2, n4, 34);
    graph.addEdge(n1, n4, 100);
    IEdge<Double, Integer>[] edges = (IEdge<Double, Integer>[])new IEdge[5];
    edges = graph.getEdgesTo(n1);
    for (int i =0; i < edges.length; i++)
    {
      System.out.println(edges[i]);
    }

  }
}
