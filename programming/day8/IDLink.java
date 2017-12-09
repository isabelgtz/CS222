/**
 * The interface for the link cells in a doubly linked list
 */
public interface IDLink <K extends Comparable<K>,V> {
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public V getValue();

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(V v);

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink<K, V> getNext();

    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink<K, V> getPrev();

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink<K, V> c);

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink<K, V> c);

    public K getKey();

    public void setKey(K k);
}
