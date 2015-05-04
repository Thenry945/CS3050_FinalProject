package BattlesHenrichsScully;

import java.util.ArrayList;

public class Applicant{
	
	//attributes
	private String name;
	private ArrayList<String> preferences = new ArrayList<String>();
	private String employer = null;
	/**
	 * Creates a department with an array list of its preferences
	 * @param name - the name of the department
	 * @param vacancies - the number of vacancies in the department
	 */
	public Applicant(String name){
		setName(name);
	}
	/*setter for name*/
	private void setName(String name){
		this.name = name;
	}
	/*Getter for name*/
	public String getName(){
		return name;
	}
	/**
	 * adds a string to the preferences arraylist
	 * @param input - the name of an applicant
	 */
	public void Add(String input){
		this.preferences.add(input);
	}
	/**
	 * takes in an arraylist index you want to get
	 * @param x - the arrayList index you want to get
	 */
	public String depGet(int x){
		return this.preferences.get(x);
	}
	
	/**
	 * getter for the employer
	 * @return - string
	 */
	public String get_employer(){
		return employer;
	}
	/**
	 * employer setter
	 * @param employer - string - public because its not constructed
	 */
	public void set_employer(String employer){
		this.employer = employer;
	}
	/**
	 * get the preferences array list	
	 * @return - arraylist
	 */
	public ArrayList<String> getPrefs() {
		return this.preferences;
	}
	/**
	 * remove an element at a certain index from the pref array list
	 * @param temp - takes in the index
	 */
	public void remove_dep(int temp){
		preferences.remove(temp);
	}
}