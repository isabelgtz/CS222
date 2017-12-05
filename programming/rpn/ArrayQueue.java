public class ArrayQueue<T> implements IQueue<T>
{
  private T[] array;
  private int count;

  public ArrayQueue(int _size)
  {
    count = 0;
    array = (T[]) new Object[_size];
  }

  public T dequeue() throws UnderFlowException
  {
    T dequeue = array[0];
    for (int i = 1; i < count; i++)
    {
      array[i-1] = array[i];
    }

    count--;
    return dequeue;
  }

  public void enqueue (T v) throws OverFlowException
  {
    array[count] = v;
    count++;

  }

}
