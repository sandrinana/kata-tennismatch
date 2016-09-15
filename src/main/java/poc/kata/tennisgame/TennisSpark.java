package poc.kata.tennisgame;

import static spark.Spark.*;

import spark.*;

import java.util.stream.IntStream;


public class TennisSpark {

    public static final String BLANK = " ";

    public static void main(String[] args) {
        //remove the line below and replace with your code.
        get("/tennis", (req, res) -> "Kata Tennis game!");

        Player victor = new Player("Victor");
        Player sarah = new Player("Sarah");

        Referee game = new Game(victor, sarah);
        Referee set = new Set(victor, sarah);

        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            sarah.winBall();
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            sarah.winGame();
        });


        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            victor.winBall();
        });

        StringBuilder builder1 = buildPlayerMatchPoint(victor);


        StringBuilder builder2 = buildPlayerMatchPoint(sarah);



        get("/match", (req, res) -> builder1.toString() + "<br/><br/>" + builder2.toString());
    }

    private static StringBuilder buildPlayerMatchPoint(Player player) {
        StringBuilder builder2 = new StringBuilder();
        builder2.append("<p>");
        builder2.append(player.getName());
        builder2.append(BLANK);
        builder2.append(player.getGameDescription());
        builder2.append(BLANK);
        builder2.append(player.getScoreDescription());
        return builder2;
    }
    public void showScore(Game game, Set set) {
        game.getScore();
        set.getScore();

    }

    public void PlayAball(Player p1, Player p2) {

        getRandomBallWinner(p1, p2).winBall();

    }

    public void playTennisTillGameIsWon(Player p1, Player P2) {
        //while (!GameisAchieve) {
        PlayAball(p1, P2);
    }


    public void playTennisTillSetIswon() {
    }


    public Player getRandomBallWinner(Player p1, Player p2) {
        Player winner = p1;
        return winner;
    }

    public boolean GameisAchieve() {
        return true;
    }
}