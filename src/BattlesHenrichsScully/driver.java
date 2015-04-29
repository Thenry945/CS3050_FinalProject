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
				int i = 0;
				while (all_deps.get(counter).getVacancies() != 0 && i <= all_deps.get(counter).getPrefs().size()-1) {
					System.out.print(all_deps.get(counter).getPrefs().get(i));
					for (int j = 0; j <= all_apps.size()-1; ++j) {
						if (all_apps.get(j).getName().equals(all_deps.get(counter).getPrefs().get(i))){
							Applicant temp = all_apps.get(j);
							System.out.print(":  ");
							for (int k=0; k <= temp.getPrefs().size()-1; ++k) {
								System.out.print(" "+temp.appGet(k)+"->");
							}
							System.out.println(" ");
						}
					}
					i++;
				}
				System.out.println(" ");
			}
			
			for (int counter = 0; counter < all_deps.size(); counter++) {
				System.out.println(all_deps.get(counter).getName());
				int i = 0;
				while (all_deps.get(counter).getVacancies() != 0 && i <= all_deps.get(counter).getPrefs().size()-1) {
					//Find the first person which the first company wants.  Calculate that weight and then go the that person's individual preferences and create an arraylist 
					//of weights for that person's preferences and the companies that they want in order.  Then loops through the array list with all of the weights and assign that person to
					//the company with the lowest weight, but still add a person to the first company since we are trying to implement a first-come-first-serve algorithm in a sense.  
				}
			}
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}