package poc.kata.tennisgame;


public class Game implements Referee{

    public static final String DEUCE = "deuce";
    public static final String ADVANTAGE = "advantage ";
    public static final String WON = " won";
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String getScore() {
        if (player1.getScore() >= 3 && player2.getScore() >= 3) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
                return getLeadPlayer().getName() + WON;
            } else if (player1.getScore() == player2.getScore()) {
                return DEUCE;
            } else {
                return ADVANTAGE + getLeadPlayer().getName();
            }
        } else {
            return player1.getScoreDescription() + ", " + player2.getScoreDescription();
        }
    }

    @Override
    public Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }

}