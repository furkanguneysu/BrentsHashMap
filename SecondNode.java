
public class SecondNode {
	
	private int key;
	private SecondNode link;
	
	public SecondNode(int DataToAdd) {
		
		key=DataToAdd;
		link=null;
		
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public SecondNode getLink() {
		return link;
	}

	public void setLink(SecondNode link) {
		this.link = link;
	}

	
	

}
