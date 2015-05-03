package BattlesHenrichsScully;

public class Ranking {
	private String name;
	private String dep;
	private int ranking;
	
	public Ranking(String name, String dep, int ranking) {
		setName(name);
		setDep(dep);
		setRanking(ranking);
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setDep(String dep) {
		this.dep = dep;
	}
	
	private void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	public String getName () {
		return this.name;
	}
	
	public String getDep() {
		return this.dep;
	}
	
	public int getRanking() {
		return this.ranking;
	}
}
