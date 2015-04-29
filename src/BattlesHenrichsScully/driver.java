package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;
//import /parse.java;
//import /readInFile.java;

public class Driver{
	
	public static void main(String args[]){
		readInFile fileList = new readInFile("inputFiles/JobsApplicants.txt");
		//ArrayList<String> fileReturn = fileList.readFile();
		
		try 
		{
			ArrayList<String> fileReturn = fileList.readFile();
			parse parseFile = new parse(fileReturn);
			//System.out.println(fileReturn.get(0));
			//System.out.println(parseFile.getDepList().get(0).getName());
			//System.out.println(parseFile.getAppList().get(0).getName());
			//System.out.println(parseFile.getDepList().get(0).depGet(0));
			//System.out.println(parseFile.getAppList().get(0).appGet(0));
			ArrayList<Department> all_deps = parseFile.getDepList();
			ArrayList<Applicant> all_apps = parseFile.getAppList();
			
			for (int counter = 0; counter < all_deps.size(); counter++) {
				System.out.println(all_deps.get(counter).getName());
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}