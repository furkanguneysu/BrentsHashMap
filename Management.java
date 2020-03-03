import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Management {

	BrentsHashMap<Integer, Bucket> brnt = new BrentsHashMap<Integer, Bucket>(5000);
	
	public Management() {
		
		Insert();
		Search(brnt);
		
	}
	
	public void Insert() {//Insert Function implemented by using try catch block
		
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SONY\\Desktop\\story.txt"))){
			String sCurrentLine;
			while((sCurrentLine=br.readLine()) != null) {
				String[] words = sCurrentLine.split(" ");
				for(int i=0;i<words.length;i++) {
					Bucket temp = new Bucket(words[i]);
					brnt.put(temp.getKey(), temp);
				}
			}
			
			}
			
			catch(IOException e) {
				
				System.out.println("Not found");
				
			}
		
		
	}
	
	public void Search(BrentsHashMap<Integer, Bucket> brnt) {//Search Function
		
		System.out.println("--BrentsHashMap Implementation--");
		while(true) {
		System.out.print("Search:");
		Scanner scan = new Scanner(System.in);
		String entry = scan.nextLine();
		try {//Try catch block for escaping from the NullPointerException
		Bucket temp = (Bucket)brnt.Search(entry);
		System.out.println("Key:"+temp.getKey());
		System.out.println("Count:"+temp.getCount());
		System.out.println("Index:"+temp.getIndex());
		}
		
		catch(NullPointerException e) {
			
			System.out.println("Not Found");
			
		}
		
		
		System.out.println("Would you like to search again?(Y/N)");
		
			String answer = scan.nextLine();
			answer=answer.toLowerCase();
			if(answer.equals("n")) {
				System.out.println("goodbye");
				break;
				
			}
			else if(answer.equals("y")) {
				
				continue;
				
			}
			else {
				
				System.out.println("Not valid input,bye :(");
				break;
				
			}
		}
		
		
	}
	
	
	
}
