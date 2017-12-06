public class ArrayList<T> implements IList<T>
{

  private T[] array;
  private int curr;

  public ArrayList()
  {
    array = (T[]) new Object[0];
    curr = array.length-1;
  }


  public void insert (int idx, T v)
  {
    T[] manipulated_array = (T[]) new Object[array.length+1];
    for ( int i = 0; i < idx; i++)
    {
      manipulated_array[i] = array[i];
    }
    manipulated_array[idx] = v;
    for( int i = idx; i < array.length; i++)
    {
      manipulated_array[i+1] = array[i];
    }
    array = manipulated_array;
  }
  public void append (T v)
  {
    T[] manipulated_array = (T[]) new Object[array.length+1];
    for (int i = 0; i < array.length; i++)
    {
      manipulated_array[i]= array[i];
    }

    manipulated_array[array.length] = v;
    array = manipulated_array;
    curr = array.length-1;
  }

  public void remove (int idx)
  {
    if ((idx < array.length) && (idx > -1))
    {
      T[] manipulated_array = (T[]) new Object[array.length-1];
      int count = 0;
      for (int i = 0; i < array.length; i++)
      {
        if (i==idx){ count=1; }
        else if(i < idx)
        {
          manipulated_array[i] = array[i];
        }
        else
        {
          manipulated_array[i-count] = array[i];
        }
      }
        array = manipulated_array;
    }

  }

  public void remove()
  {
    if ( curr < 0 || curr > array.length-1)
    {

    }
    else
    {
      remove(curr);
      if (curr > 0)
        curr--;
    }
  }

  public void move (int start_index, int end_index)
  {
    if (start_index < array.length && start_index > -1 && end_index < array.length && end_index >-1)
    {
      T temp = array[start_index];
     this.remove(start_index);
     if (end_index == 0)
     {
      this.insert(end_index, temp);
     }
     else if (start_index < end_index && end_index +1 < array.length)
      {
        this.insert(end_index+1, temp);
      }
     else if (end_index > 0 )
      {
        this.insert(end_index-1, temp);
      }
    }

  }

  public T fetch()
  {
    return array[curr];
  }

  public T fetch(int idx)
  {
    return array[idx];
  }

  public void next()
  {
    if (curr >= array.length-1){}
    else
      curr++;
  }

  public void prev()
  {
    if ( curr==0)
    {

    }
    else
      curr--;
  }

  public void jumpToTail()
  {
    curr = array.length-1;

  }

  public void jumpToHead()
  {
    curr = 0;
  }

  public int size()
  {
    return array.length;
  }

  public void printArray()
  {
    for (int i = 0; i < array.length; i++)
    {
      System.out.println(array[i]);
    }
  }


  public static void main (String[] args)
  {
    ArrayList<Integer> arraylist = new ArrayList<Integer>();
    for (int i = 0; i<20; i++)
    {
      arraylist.append(i);
    }
    arraylist.move(0,4);
    arraylist.printArray();
    System.out.println("arraylist size: " +arraylist.size() + " ---> should be 100");
  }

}
