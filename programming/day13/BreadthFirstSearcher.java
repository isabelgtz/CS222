import java.util.*;


public class BreadthFirstSearcher<N, W> implements ISearcher<N,W>
{

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e) throws UnderFlowException, OverFlowException
  {
    s = (Node<N>)s;
    e = (Node<N>)e;
    if (s.getValue().equals(e.getValue())) { return true; }

    Graph<N, W> graph = (Graph<N,W>)g;
    int size = graph.getNodeSetSize();
    ArrayQueue <INode<N>> queue = new ArrayQueue<INode<N>>(size);
    Node<N> source = (Node<N>)s;
    queue.enqueue(source);
    source.visited();
    while (! queue.isEmpty())
    {
      INode<N> node = new Node<N>();
      node = queue.dequeue();
      if (node == e)
      {
        return true;
      }
      INode<N>[] neighbors = graph.getNeighbors(node);
      for (int i =0; i < neighbors.length; i++)
      {
        Node<N> n = (Node<N>) neighbors[i];
        if (n != null &&  !n.visitedStatus())
        {
          queue.enqueue(n);
          n.visited();
        }
      }

    }
    graph.clearNodes();
    return false;
  }

  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e) throws UnderFlowException, OverFlowException
  {
    ArrayList<IEdge<N, W>> list = new ArrayList<IEdge<N, W>>();
    Graph<N, W> graph = (Graph<N,W>)g;
    int size = graph.getEdgeSetSize();
    ArrayQueue <IEdge<N, W>> queue = new ArrayQueue<IEdge<N, W>>(size);
    IEdge<N, W>[] source_edges = graph.getEdgesFrom(s);
    for (IEdge<N, W> edge: source_edges)
    {
      queue.enqueue(edge);
    }
    while (!queue.isEmpty())
    {
      Edge<N, W> curr = (Edge<N, W>) queue.dequeue();
      list.add(curr);
      Node<N> curr_node = (Node<N>) curr.getDestination();
      if (curr_node == e)
      {
        break;
      }
      else{
        IEdge<N, W>[] curr_neighbors = graph.getEdgesFrom(curr_node);
        for (IEdge<N, W> edge: curr_neighbors)
        {
          queue.enqueue(edge);
        }
      }
    }
    ArrayList<IEdge<N, W>> path = new ArrayList<IEdge<N, W>>();
    IEdge<N, W> dest = list.get(list.size()-1);
    path.add(dest);
    INode<N> prev = dest.getSource();
    while (!prev.equals(s))
    {
      for (int i =0; i < list.size(); i++)
      {
        if (list.get(i).getDestination().equals(prev))
        {
          path.add(0, list.get(i));
          prev = list.get(i).getSource();
        }
      }
    }

    DoubleLinkList<INode<N>> node_path = new DoubleLinkList <INode<N>>();
    Edge<N, W> first = (Edge<N, W>) path.get(0);
    node_path.append(first.getSource());
    for (int i = 0; i < path.size(); i++ )
    {
      Edge<N, W> edge = (Edge<N, W>) path.get(i);
      node_path.append(edge.getDestination());
    }
    return node_path;
  }

}
