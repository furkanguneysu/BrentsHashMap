
public class Bucket{
	
	private String Word;
	private int Key;
	private int Count;
	private int index;
	
	public Bucket(String Word) {
		
		this.Word=Word.toLowerCase();
		this.Key=StringToInt(Word.toLowerCase());
		this.Count=1;
		
	}
	
	public int StringToInt(String Word) {
		
		int g = 31;
		int hash = 0;
		
		for(int i=0;i<Word.length();i++) {
			
			hash = (hash*g+Word.charAt(i));
			
		}
		
		
		return Math.abs(hash);//String to integer will be implemented here
		
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public int getKey() {
		return Key;
	}

	public void setKey(int key) {
		Key = key;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	

	
	
	
}
