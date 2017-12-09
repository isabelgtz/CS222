public class Dict<K extends Comparable<K>, V> implements IDict<K, V>
{
  private DoubleLinkList<K, V> list;

  public Dict()
  {
    list = new DoubleLinkList<K, V>();
  }

  public V add (K k, V v)
  {
    int index = 0;
    V value_replaced = null;
    for (int i = 0; i < list.size(); i++)
    {
      if (k.compareTo(list.fetch(i)) == 0) // replace
      {
        index = i;
        value_replaced = list.fetchValue(i);
        break;
      }
      else if (k.compareTo(list.fetch(i)) < 0) // new k is smaller, insert here.
      {
        index = i;
        break;
      }
    }
    list.insert(index, k, v);
    return value_replaced;

  }

  public V remove (K k)
  {
    V value_removed = null;
    for (int i = 0; i < list.size(); i++)
    {
      if (k.compareTo(list.fetch(i)) == 0)
      {
        value_removed = list.fetchValue(i);
        list.remove(i);
      }
    }
    return value_removed;
  }

  public int size()
  {
    return list.size();
  }

  public V fetch(K k)
  {
    list.jumpToHead();
    V value = null;
    for (int i = 0; i < list.size(); i++)
    {
      if (k.compareTo(list.fetch(i)) == 0)
      {
        value = list.fetchValue(i);
        break;
      }
      else
      {
        list.next();
      }
    }
    return value;

  }

  public K[] keys ()
  {
    K[] keys;
    if (list.size() < 0  )
    {
      keys = (K[]) new Comparable[0];
      return keys;
    }
    else

    {
      list.jumpToHead();
      keys = (K[]) new Comparable[list.size()];
      for (int i= 0; i < keys.length; i++)
      {
        keys[i] = list.fetch();
        list.next();
      }
      return keys;
    }
  }


}
