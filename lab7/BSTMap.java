import java.util.Set;
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value>{

    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, int size) {
            this.key = key;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public BST() {
    }

    /** Removes all of the mappings from this map. */
    public void clear(){

    }

    /* Returns the number of key-value mappings in this map. */
    public int size(){
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /* Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(Key key){
        if (key == null) {
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }


    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }



    /* Associates the specified value with the specified key in this map. */
    void put(Key key, Value value){

    }

    public void printInOrder(){

    }





    /* Returns a Set view of the keys contained in this map. */
    public Set<Key> keySet(){
        throw new NoSuchElementException("not implemented yet");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException. */
    public Value remove(Key key){
        throw new NoSuchElementException("not implemented yet");
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    public Value remove(Key key, Value value){
        throw new NoSuchElementException("not implemented yet");
    }
}
