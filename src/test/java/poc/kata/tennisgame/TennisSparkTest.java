package poc.kata.tennisgame;

import static junit.framework.TestCase.assertNotNull;

import org.junit.Before;
import org.junit.Test;


public class TennisSparkTest {
    TennisSpark tennisSpark;
    Player victor;
    Player sarah;
    Referee game;

    /**
     * Test for the construction of TennisSpark and the
     * tennisSpark method being called
     *
     */
    @Before
    public void beforeMainTest() {
        tennisSpark = new TennisSpark();
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }

    @Test
    public void shouldCreateMainObject(){

        assertNotNull("TennisSpark method called.", tennisSpark);
    }
    @Test
    public void ShouldShowScore(){
        victor.winBall();
        victor.winBall();
        game.getScore();
    }
}


