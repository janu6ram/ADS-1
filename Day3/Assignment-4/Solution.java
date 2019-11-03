class Solution{
	public Team[] sort(Team[] teams){
		// your code goes here
		for(int i = 0; i < teams.length; i++) {
			int min = i;
			for(int j = i +1; j < teams.length; j++) {
				if(teams[j].compareTo(teams[min]) < 0) {
					min = j;
				}
			}
			Team temp = teams[i];
			teams[i] = teams[min];
			teams[min] = temp;
		}
		return teams;
	}
}
class Team implements Comparable<Team> {
	String teamName;
	int noOfWins;
	int noOfLosses;
	int noOfDraws;
	Team(String name, int wins, int losses, int draws){
		teamName = name;
		noOfDraws = draws;
		noOfWins = wins;
		noOfLosses = losses;
	}
	public int compareTo(Team that) {
		int comp = that.noOfWins - this.noOfWins;
		if(comp == 0) {
			comp = this.noOfLosses - that.noOfLosses;
			if(comp == 0) {
				comp = that.noOfDraws - this.noOfDraws;
			}
		}
		return comp;
	}
	public String toString(){
		//retrun all the attributes as a string but appending with ", "
        return this.teamName + "," + this.noOfWins + "," + this.noOfLosses + "," + this.noOfDraws;
    }
}