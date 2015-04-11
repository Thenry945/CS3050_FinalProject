package BattlesHenrichsScully;

import java.util.ArrayList;

public class Department{
	
	private String name;
	private int vacancies;
	private ArrayList<String> preferences = new ArrayList<String>();
	/**
	 * Creates a department with an array list of its preferences
	 * @param name - the name of the department
	 * @param vacancies - the number of vacancies in the department
	 */
	public Department(String name, int vacancies){
		setName(name);
		setVacancies(vacancies);
	}
	/*setters for name and vacancies*/
	private void setName(String name){
		this.name = name;
	}
	private void setVacancies(int vacancies){
		this.vacancies = vacancies;
	}
	/*Getters for name and vacancies*/
	public String getName(){
		return name;
	}
	public int getVacancies(){
		return vacancies;
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
}