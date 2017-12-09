// some parts of this code were taken from the code we wrote together as a class.

public class BSTree<K extends Comparable<K>, V> implements IDict<K, V>
{
  private class Node<K extends Comparable<K>, V>
  {
    private K key;
    private V value;
    private Node<K, V> left;
    private Node<K, V> right;

    public Node (K k, V v)
    {
      key = k;
      value = v;
      right = left = null;
    }
    public K getKey() {return key; }
    public V getValue() {return value; }
    public Node<K, V> getLeft() { return left; }
    public Node<K, V> getRight() { return right; }
    public void setKey( K k) { key = k; }
    public void setValue( V v) { value = v; }
    public void setLeft(Node<K, V> l) { left = l;}
    public void setRight(Node<K, V> r) { right = r;}
    public boolean isLeaf()
    {
      if (left == null && right == null)
        return true;
      else
        return false;
    }

    public boolean oneChild()
    {
      if (left == null || right == null)
        return true;
      else
        return false;
    }
  }

  private int size;
  private Node<K, V> root;
  private Node<K, V> curr;

  public BSTree()
  {
    root = null;
    curr = null;
    size = 0;
  }

  public V add (K k, V v)
  {
    Node<K, V> new_node = new Node<K, V>(k, v);
    curr = root;
    size++;
    if (root == null)// if tree is empty, new node becomes the root.
    {
      root = new_node;
      return null;
    }
    else
    {
      return helper(k, v);
    }
  }

  public V helper (K k, V v)
  {
    Node<K, V> new_node = new Node<K, V>(k, v);
    if (k.compareTo(curr.getKey()) == 0)
    {
      V value = curr.getValue();
      curr.setValue(v);
      return value;
    }
    if ((k.compareTo(curr.getKey()) < 0 && curr.getLeft() == null) || (k.compareTo(curr.getKey()) > 0 && curr.getRight() == null) )
    {
      if (k.compareTo(curr.getKey()) < 0)
      {
        curr.setLeft(new_node);
      }
      else
      {
        curr.setRight(new_node);
      }
      return null;
    }
    if (k.compareTo(curr.getKey()) < 0)
      {
       curr= curr.getLeft();
      }
    else
    {
      curr = curr.getRight();
    }
    return helper(k,v);

  }

  public V remove (K k)
  {
    V value = null;
    size--;
    Node<K, V> parent = null;
    curr = root;
    while (curr.getKey() != k)
    {
      parent = curr;
      if (k.compareTo(curr.getKey()) > 0)
      {
        curr = curr.getRight();
      }
      else
      {
        curr = curr.getLeft();
      }
    }
    // at this point, curr = node we want to remove.
    value = curr.getValue();
    if ( curr.isLeaf()) // is curr has no children, remove it.
    {
      if (parent.getRight() == curr)
      {
        parent.setRight(null);
      }
      if (parent.getLeft() == curr)
      {
        parent.setLeft(null);
      }
      curr = root;
      return value;
    }

    if (curr.oneChild())
    {
      if (curr.getRight() == null)
      {
        if (parent.getRight() == curr)
        {
          parent.setRight(curr.getLeft());
        }
        else
        {
          parent.setLeft(curr.getLeft());
        }
      }
      else
      {
        if (parent.getRight() == curr)
        {
          parent.setRight(curr.getRight());
        }
        else
        {
          parent.setLeft(curr.getRight());
        }
      }
      curr=root;
      return value;
    }

    Node<K, V> swap_parent = curr;
    Node<K, V> swap_node = curr.getRight();
    while (swap_node.getLeft() != null)
    {
      swap_parent = swap_node;
      swap_node = swap_node.getLeft();
    }
    swap_parent.setLeft(swap_node.getRight());
    swap_node.setLeft(curr.getLeft());
    swap_node.setRight(curr.getRight());
    if (parent.getRight() == curr)
    {
      parent.setRight(swap_node);
    }
    if (parent.getLeft() == curr )
    {
      parent.setLeft(swap_node);
    }
    curr = root;
    return value;
  }

  public int size()
  {
    return size;
  }

  public V fetch(K k)
  {
    curr = root;
    while (k.compareTo(curr.getKey()) != 0)
    {
      if (k.compareTo(curr.getKey()) > 0)
        curr = curr.getRight();
      else
          curr = curr.getLeft();
    }
    return curr.getValue();
  }

  public K[] keys () // honestly i don't know if it works because I wouldn't find a way to test it. i couldnt get my array to print. 
  {
    curr = root;
    K[] keys = (K[]) new Comparable[size];
    this.orderKeys(curr, 0, keys);
    return keys;
  }

  public int orderKeys (Node<K, V> n, int i, K[] k)
  {
    if (n.getLeft() != null)
      i = orderKeys(n.getLeft(), i, k);
    if (n.getRight() != null)
      i = orderKeys(n.getRight(), i, k);
    k[i] = n.getKey();
    return i++;
  }


}
