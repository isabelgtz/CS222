public class DoubleLinkList<T> implements IList<T>
{
  private class Link<T> implements IDLink<T>
  {
    private T data;
    private IDLink<T> next;
    private IDLink<T> prev;

    public Link(T d, IDLink<T> n, IDLink<T> p)
    {
      data = d;
      next = n;
      prev = p;
    }

    public void setNext(IDLink<T> _next)
    {
      next = _next;
    }

    public void setPrev(IDLink<T> _prev)
    {
      prev = _prev;
    }

    public void setValue(T _data)
    {
      data = _data;
    }

    public IDLink<T> getNext()
    {
      return next;
    }

    public IDLink<T> getPrev()
    {
      return prev;
    }

    public T getValue()
    {
      return data;
    }

  }

  private IDLink<T> head;
  private IDLink<T> tail;
  private IDLink<T> curr;
  private int size;

  public DoubleLinkList()
  {
    head = null;
    tail = null;
    curr = head;
    size = 0;
  }

  public boolean isEmpty()
  {
    return (head == null);
  }

  public int size()
  {
    return size;
  }

  public void append(T v)
  {
    IDLink<T> new_link = new Link<T>(v, null, null);
    if (head == null)
    {
      head = new_link;
      tail = head;
    }
    else
    {
      new_link.setPrev(tail);
      tail.setNext(new_link);
      curr = tail;
      tail = new_link;
    }
    size++;
  }

  public void insert (int index, T v)
  {
    IDLink<T> new_link = new Link<T>(v, null, null);
    if (index == 0)
    {
      head.setPrev(new_link);
      new_link.setNext(head);
      head = new_link;
    }
    else
    {
      curr = head;
      for (int i =1; i< size; i++)
      {
        if (i == index)
        {
          IDLink<T> temporary = curr.getNext();
          curr.setNext(new_link);
          new_link.setPrev(curr);
          new_link.setNext(temporary);
          temporary.setPrev(new_link);

        }
        curr.getNext();
      }
    }
    size++;
  }

  public void remove(int index)
  {
    size--;
    if (index == 0)
    {
      if (size == 1)
      {
        head = null;
        tail = null;
        return;
      }
      head = head.getNext();
      head.setPrev(null);
      return;
    }
    else if (index == size)
    {
      tail = tail.getPrev();
      tail.setNext(null);
      return;
    }
    else
    {
      curr = head.getNext();
      for (int i = 1; i < size; i ++)
      {
        if ( i == index )
        {
          break;
        }
        else if (curr.getNext() != null)
        {
          curr = curr.getNext();
        }
      }
      if (curr.getNext() == null)
      {
        curr.getPrev().setNext(null);
        tail = curr.getPrev();
        return;
      }
      else
      {
        curr.getNext().setPrev(curr.getPrev());
        curr.getPrev().setNext(curr.getNext());
        return;
      }
    }
  }

  public void remove()
  {
    if (isEmpty())
    {
    }
    else
    {
      if ( size == 1)
      {
        head = null;
        tail = null;
        size = 0;
      }
      else if (curr.getNext() == null)
      {
        if (curr.getPrev() != null)
        {
          curr.getPrev().setNext(null);
          tail = curr.getPrev();
        }

      }
      else
      {
        curr.getNext().setPrev(curr.getPrev());
        curr.getPrev().setNext(curr.getNext());
      }
    }
  }

  public void move (int start_index, int end_index)
  {
    curr = head.getNext();
    T value = null;
    for (int i = 1; i < size; i ++)
    {
      if ( i == start_index )
      {
        value = curr.getValue();
      }
      else if (curr.getNext() != null)
      {
        curr = curr.getNext();
      }
    }
    this.insert(end_index, value);
    if (start_index < end_index)
    {
      this.remove(start_index);
    }
    else if (start_index > end_index && start_index < size)
    {
      this.remove(start_index+2);
    }
  }

  public T fetch()
  {
    return curr.getValue();
  }

  public T fetch (int index)
  {
    if (index == 0)
      return head.getValue();
    else if (index == size-1)
      return tail.getValue();
    else
    {
      curr = head.getNext();
      T value = null;
      for (int i = 1; i < size; i ++)
      {
        if ( i == index )
        {
          value = curr.getValue();
        }
        if (curr.getNext() != null)
        {
          curr = curr.getNext();
        }
      }
      return value;
    }
  }

  public void next ()
  {
    if (curr.getNext() != null)
      curr = curr.getNext();
  }

  public void prev()
  {
    if (curr.getPrev() != null )
      curr = curr.getPrev();
  }

  public void jumpToTail()
  {
    curr = tail;
  }

  public void jumpToHead()
  {
    curr = head;
  }

  public void printList()
  {
      System.out.print("\nDoubly Linked List = ");
      if (size == 0)
      {
          System.out.print("empty\n");
          return;
      }
      if (head.getNext() == null)
      {
          System.out.println(head.getValue() );
          return;
      }
      IDLink<T> ptr = head;
      System.out.print(head.getValue()+ " <-> ");
      ptr = head.getNext();
      while (ptr.getNext() != null)
      {
          System.out.print(ptr.getValue()+ " <-> ");
          ptr = ptr.getNext();
      }
      System.out.print(ptr.getValue()+ "\n");
  }

  public static void main (String[] args)
{
  DoubleLinkList<Integer> dll = new DoubleLinkList<Integer>();
  dll.append(10);
  dll.append(20);
  dll.append(30);
  dll.append(40);
  dll.append(50);
  dll.printList();
  System.out.println("-------");
  dll.move(3,0);
  dll.printList();

}
}
