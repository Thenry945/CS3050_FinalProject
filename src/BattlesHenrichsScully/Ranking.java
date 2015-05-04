package BattlesHenrichsScully;

//import java.util.ArrayList;

public class Ranking {
	//attributes - name, departmnet and ranking
	private String name;
	private String dep;
	private int ranking;
	/**
	 * constructor for ranking object
	 * @param name - string
	 * @param dep - string
	 * @param ranking - int
	 */
	public Ranking(String name, String dep, int ranking) {
		setName(name);
		setDep(dep);
		setRanking(ranking);
	}
	/**
	 * setter for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * setter for department
	 * @param dep
	 */
	public void setDep(String dep) {
		this.dep = dep;
	}
	/**
	 * set the ranking integer
	 * @param ranking
	 */
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	/**
	 * get the name
	 * @return - string
	 */
	public String getName () {
		return this.name;
	}
	/**
	 * get the department
	 * @return string
	 */
	public String getDep() {
		return this.dep;
	}
	/**
	 * get the ranking
	 * @return - integer
	 */
	public int getRanking() {
		return this.ranking;
	}
	
}
