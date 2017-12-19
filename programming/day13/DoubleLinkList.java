/**
 * Doubly Linked list implementation of the IList interface
 */
public class DoubleLinkList<T> implements IList<T> {
    IDLink<T> head;
    IDLink<T> tail;
    IDLink<T> curr;

    public DoubleLinkList() {
        // Creates new empty links for the head and tail. Not counted
        // as in the list, but can make the implementation easier.
        head=new DLink<T>();
        tail=new DLink<T>();
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
    public void insert(int idx, T v) {
        // Generate the new link to insert
        IDLink<T> n=new DLink<T>();
	    n.setValue(v);
        // Handle the head as a special case
	    if(idx==0) {
	        n.setNext(head.getNext());
	        n.setPrev(head);
	        head.setNext(n);
	        n.getNext().setPrev(n);
	        return;
	    }
        // Advance to the right place for insertion
	    IDLink<T> s=head;
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
	public void append(T v) {
        // Make the new node
	    IDLink<T> n=new DLink();
	    n.setValue(v);
        // Jump to the end of the list
	    IDLink<T> p=tail.getPrev();
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
	    IDLink<T> p=curr.getPrev();
	    IDLink<T> n=curr.getNext();
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
	    T t=fetch(sidx);
        // Remove the node
	    remove();
        // Put the value into the correct location in the list
	    insert(didx, t);
	}

	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public T fetch() {
        // Just return the value... possible problem since there is no
        // check that curr is in the list
	    return curr.getValue();
	}

	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch(int idx) {
        // Loop to the right place in the list
	    IDLink<T> c=head;
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
	    IDLink<T> c=head;
	    while(c.getNext()!=tail) { i++; c=c.getNext(); }
	    return i;
	}

    // Implementation for the links...
	class DLink<T> implements IDLink<T> {
	    IDLink next;
	    IDLink prev;
	    T value;

	    public DLink() {
            // Empty constructor, everything can be null
	    }

	    /**
         * Gets the current value for this link cell
         * @return the value
         */
        public T getValue() { return value; }

        /**
         * Sets the current value for this link cell
         * @param v the value to place in this cell
         */
        public void setValue(T v) { value=v; }

        /**
         * Gets the next cell in the list
         * @return the cell
         */
        public IDLink<T> getNext() { return next; }

        /**
         * Gets the previous cell in the list
         * @return the cell
         */
        public IDLink<T> getPrev() { return prev; }

        /**
         * Sets the next cell in the list
         * @param c the next cell
         */
        public void setNext(IDLink<T> c) { next=c; }

        /**
         * Sets the next cell in the list
         * @param c the next cell
         */
        public void setPrev(IDLink<T> c) { prev=c; }
        public String toString()
        {
          return "" + value;
        }
	}


}
