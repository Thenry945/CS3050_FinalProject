package BattlesHenrichsScully;

import java.util.ArrayList;

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
	
	public void sort(ArrayList<Ranking> rankings){
		boolean flag = true;
		Ranking temp = null;
		Ranking temp2 = null;
		
		while(flag){
			
			flag = false;
			for(int x = 0; x < rankings.size(); ++x){
				
				if(rankings.get(x).getRanking() < rankings.get(x+1).getRanking()){
					temp = rankings.get(x);
					temp2 = rankings.get(x+1);
					rankings.get(x).setName(temp2.getName());
					rankings.get(x).setDep(temp2.getDep());
					rankings.get(x).setRanking(temp2.getRanking());
					
					rankings.get(x+1).setName(temp.getName());
					rankings.get(x+1).setDep(temp.getDep());
					rankings.get(x+1).setRanking(temp.getRanking());
					
					flag = true;
				}
				
			}
			
		}
		return;
	}
	
	
}
