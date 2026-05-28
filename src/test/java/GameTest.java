import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {
        assertNotNull(game);
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }

    private void generateQuestion(String questionNumber) {
        game.question = questionNumber;
    }

    @Test
    public void returnSolvedResultIfMatchedNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("123");
        assertMatchedNumber(result, true, 3, 0);

    }

    @Test
    public void returnSolvedResultIfUnMatchedNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("456");
        assertMatchedNumber(result, false, 0, 0);
    }

    @Test
    public void returnSolvedResultIfOneBallNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("416");
        assertMatchedNumber(result, false, 0, 1);
    }

    @Test
    public void returnSolvedResultIfTwoBallNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("351");
        assertMatchedNumber(result, false, 0, 2);
    }

    @Test
    public void returnSolvedResultIfOneStrikeNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("156");
        assertMatchedNumber(result, false, 1, 0);
    }

    @Test
    public void returnSolvedResultIfTwoStrikeNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("126");
        assertMatchedNumber(result, false, 2, 0);
    }

    @Test
    public void returnSolvedResultIfOneStrikeOneBallNumber() {
        generateQuestion("123");
        GuessResult result = game.guess("136");
        assertMatchedNumber(result, false, 1, 1);
    }

    private static void assertMatchedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.getSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }
}
