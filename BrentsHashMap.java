

public class BrentsHashMap<K,V> extends AbstractHashMap<K,V> {

	private MapEntry<K,V>[] table;
	public BrentsHashMap(int cap) {	super(cap); }
	
	
	@SuppressWarnings("unchecked")
	@Override
	protected void createTable() {
		table = (MapEntry<K,V>[]) new MapEntry[capacity];  
	}
	
	
	
	private boolean isAvailable(int j) {
		
		return table[j]==null;
		
	}
	
	private int HashFunc(int key) {//First Hash Func
		
		return key%capacity;
		
	}
	
	private int IncrementFunc(int key) {//Increment Func
		
		return (((key%capacity)+(key/capacity)+7)%capacity);
		
	}
	
	private boolean Compare(int index,V value) {//Compares the values when collusion occurs due to increment the count.
		
		Bucket temp = (Bucket) value;
		V val = table[index].getValue();
		Bucket temp2 = (Bucket) val;
		if(temp.getWord().equals(temp2.getWord())) {
			
			return true;
			
		}
		
		else {
			
			return false;
			
		}
		
		
	}
	
	public int StringToInt(String Word) {//Converts String to integer
		
		int g = 31;
		int hash = 0;
		
		for(int i=0;i<Word.length();i++) {
			
			hash = (hash*g+Word.charAt(i));
			
		}
		
		
		return Math.abs(hash);
		
	}
	
	private int findSlot(K k,V v) {//Returns an index for where to put the value 
		
		int count_up=0;
		boolean flag=false;
		MultiLinkedList mList = new MultiLinkedList();
		int key = (int) k;
		key = HashFunc(key);
		if(isAvailable(key)) {//Looks for available slot using HashFunc
			
			return key;
			
		}
		else {
			if(Compare(key,v)&&flag==false) {flag=true; count_up=key;}//Compare the occupied slot's value with the value which is to be placed
			key=IncrementFunc(key);//Increment 
			while(!isAvailable(key)) {//Creates First Chain
				if(Compare(key,v)&&flag==false) {flag=true; count_up=key;}
				mList.addFirst(key);
				key=IncrementFunc(key);
			}
			mList.addFirst(key);//No collision at the end of it.
			for(int i=0;i<mList.getFirstSize()-1;i++) {//Creates Second Chain
				int place = mList.getFirst(i);
				V value = table[place].getValue();
				Bucket temp = (Bucket) value;
				int keyForIncrement = IncrementFunc(temp.getKey());
				while(!isAvailable(keyForIncrement)) {
					if(Compare(keyForIncrement,v)&&flag==false) {flag=true; count_up=key;}
					keyForIncrement = IncrementFunc(keyForIncrement);
					mList.addSecond(i, keyForIncrement);
				}
				mList.addSecond(i, keyForIncrement);
			}
			
			int shortest_way = mList.ShortestPath();//Finding the shortest path
			
			if(flag) {//Count up if there is a collision and same values
				
				V val = table[count_up].getValue();
				Bucket temp = (Bucket) val;
				temp.setCount(temp.getCount()+1);
				table[count_up].setValue(val);
				return -1;
				
			}
			
			
			if(shortest_way==mList.getFirstSize()-1) {//There will be no changing slot due to same amount of work 
				
				
				return mList.getFirst(shortest_way);
				
				
			}
			else {//Changing slot
				V OldOne = table[mList.getFirst(shortest_way)].getValue();//Taking the old one
				int new_index=mList.getSecond(shortest_way, mList.getSecondSize(shortest_way)-1);//Getting the new index for old one
				MapEntry<K,V> val = new MapEntry(new_index,OldOne);
				table[new_index]=val;//Putting the old one to the new spot
				int a = mList.getFirst(shortest_way);//Old location assumed as a empty spot for new value and it will returned
				return a;
				
				
				
			}
			
		}
			
	}	
	
	private int LookFor(String word) {//Search for a word in HashTable
		
		int key = StringToInt(word);
		key=HashFunc(key);
		Bucket temp=(Bucket)table[key].getValue();
		
		if(temp.getWord().equals(word)) {
			return key;
		}
		else {
			while(!temp.getWord().equals(word)) {
				key=IncrementFunc(key);
				//if(!isAvailable(key)) {
				temp=(Bucket)table[key].getValue();
				//}
			}
			return key;
			
			
		}
		
	}
	
	public V Search(String word) {
		//Main search function implements LookFor() and returns a Bucket for necessary outputs
		//And also the index which is required returned by LookFor  	
		int j = LookFor(word);//get the index
		Bucket temp =(Bucket)table[j].getValue();
		temp.setIndex(j);//Set the index 
		return table[j].getValue();//Return it
		
	}
	
	
	

	@Override
	protected V bucketGet(K k) {
		
		int j = (int)k;
		return table[j].getValue();

	}

	@Override
	protected V bucketPut(K k, V v) {
		
		int j=findSlot(k,v);
		MapEntry<K,V> value = new MapEntry(k,v);
		if(j>0) {
		table[j]=value;
		}
		return null;
		
			
	}

	@Override
	protected V bucketRemove(K k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
	

}
