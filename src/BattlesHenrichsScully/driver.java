package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;

public class Driver{
	
	public static void main(String args[]){
		readInFile fileList = new readInFile("inputFiles/JobsApplicants.txt");
		//ArrayList<String> fileReturn = fileList.readFile();
		
		try {
			ArrayList<String> fileReturn = fileList.readFile();
			parse parseFile = new parse(fileReturn);
			//System.out.println(fileReturn.get(0));
			//System.out.println(parseFile.getDepList().get(0).getName());
			//System.out.println(parseFile.getAppList().get(0).getName());
			//System.out.println(parseFile.getDepList().get(0).depGet(0));
			//System.out.println(parseFile.getAppList().get(0).appGet(0));
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
	}
	
}