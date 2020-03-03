
public class Node {

	private int key;
	private Node down;
	private SecondNode right;
	
	
	public Node(int DataToAdd) {
		
		key=DataToAdd;
		down=null;
		right=null;
		
		
	}
	public int getKey() {
		return key;
	}


	public void setKey(int key) {
		this.key = key;
	}


	public Node getDown() {
		return down;
	}


	public void setDown(Node down) {
		this.down = down;
	}


	public SecondNode getRight() {
		return right;
	}


	public void setRight(SecondNode right) {
		this.right = right;
	}


	


	
	
	
	
	
	
}
