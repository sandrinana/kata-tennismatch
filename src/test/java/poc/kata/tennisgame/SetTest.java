package poc.kata.tennisgame;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class SetTest {

    Player victor;
    Player sarah;
    Referee referee;

    @Before
    public void beforeSetTest() throws Exception {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        referee = new Set(victor, sarah);
    }


    @Test
    public void zeroShouldBeDescriptionForGame0() {
        Referee referee = new Set(victor, sarah);
        assertThat(referee, hasProperty("score", is("0, 0")));
    }
    @Test
    public  void tiebreakShouldbeDescriptionWhenAtLeastSixGamesHaveBeenScoredByEachPlayerAndTheScoresAreEqual(){
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            victor.winGame();
        });
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            sarah.winGame();
        });
        assertThat(referee, hasProperty("score", is("tiebreak")));
        victor.winGame();
        assertThat(referee, hasProperty("score", is(not("tiebreak"))));
    }

    @Test
    public void setShouldBeWonByTheFirstPlayerToHaveWonAtLeastSixGamesInTotalAndWithAtLeastTwoGamesMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            victor.winGame();
        });
        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            sarah.winGame();
        });
        assertThat(referee, hasProperty("score", is(not("Victor won"))));
        assertThat(referee, hasProperty("score", is("Sarah won")));
    }

    @Test
    public void setShouldBeWonByTheFirstPlayerToHaveWonAtLeastSevenGamesInTotalAndWithAtLeastTwoGamesMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 5).forEach((Integer) -> {
            victor.winGame();
        });
        IntStream.rangeClosed(1, 7).forEach((Integer) -> {
            sarah.winGame();
        });
        assertThat(referee, hasProperty("score", is(not("Victor won"))));
        assertThat(referee, hasProperty("score", is("Sarah won")));
    }

    @Test
    public void fourShouldBeDescriptionForFourGamesWon(){
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            victor.winGame();
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            sarah.winGame();
        });
        assertThat(referee, hasProperty("score", is("3, 4")));
    }

    @Test
    public void fiveShouldBeDescriptionForFiveGamesWon(){
        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            victor.winGame();
        });
        IntStream.rangeClosed(1, 5).forEach((Integer) -> {
            sarah.winGame();
        });
        assertThat(referee, hasProperty("score", is("2, 5")));
    }
}