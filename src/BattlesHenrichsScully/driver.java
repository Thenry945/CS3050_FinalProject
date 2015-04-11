package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;

public class driver{
	
	public static void main(){
		readInFile fileList = new readInFile("filename.txt");
		//ArrayList<String> fileReturn = fileList.readFile();
		
		try {
			ArrayList<String> fileReturn = fileList.readFile();
			parse parseFile = new parse();
			System.out.println(fileReturn.get(0));
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
	}
	
}