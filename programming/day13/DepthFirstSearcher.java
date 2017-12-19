import java.util.*;


public class DepthFirstSearcher<N,W> implements ISearcher<N,W>
{

  public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e)throws UnderFlowException, OverFlowException
  {
    boolean path = false;
    Stack <INode<N>> stack = new Stack<INode<N>>();
    Graph<N, W> graph = (Graph<N,W>)g;
    s = (Node<N>)s;
    e = (Node<N>)e;
    if (s.getValue().equals(e.getValue())) { return true; }
    Node<N> source = (Node<N>)s;
    stack.push(source);
    source.visited();
    while (! stack.isEmpty())
    {
      Node<N> node = (Node<N>)stack.pop();
      node.visited();
      if (node == e)
      {
        path= true;
        break;
      }
      else
      {
        INode<N>[] neighbors = graph.getNeighbors(node);
        for (int i =0; i < neighbors.length; i++)
        {
          Node<N> n = (Node<N>) neighbors[i];
          if (n != null &&  !n.visitedStatus())
          {
            stack.push(n);
          }
        }
      }
    }
    graph.clearNodes();
    return path;
  }

  public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e)throws UnderFlowException, OverFlowException
  {
    if (!pathExists(g, s, e))
    {
      return null;
    }

    Stack <INode<N>> stack = new Stack<INode<N>>();
    DoubleLinkList<INode<N>> list = new DoubleLinkList <INode<N>>();
    Graph<N, W> graph = (Graph<N,W>)g;
    Node<N> source = (Node<N>)s;
    stack.push(source);
    source.visited();
    while (! stack.isEmpty())
    {
      Node<N> node = (Node<N>)stack.pop();
      if (node == e)
      {
        list.append(node);
        graph.clearNodes();
        return list;
      }
      else if (graph.getNeighbors(node) == null || graph.neighborsVisited(node) ){ continue;}
      else
      {
        list.append(node);
        node.visited();
        INode<N>[] neighbors = graph.getNeighbors(node);
        for (int i =neighbors.length-1; i >= 0; i--)
        {
          Node<N> n = (Node<N>) neighbors[i];
          if (n != null &&  !n.visitedStatus())
          {
            stack.push(n);
            n.visited();
          }
        }
      }
    }
    graph.clearNodes();
    return list;
  }

}
