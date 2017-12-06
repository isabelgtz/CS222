public class SingleLinkList<T> implements IList<T>
{
  private class Link<T> implements ISLink<T>
  {
    private T data;
    private ISLink<T> next;

    public Link (T d, Link<T> n)
    {
      data = d;
      next = n;
    }

    public void setNext (ISLink<T> n)
    {
      next = n;
    }

    public ISLink<T> getNext()
    {
      return next;
    }

    public void setValue (T data)
    {
      this.data = data;
    }

    public T getValue()
    {
      return data;
    }
  }

  private ISLink<T> head;
  private ISLink<T> tail;
  private ISLink<T> curr;
  private int size;

  public SingleLinkList()
  {
    size = 0;
    head = null;
    tail = null;
    curr = head;
  }


  public void insert (int idx, T v)
  {
    ISLink<T> new_link = new Link<T>(v, null);
    size++;
    if (idx == 0)
    {
      new_link.setNext(head);
      head = new_link;
    }
    else
    {
      curr= head;
      for (int i = 1; i < idx; i++)
      {
        curr = curr.getNext();
      }
      new_link.setNext(curr.getNext());
      curr.setNext(new_link);
    }
  }

  public void append(T v)
  {
    ISLink<T> new_link = new Link<T>(v, null);
    size++;
    if (head == null)
    {
      head = new_link;
      tail = head;
      return;
    }
    else
    {
      curr = head;
      while(curr.getNext() != null ){
        curr = curr.getNext();}
      curr.setNext(new_link);
    }
    curr = tail;
  }

  public int size()
  {
    return size;
  }


  public void remove (int idx)
  {
    size--;
    curr = head;
    if (idx == 0)
    {
      head = head.getNext();
    }
    else
    {
      for (int i = 1; i < idx; i++)
      {
        curr = curr.getNext();
      }
      curr.setNext(curr.getNext().getNext());
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
    else if (index == size)
      return tail.getValue();
    else
    {
      curr = head;
      T value = null;
      for (int i = 0; i < size; i ++)
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

  public void next()
  {
    if (curr.getNext() != null)
      curr = curr.getNext();
  }

  public void prev()
  {
    ISLink<T> temp = new Link<T>(null, null);
    temp = curr;
    curr = head;
    while (curr.getNext() != null)
    {
      curr = curr.getNext();
      if( curr.getNext() == temp)
      {
        break;
      }
    }
  }

  public void jumpToTail()
  {
    curr = tail;
  }

  public void jumpToHead()
  {
    curr = head;
  }

  public boolean isEmpty()
  {
    return (head == null);
  }

  public void remove()
  {
    if (isEmpty())
    {

    }
    else
    {
      if (size == 1)
      {
        head = null;
        tail = null;
        curr = head;
        size = 0;
      }
      else
      {
        size--;
        this.prev();
        if ((curr.getNext() != null) && (curr.getNext().getNext() != null))
          curr.setNext(curr.getNext().getNext());
      }
    }
  }

  public void move (int start_index, int end_index)
  {
    T value = null;
    if ( start_index == 0)
    {
      value = head.getValue();
    }
    else if ( start_index == size-1)
    {
      value = tail.getValue();
    }
    else
    {
      curr = head.getNext();
      for (int i = 1; i < size; i++)
      {
        if (i == start_index)
        {
          value = curr.getValue();
          break;
        }
        curr = curr.getNext();
      }
    }
    remove(start_index);
    insert(end_index, value);
  }
  public void printList()
  {
      System.out.print("\n Singly Linked List = ");
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
      ISLink<T> ptr = head;
      System.out.print(head.getValue()+ " -> ");
      ptr = head.getNext();
      while (ptr.getNext() != null)
      {
          System.out.print(ptr.getValue()+ " -> ");
          ptr = ptr.getNext();
      }
      System.out.print(ptr.getValue()+ "\n");
  }
//
  public static void main (String[] args)
{
  SingleLinkList<Integer> sll = new SingleLinkList<Integer>();
  sll.append(10);
  sll.append(20);
  sll.append(30);
  sll.append(40);
  sll.append(50);
  sll.printList();
  sll.insert(0, 1000);
  System.out.println("-------");
  sll.printList();
  sll.move(2, 4);
  System.out.println("-------");
  sll.printList();


}

}
