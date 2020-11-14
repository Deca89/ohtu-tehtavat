
package ohtu;

public class Player implements Comparable<Player>{
    private String name;
    private String nationality;
    private Integer assists;
    private Integer goals;
    private Integer penalties;
    private String team;
    private Integer games;

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public String getName() {
        return name;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    @Override
     public String toString() {
          return String.format("%20s  %5s  %3d + %3d = %3d", name, team, goals, assists, (goals + assists));
     }

     public int compareTo(Player toinen) {
         return  (toinen.getGoals()+toinen.getAssists() - (this.goals + this.assists));
     }
     
      
}
