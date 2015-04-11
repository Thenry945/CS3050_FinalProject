package BattlesHenrichsScully;

import java.util.ArrayList;

public class Applicant{
	
	private String name;
	private ArrayList<String> preferences = new ArrayList<String>();
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
	public String appGet(int x){
		return this.preferences.get(x);
	}
}