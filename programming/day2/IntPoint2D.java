public class IntPoint2D implements IIntPoint2D
{
  private int x;
  private int y;

  public IntPoint2D (int _x, int _y)
  {
    x = _x;
    y = _y;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public int manhattanDistance(IIntPoint2D o)
  {
    return (Math.abs(x - o.getX())) + (Math.abs(y - o.getY()));
  }

  public double distance (IIntPoint2D o)
  {
    return Math.sqrt( Math.pow((o.getX() - x), 2) + Math.pow((o.getY() - y), 2) ) ;
  }

  public String toString()
  {
    return "(" + x + ", " + y + ")" ;
  }

  public boolean equals (IIntPoint2D o)
  {
    if ( (o.getX() == x) && (o.getY() == y) )
      return true;
    else
        return false;
  }

  public int hashcode()
  {
    return (x << 16) +y;
  }


}
