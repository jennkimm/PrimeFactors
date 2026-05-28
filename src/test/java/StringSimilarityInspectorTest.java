import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringSimilarityInspectorTest {
    StringSimilarityInspector inspector;

    @BeforeEach
    void setUp() {
        inspector = new StringSimilarityInspector();
    }

    @Test
    void createGame() {
        assertNotNull(inspector);
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
    }

    private void assertIllegalArgument(String guessString) {
        try {
            inspector.checkLength(guessString);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void returnResultIfUnMatchedStringLength() {
        generateString("ABC");
        assertThat(inspector.checkLength("ABCDEF")).isEqualTo(0);
    }

    @Test
    public void returnResultIfMatchedStringLength() {
        generateString("ABCED");
        assertThat(inspector.checkLength("QQQQQ")).isEqualTo(60);
    }

    @Test
    void returnResultIfPartiallyMatchedStringLength() {
        generateString("ABC");
        assertThat(inspector.checkLength("RE")).isEqualTo(30);
    }

    private void generateString(String s) {
        inspector.answer = s;
    }
}
