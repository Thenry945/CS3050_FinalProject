package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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
				//System.out.println(all_deps.get(counter).getName());
				int i = 0;
				while (all_deps.get(counter).getVacancies() != 0 && i <= all_deps.get(counter).getPrefs().size()-1) {
					//System.out.print(all_deps.get(counter).getPrefs().get(i));
					for (int j = 0; j <= all_apps.size()-1; ++j) {
						if (all_apps.get(j).getName().equals(all_deps.get(counter).getPrefs().get(i))){
							Applicant temp = all_apps.get(j);
							//System.out.print(":  ");
							for (int k=0; k <= temp.getPrefs().size()-1; ++k) {
								//System.out.print(" "+temp.depGet(k)+"->");
							}
							//System.out.println(" ");
						}
					}
					i++;
				}
				//System.out.println(" ");
			}
			
			for (int counter = 0; counter < all_deps.size(); counter++) {
				//System.out.println(all_deps.get(counter).getName()+" "+all_deps.get(counter).getVacancies());
				
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
										//System.out.println(this_dep.getName()+" has: "+this_dep.getVacancies());
										rankings.add(new Ranking(person1.getName(), this_dep.getName(), total_rank));
									}
								}
							}
							ranking2++;
						}
						
						/*for(Ranking yeah: rankings) {
							System.out.println(yeah.getName()+" "+yeah.getDep()+" "+yeah.getRanking());
						}*/
						
						sort(rankings);
						/*System.out.println("-----------------SORT----------------");
						for (Ranking test: rankings) {
							System.out.println(test.getName()+" "+test.getDep()+" "+test.getRanking());
						}
						System.out.println("##################END#################");*/
						
						Department check_vacancies = null;
						int top = 0;
						for (int temp=0; temp < all_deps.size(); ++temp) {
							//System.out.println(rankings.get(top).getDep().trim());
							//System.out.println(all_deps.get(temp).getName().trim());
							if (rankings.get(top).getDep().trim().equals(all_deps.get(temp).getName().trim())) {
								//System.out.println("BREAKING");
								check_vacancies = all_deps.get(temp);
								break;
							}
						}
						//System.out.println(check_vacancies+"   "+check_vacancies.getVacancies());
						while (check_vacancies.getVacancies() < 1) {
							if (top+1 < all_deps.size()) {
								top++;
							}
							for (int temp=0; temp < all_deps.size(); ++temp) {
								System.out.println(rankings.get(top).getDep().trim());
								System.out.println(all_deps.get(temp).getName().trim());
								if (rankings.get(top).getDep().trim().equals(all_deps.get(temp).getName().trim())) {
									check_vacancies = all_deps.get(temp);
								}
							}
						}
						Ranking top_rank = rankings.get(top);
						if (person1.get_employer() == null && this_dep.getVacancies() > 0) {
							person1.set_employer(top_rank.getDep());
							check_vacancies.addEmployee(person1.getName());
							System.out.println(person1.getName()+" "+top_rank.getDep());
						}
						
						
						//Find the first person which the first company wants.  Calculate that weight and then go the that person's individual preferences and create an arraylist 
						//of weights for that person's preferences and the companies that they want in order.  Then loops through the array list with all of the weights and assign that person to
						//the company with the lowest weight, but still add a person to the first company since we are trying to implement a first-come-first-serve algorithm in a sense.
					}

					i++;
				}
			}
			System.out.println();
			System.out.println("Employment Assignments...");
			for (Applicant temp: all_apps) {
				if (temp.get_employer() != null) {
					System.out.println(temp.getName()+": "+temp.get_employer());
				}
				else {
					System.out.println(temp.getName()+": NONE");
				}
			}
			System.out.println();
			for (Department temp: all_deps) {
				System.out.println(temp.getName()+" "+temp.getVacancies());
			}
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}

	public static void sort(ArrayList<Ranking> rankings){
		boolean flag = true;
		Ranking temp = null;
		Ranking temp2 = null;
		while(flag){
			flag = false;
			for(int x = 0; x < rankings.size()-1; ++x){
				if(rankings.get(x).getRanking() > rankings.get(x+1).getRanking()){
					String temp_name = rankings.get(x).getName();
					int temp_rankings = rankings.get(x).getRanking();
					String temp_dep = rankings.get(x).getDep();
					temp2 = rankings.get(x+1);
					rankings.get(x).setName(temp2.getName());
					rankings.get(x).setDep(temp2.getDep());
					rankings.get(x).setRanking(temp2.getRanking());
					rankings.get(x+1).setName(temp_name);
					rankings.get(x+1).setDep(temp_dep);
					rankings.get(x+1).setRanking(temp_rankings);
					flag = true;
				}
			}
		}
		return;
	}
}