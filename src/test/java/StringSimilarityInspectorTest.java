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
            inspector.checkLength(inputString, inputString2);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void returnResultIfUnMatchedStringLength() {
        assertThat(inspector.checkLength("ABC","ABCDEF")).isEqualTo(0);
    }

    @Test
    public void returnResultIfMatchedStringLength() {
        assertThat(inspector.checkLength("ABCED","QQQQQ")).isEqualTo(60);
    }

    @Test
    void returnResultIfPartiallyMatchedStringLength() {
        assertThat(inspector.checkLength("ABC","RE")).isEqualTo(30);
    }
}
