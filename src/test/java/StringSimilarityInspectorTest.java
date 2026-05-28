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
        assertIllegalArgument(null, "12");
        assertIllegalArgument("12", null);
    }

    private void assertIllegalArgument(String inputString, String inputString2) {
        try {
            inspector.checkString(inputString, inputString2);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void returnResultIfUnMatchedStringLength() {
        assertThat(inspector.checkString("ABC","ABCDEF")).isEqualTo(20);
    }

    @Test
    public void returnResultIfMatchedStringLength() {
        assertThat(inspector.checkString("ABCED","QQQQQ")).isEqualTo(60);
    }

    @Test
    void returnResultIfPartiallyMatchedStringLength() {
        assertThat(inspector.checkString("ABC","RE")).isEqualTo(30);
    }

    @Test
    void returnResultIfSameString() {
        assertThat(inspector.checkString("ABC","ABC")).isEqualTo(100);
    }

    @Test
    void returnResultIfPartiallyCorrect() {
        assertThat(inspector.checkString("ABCDE","ABC")).isEqualTo(44);
    }

    @Test
    void returnResultIfPartiallyCorrect2() {
        assertThat(inspector.checkString("AA","AAE")).isEqualTo(50);
    }
}
