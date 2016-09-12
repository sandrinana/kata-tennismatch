package poc.kata.tennisgame;

import java.util.Arrays;
import java.util.List;


public class Player {

    public static final List<String> pointsDescription = Arrays.asList("love", "fifteen", "thirty", "forty");

    public static final List<Integer> gameDescription= Arrays.asList(0,1,2,3,4,5,6,7);
    private int score;

    private int game;

    private String name;

    public int getScore() {
        return score;
    }

    public int getGame() {
        return game;
    }


    public String getName() {
        return name;
    }

    public void winBall() {
        this.score = this.score + 1;
    }

    public void winGame() {
        this.game = this.game + 1;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getScoreDescription(){
        return pointsDescription.get(score);
    }
    public Integer getGameDescription(){
        return gameDescription.get(game);
    }

}
