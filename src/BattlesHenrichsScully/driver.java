package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;
//import /parse.java;
//import /readInFile.java;

public class driver{
	
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
								System.out.print(" "+temp.depGet(k)+"->");
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
					
					Applicant person1 = null; // assign the current applicant in the department's list to person 1
					for (int temp=0; temp<all_apps.size(); ++temp) {
						if (all_apps.get(temp).getName().equals(all_deps.get(counter).appGet(i))) {
							person1 = all_apps.get(temp);
							break;
						}
					}
					
					if (person1.get_employer() == null) {
						//System.out.println(person1.getName());
						//if (person1 != null) System.out.println(person1.getName());
						
						ArrayList<Ranking> rankings = new ArrayList<Ranking>();
						int ranking = 0;
						int ranking2 = 1;
						Department this_dep = null;
						for (String dep: person1.getPrefs()){
							for (int thiss = 0; thiss < person1.getPrefs().size(); ++thiss) {
								if (person1.getPrefs().get(thiss).equals(dep)) {
									this_dep = all_deps.get(thiss);
									break;
								}
							}
							if (this_dep.getVacancies() != 0) {
								for (int temp = 0; temp < all_apps.size(); ++temp ){
									if (this_dep.appGet(temp).equals(person1.getName())) {
										ranking = temp+1;
										int total_rank = ranking + ranking2;
										//System.out.println(ranking + " " + ranking2);
										rankings.add(new Ranking(person1.getName(), dep, total_rank));
									}
								}
							}
							ranking2++;
						}
						
						for(Ranking yeah: rankings) {
							System.out.println(yeah.getName()+" "+yeah.getDep()+" "+yeah.getRanking());
						}
						
						Ranking top_rank = rankings.get(0);
						for (int temp=0; temp<rankings.size(); ++temp) {
							if (rankings.get(temp).getRanking() < top_rank.getRanking()) {
								top_rank = rankings.get(temp);
							}
						}
						while (person1.get_employer() != null || this_dep.getVacancies() < 1) {
							person1.set_employer(top_rank.getDep());
							this_dep.addEmployee(person1.getName());
							System.out.println(person1.getName()+" "+this_dep.getName());
						}
						
						
						//Find the first person which the first company wants.  Calculate that weight and then go the that person's individual preferences and create an arraylist 
						//of weights for that person's preferences and the companies that they want in order.  Then loops through the array list with all of the weights and assign that person to
						//the company with the lowest weight, but still add a person to the first company since we are trying to implement a first-come-first-serve algorithm in a sense.
					}
					i++;
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