/**
 * Doubly Linked list implementation of the IList interface
 */
public class DoubleLinkList<K extends Comparable<K>,V> implements IList<K, V> {
  // Implementation for the links...
  private class DLink<K extends Comparable<K>,V> implements IDLink<K, V>
  {
      private IDLink<K, V> next;
      private IDLink<K, V> prev;
      private V value;
      private K key;

      public DLink() {  }

      public DLink(V v, K k)
      {
        key = k;
        value = v;
      }

      public V getValue() { return value; }

      public void setValue(V v) { value=v; }

      public IDLink<K, V> getNext() { return next; }

      public IDLink<K, V> getPrev() { return prev; }

      public void setNext(IDLink<K, V> c) { next=c; }

      public void setPrev(IDLink<K, V> c) { prev=c; }

      public K getKey() {return key; }

      public void setKey (K k) { key = k; }
  }

    IDLink<K, V> head;
    IDLink<K, V> tail;
    IDLink<K, V> curr;

    public DoubleLinkList() {
        // Creates new empty links for the head and tail. Not counted
        // as in the list, but can make the implementation easier.
        head=new DLink<K, V>();
        tail=new DLink<K, V>();
        head.setPrev(head);
        head.setNext(tail);
        tail.setPrev(head);
        tail.setNext(tail);
        curr=head;
    }

    /**
     * Inserts an item at a specific index in the list
     * @param idx where the item should be inserted
     * @param v the value to insert
     */
    public void insert(int idx, K k, V v) {
        // Generate the new link to insert
      IDLink<K, V> n =new DLink<K, V>(v, k);
        // Handle the head as a special case
	    if(idx==0) {
	        n.setNext(head.getNext());
	        n.setPrev(head);
	        head.setNext(n);
	        n.getNext().setPrev(n);
	        return;
	    }
        // Advance to the right place for insertion
	    IDLink<K, V> s=head;
	    for(int i=0;i<idx;i++) {
	        s = s.getNext();
	    }
        // Execute the insertion... No check to make sure the tail is protected
	    n.setNext(s.getNext());
        n.setPrev(s);
        s.setNext(n);
        n.getNext().setPrev(n);
    }

	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(K k, V v) {
        // Make the new node
	    IDLink<K, V> n =new DLink<K, V>(v, k);
        // Jump to the end of the list
	    IDLink<K, V> p=tail.getPrev();
        // Insert the node
	    n.setPrev(p);
	    n.setNext(tail);
	    p.setNext(n);
	    tail.setPrev(n);
	    curr=n;
	}


	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
	 * the previous item in the list, if such element exists.
	 */
	public void remove() {
        // Get the nodes on each side of the node to remove
	    IDLink<K, V> p=curr.getPrev();
	    IDLink<K, V> n=curr.getNext();
        // Link them to each other
	    n.setPrev(p);
	    p.setNext(n);
        // Move curr back one so that it points to the correct element as
        // specified in the comment
	    curr=p;
	    if(curr==head) { curr=curr.getNext(); }
	}

	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx) {
        // Advance curr to the node to remove
	    fetch(idx);
        // Call the remove method
	    remove();
	}

	/**
	 * Changes the location of an existing element in the list
	 * @param sidx - The initial index for the element to move
	 * @param didx - The final index for the element to move
	 */
	public void move(int sidx, int didx) {
        // Advance curr to the node to remove and capture the value
	    K t=fetch(sidx);
      V v = fetchValue(sidx);
        // Remove the node
	    remove();
        // Put the value into the correct location in the list
	    insert(didx, t, v);
	}

	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public K fetch() {
        // Just return the value... possible problem since there is no
        // check that curr is in the list
	    return curr.getKey();
	}

  public V fetchValue()
  {
    return curr.getValue();
  }

	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public K fetch(int idx) {
        // Loop to the right place in the list
	    IDLink<K, V> c=head;
	    for(int i=0; i<idx; i++) { c=c.getNext(); }
	    curr = c.getNext();
        // Returen the value
	    return curr.getKey();
	}

  public V fetchValue(int idx) {
        // Loop to the right place in the list
      IDLink<K, V> c=head;
      for(int i=0; i<idx; i++) { c=c.getNext(); }
      curr = c.getNext();
        // Returen the value
      return curr.getValue();
  }

	/**
	 * Advances the <i>current</i> index to the next index, if possible.
	 */
	public void next() { curr = curr.getNext(); }

	/**
	 * Advances the <i>current</i> index to the previous index, if possible.
	 */
	public void prev() { curr = curr.getPrev(); }

	/**
	 * Advances the <i>current</i> to the tail element
	 */
	public void jumpToTail() { curr = tail.getPrev(); }

	/**
	 * Advances the <i>current</i> to the head element
	 */
	public void jumpToHead() { curr = head.getNext(); }

	/**
	 * Returns the number of elements in the list
	 */
	public int size() {
        // I don't keep a size, so the list must be scanned to compute this
	    int i=0;
	    IDLink<K, V> c=head;
	    while(c.getNext()!=tail) { i++; c=c.getNext(); }
	    return i;
	}
}
