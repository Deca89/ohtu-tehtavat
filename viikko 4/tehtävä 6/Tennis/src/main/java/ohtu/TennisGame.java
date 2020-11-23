package ohtu;

public class TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }
    
    public boolean gameIsTied() {
        return playerOneScore == playerTwoScore;
    }
    
    public String nameForPoints(int score) {
        if (score == 0) {
            return "Love";
        } else if (score == 1) {
            return "Fifteen";
        } else if (score == 2) {
            return "Thirty";
        } else if (score == 3) {
            return "Forty";
        }
        return "Deuce";
    }
    
    public boolean longGame() {
        return (playerOneScore >= 4 || playerTwoScore >= 4);
    }

    public String getScore() {
        String situation = "";
        String playerOneSituation = nameForPoints(playerOneScore);
        String playerTwoSituation = nameForPoints(playerTwoScore);
        
        if (gameIsTied())
        {
            if (playerOneSituation == "Deuce") return "Deuce";
            return playerOneSituation + "-All";
        }
        else if (longGame())
        {
            int differenceInScore = playerOneScore-playerTwoScore;
            if (differenceInScore==1) return "Advantage player1";
            else if (differenceInScore ==-1) return "Advantage player2";
            else if (differenceInScore>=2) return "Win for player1";
            else return "Win for player2";
        }
        
        return playerOneSituation + "-" + playerTwoSituation;
    }
}