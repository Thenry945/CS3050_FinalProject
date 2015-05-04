package BattlesHenrichsScully;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Collections;
//import /parse.java;
//import /readInFile.java;

public class driver{
	
	public static void main(String args[]){
		/*
		 * create a readinfile object
		 * if you want to change which file is going to be read in please put the file into the inputFiles folder
		 * and then change "JobsApplicants.txt" to whatever the name of that file is
		 */
		readInFile fileList = new readInFile("inputFiles/JobsApplicants.txt");
		//ArrayList<String> fileReturn = fileList.readFile();
		/*
		 * try block for the io exception
		 */
		try 
		{
			/*
			 * create the arraylist returned from the read in file function
			 * then parse out that file by creating a parse object, parsing is called inherently 
			 */
			ArrayList<String> fileReturn = fileList.readFile();
			parse parseFile = new parse(fileReturn);
			//System.out.println(fileReturn.get(0));
			//System.out.println(parseFile.getDepList().get(0).getName());
			//System.out.println(parseFile.getAppList().get(0).getName());
			//System.out.println(parseFile.getDepList().get(0).depGet(0));
			//System.out.println(parseFile.getAppList().get(0).appGet(0));
			/*
			 * create the department and applicant lists returned from the parse objects getList functions
			 */
			ArrayList<Department> all_deps = parseFile.getDepList();
			ArrayList<Applicant> all_apps = parseFile.getAppList();
			/*
			 * iterates through every department in the department list
			 */
			for (int counter = 0; counter < all_deps.size(); counter++) {
				//System.out.println(all_deps.get(counter).getName());
				
				int i = 0;
				/*
				 * iterates through to make sure that there are no vacancies and while i is less than the size-1 of the number of department preferences
				 */
				while (all_deps.get(counter).getVacancies() != 0 && i <= all_deps.get(counter).getPrefs().size()-1) {
					//System.out.print(all_deps.get(counter).getPrefs().get(i));
					/*
					 * iterates through every applicant
					 */
					for (int j = 0; j <= all_apps.size()-1; ++j) {
						/*
						 * if the name of the applicant is equal to the name of the department preference then execute
						 */
						if (all_apps.get(j).getName().equals(all_deps.get(counter).getPrefs().get(i))){
							Applicant temp = all_apps.get(j);
							//System.out.print(":  ");
							/*
							 * iterate through each temp application ( for display purposes)
							 */
							for (int k=0; k <= temp.getPrefs().size()-1; ++k) {
								//System.out.print(" "+temp.depGet(k)+"->");
							}
							//System.out.println(" ");
						}
					}
					/*
					 * bumps the i counter so we continue to iterate through the preferences
					 */
					i++;
				}
				//System.out.println(" ");
			}
			/*
			 * iterates through every single department
			 */
			for (int counter = 0; counter < all_deps.size(); counter++) {
				//System.out.println(all_deps.get(counter).getName()+" "+all_deps.get(counter).getVacancies());
				
				int i = 0;
				/*
				 * again, checks vacancies and iterates through the preferences
				 */
				while (all_deps.get(counter).getVacancies() != 0 && i <= all_deps.get(counter).getPrefs().size()-1) {
					
					Applicant person1 = null; // assign the current applicant in the department's list to person 1
					/*
					 * for each applicant - if their name is equal to the name of a department preferences then that person is person1
					 */
					for (int temp=0; temp<all_apps.size(); ++temp) {
						if (all_apps.get(temp).getName().equals(all_deps.get(counter).appGet(i))) {
							person1 = all_apps.get(temp);
							break;
						}
					}
					/*
					 * checks to make sure they are still unemployed
					 */
					if (person1.get_employer() == null) {
						//System.out.println(person1.getName());
						//if (person1 != null) System.out.println(person1.getName());
						/*
						 * create an array list of type Ranking to hold the weight that we assign to each person
						 */
						ArrayList<Ranking> rankings = new ArrayList<Ranking>();
						int ranking = 0;
						int ranking2 = 1;
						Department this_dep = null;
						/*
						 * for each department in an applicants preference list, iterate
						 */
						for (String dep: person1.getPrefs()){
							/*
							 * for each preference that person one has
							 */
							for (int thiss = 0; thiss < person1.getPrefs().size(); ++thiss) {
								/*
								 * if person1's preference is equal to the current department then the variable this_dep is equal to the slected department
								 * breaks for efficiency
								 */
								if (person1.getPrefs().get(thiss).equals(dep)) {
									this_dep = all_deps.get(thiss);
									break;
								}
							}
							/*
							 * checks to ensure that the selected department has vacancies, if it does not then do not execute
							 */
							if (this_dep.getVacancies() != 0) {
								/*
								 * iterates through every applicant
								 */
								for (int temp = 0; temp < all_apps.size(); ++temp ){
									/*
									 * if the current department's preferential applicant is is the same as person1, the current applicant then execute
									 */
									if (this_dep.appGet(temp).equals(person1.getName())) {
										/*
										 * sets the ranking system - there is a total rank assigned by the current counter (assigned by a first come first serve basis)
										 */
										ranking = temp+1;
										int total_rank = ranking + ranking2;
										//System.out.println(ranking + " " + ranking2);
										//System.out.println(this_dep.getName()+" has: "+this_dep.getVacancies());
										/*
										 * creates a new ranking object with the name of the current applicant, the current department and the total rank 
										 * then it adds that ranking to the ranking array list 'rankings'
										 */
										rankings.add(new Ranking(person1.getName(), this_dep.getName(), total_rank));
									}
								}
							}
							/*
							 * bump the ranking up so the value doesnt just remain static, this is a dynamic algorithm after all
							 */
							ranking2++;
						}
						
						/*for(Ranking yeah: rankings) {
							System.out.println(yeah.getName()+" "+yeah.getDep()+" "+yeah.getRanking());
						}*/
						/*
						 * runs a bubble sort algorithm on the rankings array list by the value of the ranking in the list so that the list is ordered in descending order
						 */
						sort(rankings);
						/*
						 * output testing
						 */
						/*System.out.println("-----------------SORT----------------");
						for (Ranking test: rankings) {
							System.out.println(test.getName()+" "+test.getDep()+" "+test.getRanking());
						}
						System.out.println("##################END#################");*/
						
						/*
						 * iterates through every single department 
						 */
						Department check_vacancies = null;
						int top = 0;
						for (int temp=0; temp < all_deps.size(); ++temp) {
							//System.out.println(rankings.get(top).getDep().trim());
							//System.out.println(all_deps.get(temp).getName().trim());
							/*
							 * the parser trims now, so the trim aspect of this is unneccisary, but this was added before we figured out we needed to
							 * trim and the redundant trimming isnt hurting anything
							 * if the top department in the rankings list is equal to the department in the department found by the temp variable as the index of the 
							 * entire department list then the check_vacancies variable is set to that department
							 * breaks for efficiency
							 */
							if (rankings.get(top).getDep().trim().equals(all_deps.get(temp).getName().trim())) {
								//System.out.println("BREAKING");
								check_vacancies = all_deps.get(temp);
								break;
							}
						}
						//System.out.println(check_vacancies+"   "+check_vacancies.getVacancies());
						/*
						 * iterates through while check_vacancies variable (department) still has an applicant vacancy
						 */
						while (check_vacancies.getVacancies() < 1) {
							/*
							 * if the top counter + 1 is less than the size of the number of departments then bump the counter
							 * this handles any array out of bounds exceptions thrown by the program
							 */
							if (top+1 < all_deps.size()) {
								top++;
							}
							/*
							 * iterates through every department with a temp variable
							 */
							for (int temp=0; temp < all_deps.size(); ++temp) {
								/*
								 * prints out the department from rankings and the department from departments , they are in fact the same
								 */
								System.out.println(rankings.get(top).getDep().trim());
								System.out.println(all_deps.get(temp).getName().trim());
								/*
								 * trimmed here again, for the same reason
								 * if the rankings top department is equal to the department at the index temp then vacancies is that department
								 */
								if (rankings.get(top).getDep().trim().equals(all_deps.get(temp).getName().trim())) {
									check_vacancies = all_deps.get(temp);
								}
							}
						}
						Ranking top_rank = rankings.get(top);
						/*
						 * if the person is unemployed and the department has a vacancy then hire that person!
						 * and diplay that department they got hired into
						 * 
						 */
						if (person1.get_employer() == null && this_dep.getVacancies() > 0) {
							person1.set_employer(top_rank.getDep());
							check_vacancies.addEmployee(person1.getName());
							System.out.println(person1.getName()+" "+top_rank.getDep());
						}
						
						/*
						 * algorithmic description
						 */
						//Find the first person which the first company wants.  Calculate that weight and then go the that person's individual preferences and create an arraylist 
						//of weights for that person's preferences and the companies that they want in order.  Then loops through the array list with all of the weights and assign that person to
						//the company with the lowest weight, but still add a person to the first company since we are trying to implement a first-come-first-serve algorithm in a sense.
					}
					/*
					 * bumps the i counter
					 */
					i++;
				}
			}
			/*
			 * display block - shows the employee assignments
			 */
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
		/*
		 * catches any io exceptions
		 */
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
	/**
	 * sort function - simple bubble sort   O(n^2) efficiency, its not great but the lists its pushing through probably wont be too large
	 * @param rankings
	 */
	public static void sort(ArrayList<Ranking> rankings){
		boolean flag = true;
		//Ranking temp = null;
		Ranking temp2 = null;
		while(flag){
			flag = false;
			for(int x = 0; x < rankings.size()-1; ++x){
				if(rankings.get(x).getRanking() > rankings.get(x+1).getRanking()){
					/*
					 * array list hard copying - soft copying does not work in this situation
					 */
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