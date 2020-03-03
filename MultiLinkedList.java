
public class MultiLinkedList {
	
	private FirstNode firsthead;
	
	public MultiLinkedList() {
		
		firsthead = null;
		
	}
	
	public int getFirst(int index) {
		
		FirstNode temp = firsthead;
		
		for(int i=0;i<index;i++) {
			
			temp=temp.getDown();
			
		}
		
		return temp.getKey();
		
	}
	
	
	
	public int getSecond(int indexfn,int indexSn) {
		
		FirstNode temp = firsthead;
		for(int i=0;i<indexfn;i++) {
			
			temp=temp.getDown();
			
		}
		
		SecondNode temp2 = temp.getRight();
		
		for(int i=0;i<indexSn;i++) {
			
			temp2=temp2.getLink();
			
		}
		
		return temp2.getKey();
		
		
	}
	
	public int getFirstSize() {
		int count = 0;
		
		if(firsthead == null) {
			
			System.out.println("empty");
			
		}
		else {
		FirstNode temp = firsthead;
		while(temp!=null) {
			count++;
			temp=temp.getDown();
			
		}
		}
		return count;
		
	}
	
	public int getSecondSize(int indexfn) {
		
		int count=0;
		FirstNode temp = firsthead;
		for(int i=0;i<indexfn;i++) {
			temp=temp.getDown();
			
		}
		
		SecondNode sc = temp.getRight();
		while(sc!=null) {
			
			count++;
			sc=sc.getLink();
			
		}
		
		return count;
		
	}
	
	public void addFirst(int key) {
		if(firsthead == null) {
			FirstNode newnode = new FirstNode(key);
			firsthead = newnode;
		}
		
		else {
			FirstNode temp = firsthead;
			while(temp.getDown()!=null) {
				
				temp=temp.getDown();
				
			}
			FirstNode newnode = new FirstNode(key);
			temp.setDown(newnode);
			
		}
	}
	
	public void addSecond(int indexfn,int key) {
		
		if(firsthead == null) {
			
			System.out.println("there is no first chain"); 
			
		}
		
		else {
			
			FirstNode temp = firsthead;
			
			for(int i=0;i<indexfn;i++) {
				
				temp=temp.getDown();
				
			}
			
			if(temp.getRight()==null) {		
				SecondNode newNode = new SecondNode(key);
				temp.setRight(newNode);
			}
			
			else {
				SecondNode temp2 = temp.getRight();
				while(temp2.getLink()!=null) {
					
					temp2=temp2.getLink();
					
				}
				SecondNode newNode = new SecondNode(key);
				temp2.setLink(newNode);
				
			}
			
			
		}
		
	}
	
	public int ShortestPath() {
		
		int j=0;
		int firstindx=-1;
		int min=999999999;
		
		for(int a=0;a<this.getFirstSize();a++) {
			
			j=this.getSecondSize(a);
			int i=a+1;
			if(i+j<min) {
				
				min=i+j;
				firstindx=i;
				
			}
			
		}
		   //minimum(i,j) = lastfirst(i)+1(j)
		return firstindx-1;
	
	
	
		
	
	}
	
	public void Print() {
		
		for(int i=0;i<this.getFirstSize();i++) {
			
			System.out.print(this.getFirst(i)+">");
			
			for(int j=0;j<this.getSecondSize(i);j++) {
				
				System.out.print(this.getSecond(i, j)+">");
				
			}
			
			System.out.println();
			
		}
		
	}
		
	}
	
	
	
	
	
	

