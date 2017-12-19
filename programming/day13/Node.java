public class Node<N> implements INode<N>
{
  private N value;
  private boolean visited;

  public Node(N v)
  {
    value = v;
    visited = false;
  }

  public Node()
  {
    value = null;
    visited = false;
  }

  public void setValue(N v)
  {
    value = v;
  }

  public N getValue()
  {
    return value;
  }

  public String toString()
  {
    return "" + value;
  }

  public void visited()
  {
    visited = true;
  }

  public void clearVisited()
  {
    visited = false;
  }

  public boolean visitedStatus()
  {
    return visited;
  }

  public boolean equals(Node<N> n)
  {
    if (n.getValue().equals(value))
    {
      return true;
    }
    else
    {
      return false; 
    }
  }

}
