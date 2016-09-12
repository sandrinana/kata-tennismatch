package poc.kata.tennisgame;

import java.util.ArrayList;
import java.util.List;


public class Set implements Referee {
    public static final String WON = " won";
    public static final String TIEBREAK = "tiebreak";
    private Player player1;
    private Player player2;


    public Set(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public String getScore() {
        if (player1.getGame() == 6 && player2.getGame() == 6) {
            return TIEBREAK;
        } else if (Math.abs(player2.getGame() - player1.getGame()) >= 2 && Math.max(player2.getGame(), player1.getGame())==6) {
            return getLeadPlayer().getName() + WON;
        }else if(Math.abs(player2.getGame() - player1.getGame()) >= 2 && Math.max(player2.getGame(), player1.getGame())==7){
            return getLeadPlayer().getName() + WON;
        }
        else {
            return player1.getGameDescription() + ", " + player2.getGameDescription();
        }

    }

    @Override
    public Player getLeadPlayer() {
        return (player1.getGame() > player2.getGame()) ? player1 : player2;
    }

}