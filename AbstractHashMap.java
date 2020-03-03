import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {

	 	protected int n = 0;                 // number of entries in the dictionary
	    protected int capacity;              // length of the table
	   

	    /** Creates a hash table with the given capacity and prime factor. */
	    public AbstractHashMap(int cap) {
	        capacity = cap;
	        createTable();
	    }

	    /** Creates a hash table with given capacity and prime factor 109345121. */
	    //public AbstractHashMap(int cap) { this(cap); }  // default prime

	    /** Creates a hash table with capacity 17 and prime factor 109345121. */
	   // public AbstractHashMap() { this(17); }                     // default capacity

	    // public methods

	    @Override
	    public int size() { return n; }


	    @Override
	    public V get(K key) { return bucketGet(key); }


	    @Override
	    public V remove(K key) { return bucketRemove(key); }


	    @Override
	    public V put(K key, V value) {
	        V answer = bucketPut(key, value);
	        
	        return answer;
	    }

	    // private utilities
	    /** Hash function applying MAD method to default hash code. */
	    
	    // protected abstract methods to be implemented by subclasses
	    /** Creates an empty table having length equal to current capacity. */
	    protected abstract void createTable();


	    protected abstract V bucketGet(K k);


	    protected abstract V bucketPut(K k, V v);


	    protected abstract V bucketRemove(K k);
	    
	    
	
	
	
}
