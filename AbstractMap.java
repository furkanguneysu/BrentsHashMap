import java.util.Iterator;

public abstract class AbstractMap<K,V> implements Map<K,V> {

	public boolean isEmpty() { return size() == 0;}
	
	protected static class MapEntry<K,V> implements Entry<K,V>{
		
		private K k;
		private V v;
		
		public MapEntry(K key,V value){
			
			k=key;
			v=value;
			
		}
		
		public K getKey() { return k;}
		public V getValue() { return v; }
		
		protected void setKey(K key) { k = key;}
		protected V setValue(V value) {
			
			V old = v;
			v = value;
			return old;
			
		}
		
		 public String toString() { return "<" + k + ", " + v + ">"; }
		 
		 
		
		
	}
	
	 private class KeyIterator implements Iterator<K> {
	        private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet
	        public boolean hasNext() { return entries.hasNext(); }
	        public K next() { return entries.next().getKey(); }             // return key!
	        public void remove() { throw new UnsupportedOperationException("remove not supported"); }
	    } //----------- end of nested KeyIterator class -----------

	    //---------------- nested KeyIterable class ----------------
	    private class KeyIterable implements Iterable<K> {
	        public Iterator<K> iterator() { return new KeyIterator(); }
	    } //----------- end of nested KeyIterable class -----------


	    @Override
	    public Iterable<K> keySet() { return new KeyIterable(); }

	    //---------------- nested ValueIterator class ----------------
	    private class ValueIterator implements Iterator<V> {
	        private Iterator<Entry<K,V>> entries = entrySet().iterator();   // reuse entrySet
	        public boolean hasNext() { return entries.hasNext(); }
	        public V next() { return entries.next().getValue(); }           // return value!
	        public void remove() { throw new UnsupportedOperationException("remove not supported"); }
	    } //----------- end of nested ValueIterator class -----------

	    //---------------- nested ValueIterable class ----------------
	    private class ValueIterable implements Iterable<V> {
	        public Iterator<V> iterator() { return new ValueIterator(); }
	    } //----------- end of nested ValueIterable class -----------


	    @Override
	    public Iterable<V> values() { return new ValueIterable(); }
	
}
