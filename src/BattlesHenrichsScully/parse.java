<<<<<<< HEAD
package BattlesHenrichsScully;

import java.util.ArrayList;

public class parse{
	
	private ArrayList<Department> depList = new ArrayList<Department>();
	private ArrayList<Applicant> applList = new ArrayList<Applicant>();
	
	public parse(ArrayList<String> rawData){
		parseIt(rawData);
	}
	/**
	 * parses the raw data into the department and applicant objects
	 * @param rawData
	 */
	private void parseIt(ArrayList<String> rawData){
		int counter = 0;
		while(!rawData.get(counter).equals("END INPUT")){
			if(rawData.get(counter).toLowerCase().equals("vacancies and departments")){
				++counter;
				++counter;
				while(!rawData.get(counter).toLowerCase().equals("job applicants") && !rawData.get(counter).isEmpty()){
					//System.out.println(rawData.get(counter));
					String department[] = rawData.get(counter).split(" ");
					Department holdDep = new Department(department[1],Integer.valueOf(department[0]));
					depList.add(holdDep);
					++counter;
				}
			}else if(rawData.get(counter).toLowerCase().equals("job applicants")){
				++counter;
				++counter;
				//System.out.println(rawData.get(counter));
				while(!rawData.get(counter).isEmpty()){
					//System.out.println(rawData.get(counter));
					Applicant holdApp = new Applicant(rawData.get(counter));
					applList.add(holdApp);
					++counter;
				}
			}else if(rawData.get(counter).toLowerCase().startsWith("preferences")){
				while(rawData.get(counter).toLowerCase().startsWith("preferences")){
					//System.out.println(rawData.get(counter));
					String hold[] = rawData.get(counter).split(" ");
					int size = hold.length;
					//maybe add dynamic pref adding here
					Department holdReturn = null;
					Applicant holdReturn2 = null;
					if(size == 2){
						//System.out.println("size == 2");
						for(Department d : depList){
							if(hold[1].equals(d.getName())){
								holdReturn = d;
							}
						}
						//System.out.println(holdReturn.getName());
						++counter;
						++counter;
						//System.out.println(holdReturn.getName());
						while(!rawData.get(counter).isEmpty()){
							//System.out.println(rawData.get(counter));
							//System.out.println(holdReturn.getName() + " inside add loop");
							holdReturn.Add(rawData.get(counter));
							++counter;
						}
					}
					
					else if(size == 3){
						String holdAppName = hold[1] + " " + hold[2];
						//System.out.println(holdAppName);
						for(Applicant d : applList){
							if(holdAppName.equals(d.getName())){
								holdReturn2 = d;
							}
						}
						++counter;
						++counter;
						//System.out.println(holdReturn2.getName());
						while(!rawData.get(counter).isEmpty()){
							//System.out.println(rawData.get(counter));
							holdReturn2.Add(rawData.get(counter));
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
			++counter;
		}
		
		
	}
	
	public ArrayList<Department> getDepList(){
		return this.depList;
	}
	
	public ArrayList<Applicant> getAppList(){
		return this.applList;
	}
	
=======
package BattlesHenrichsScully;

import java.util.ArrayList;

public class parse{
	
	private ArrayList<Department> depList = new ArrayList<Department>();
	private ArrayList<Applicant> applList = new ArrayList<Applicant>();
	
	public parse(ArrayList<String> rawData){
		parseIt(rawData);
	}
	/**
	 * parses the raw data into the department and applicant objects
	 * @param rawData
	 */
	private void parseIt(ArrayList<String> rawData){
		int counter = 0;
		while(!rawData.get(counter).equals("END INPUT")){
			if(rawData.get(counter).toLowerCase().equals("vacancies and departments")){
				while(!rawData.get(counter).toLowerCase().equals("job applicants") && !rawData.get(counter).isEmpty()){
					String department[] = rawData.get(counter).split(" ");
					Department holdDep = new Department(department[1],Integer.valueOf(department[0]));
					depList.add(holdDep);
					++counter;
				}
			}else if(rawData.get(counter).toLowerCase().equals("job applicants")){
				++counter;
				while(!rawData.get(counter).isEmpty()){
					Applicant holdApp = new Applicant(rawData.get(counter));
					applList.add(holdApp);
					++counter;
				}
			}else if(rawData.get(counter).toLowerCase().startsWith("preferences")){
				while(rawData.get(counter).toLowerCase().startsWith("preferences")){
					String hold[] = rawData.get(counter).split(" ");
					//maybe add dynamic pref adding here
					Department holdReturn = null;
					for(Department d : depList){
						if(hold[1].equals(d.getName())){
							holdReturn = d;
						}
					}
					if(holdReturn.equals(null)){
						String holdAppName = hold[1] + " " + hold[2];
						for(Department d : depList){
							if(holdAppName.equals(d.getName())){
								holdReturn = d;
							}
						}
					}
					++counter;
					while(!rawData.get(counter).isEmpty()){
						holdReturn.Add(rawData.get(counter));
						++counter;
					}
				}
			}
		}
		
		
	}
	
	public ArrayList<Department> getDepList(){
		return this.depList;
	}
	
	public ArrayList<Applicant> getAppList(){
		return this.applList;
	}
	
>>>>>>> ffd7365495c653196bfc5876b1c8453f9504b035
}