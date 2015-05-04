package BattlesHenrichsScully;

import java.util.ArrayList;

public class parse{
	//attributes - these are the arraylists that will contain the lists of departments and applicants
	private ArrayList<Department> depList = new ArrayList<Department>();
	private ArrayList<Applicant> applList = new ArrayList<Applicant>();
	/**
	 * constructor
	 * @param rawData - takes in the raw data array list
	 */
	public parse(ArrayList<String> rawData){
		parseIt(rawData);
	}
	/**
	 * parses the raw data into the department and applicant objects
	 * program is not case sensitive
	 * @param rawData
	 */
	private void parseIt(ArrayList<String> rawData){
		int counter = 0;
		//go through every single line until its not End Input
		while(!rawData.get(counter).equals("END INPUT")){
			/*
			 * if a line is equal to vacancies and departments then bump the counter twice
			 */
			if(rawData.get(counter).toLowerCase().equals("vacancies and departments")){
				++counter;
				++counter;
				/*
				 * while the next line is not equal to job applicants and the line is not empty (ignores all blank spaces)
				 * create a string array to hold all the split return of the line
				 * then, create a new Department object and push in the department and the parsed out number of vacancies
				 * then add that created department into the department array list
				 * bump the counter
				 */
				while(!rawData.get(counter).toLowerCase().equals("job applicants") && !rawData.get(counter).isEmpty()){
					//System.out.println(rawData.get(counter));
					String department[] = rawData.get(counter).split(" ");
					Department holdDep = new Department(department[1],Integer.valueOf(department[0]));
					depList.add(holdDep);
					++counter;
				}
				/*
				 *else if the line IS equal to job applicants
				 *bump the counter twice
				 */
			}else if(rawData.get(counter).toLowerCase().equals("job applicants")){
				++counter;
				++counter;
				//System.out.println(rawData.get(counter));
				/*
				 * while the line is not empty
				 * create a new applicant object and push the line into the object (constructs with a name)
				 * bump the counter
				 */
				while(!rawData.get(counter).isEmpty()){
					//System.out.println(rawData.get(counter));
					Applicant holdApp = new Applicant(rawData.get(counter));
					applList.add(holdApp);
					++counter;
				}
				/*
				 * else if the line starts with preferences - execute loop
				 */
			}else if(rawData.get(counter).toLowerCase().startsWith("preferences")){
				/*
				 * while the line still starts with preferences then split the line and store it into an array
				 * get the size of that array
				 * create department and applicant objects
				 */
				while(rawData.get(counter).toLowerCase().startsWith("preferences")){
					//System.out.println(rawData.get(counter));
					String hold[] = rawData.get(counter).split(" ");
					int size = hold.length;
					//maybe add dynamic pref adding here
					Department holdReturn = null;
					Applicant holdReturn2 = null;
					/*
					 * make sure that the size of the array is actually two
					 * if it is then execute a for loop
					 */
					if(size == 2){
						//System.out.println("size == 2");
						/*
						 * this for loop checks to see if the name of the department is equal to the department name from the parsed out list
						 * if it is, then the temp department variable is set
						 */
						for(Department d : depList){
							if(hold[1].equals(d.getName())){
								holdReturn = d;
							}
						}
						//System.out.println(holdReturn.getName());
						/*
						 * counter is bumped twice
						 */
						++counter;
						++counter;
						//System.out.println(holdReturn.getName());
						/*
						 * execute a while loop while the line is not empty
						 * inside: add the line to the holdreturn array list
						 * bump the counter
						 */
						while(!rawData.get(counter).isEmpty()){
							//System.out.println(rawData.get(counter));
							//System.out.println(holdReturn.getName() + " inside add loop");
							holdReturn.Add(rawData.get(counter).trim());
							++counter;
						}
					}
					/*
					 * if the size of the line is equal to 3
					 * then reconcatenate the split applicants name and store it into a temp variable
					 */
					else if(size == 3){
						String holdAppName = hold[1] + " " + hold[2];
						//System.out.println(holdAppName);
						/*
						 * for each applicant if the hold applicant name is equal to the name of one of the array list applicants then set the hold return and bump the counter twice
						 */
						for(Applicant d : applList){
							if(holdAppName.equals(d.getName())){
								holdReturn2 = d;
							}
						}
						++counter;
						++counter;
						//System.out.println(holdReturn2.getName());
						/*
						 * while the line is not empty add the line to the holdreturn2 and bump the counter
						 */
						while(!rawData.get(counter).isEmpty()){
							//System.out.println(rawData.get(counter));
							holdReturn2.Add(rawData.get(counter).trim());
							++counter;
						}
					}
					/*++counter;
					System.out.println(holdReturn.getName());
					while(!rawData.get(counter).isEmpty()){
						System.out.println(rawData.get(counter));
						holdReturn.Add(rawData.get(counter));
						++counter;
					}*/
				}
			}
			/*
			 * bump the counter
			 */
			++counter;
		}
		
		
	}
	/**
	 * return the parse class generated department list
	 * @return
	 */
	public ArrayList<Department> getDepList(){
		return this.depList;
	}
	/**
	 * return the parse class generated applicant list
	 * @return
	 */
	public ArrayList<Applicant> getAppList(){
		return this.applList;
	}
}