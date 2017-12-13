public class Node<N> implements INode<N>
{
  private N value;

  public Node(N v)
  {
    value = v;
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

}
