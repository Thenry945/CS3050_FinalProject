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
	
}