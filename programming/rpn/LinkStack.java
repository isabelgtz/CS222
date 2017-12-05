// this code was taken from the class lecture. 

public class LinkStack<T> implements IStack<T>
{
  private class Cell<T>
  {
    private T value;
    private Cell<T> ptr;

    public Cell(T v, Cell<T> p)
    {
      value = v;
      ptr = p;
    }

    public void setValue( T v)
    {
      value = v;
    }

    public T getValue()
    {
      return value;
    }

    public void setPtr(Cell<T> p)
    {
      ptr = p;
    }

    public Cell<T> getPtr()
    {
      return ptr;
    }
  }

  private Cell<T> top;
  private int size;

  public LinkStack( )
  {
    size = 0;
    top = null;
  }

  public void push(T v) throws OverFlowException
  {
    Cell<T> n = new Cell<T>(v, top);
    top = n;
    size++;
  }

  public T pop() throws UnderFlowException
  {
    if (size ==0 ) {throw new UnderFlowException(); }
    T v = top.getValue();
    top = top.getPtr();
    size--;
    return v;
  }

  public boolean isEmpty() {
      if(size==0) {
          return true;
      }
      return false;
  }

  public static void main(String[] argv) throws Exception {
      LinkStack<Integer> ls = new LinkStack<Integer>();
      ls.push(1);
      ls.push(2);
      while(!ls.isEmpty()) {
          System.out.println(ls.pop());
      }
  }

}
