public class Edge<N,W> implements IEdge<N, W>
{
  private INode<N> source;
  private INode<N> destination;
  private W weight;

  public Edge (INode<N> s, INode<N> d, W w)
  {
    source = s;
    destination = d;
    weight = w;
  }

  public INode<N> getSource()
  {
    return source;
  }

  public INode<N> getDestination()
  {
    return destination;
  }

  public W getWeight()
  {
    return weight;
  }

  public boolean equals (Object o)
  {
    Edge<N, W> e = (Edge<N, W>) o;
    if ((e.getSource() == this.source) && (e.getDestination() == this.destination ))
      return true;
    else
      return false;
  }

  public String toString()
  {
    return source + " --> " + destination + " w: " + weight;
  }

}
