import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimeFactorsTest {
    PrimeFactor primeFactor;

    @BeforeEach
    public void setUp() throws Exception {
        primeFactor = new PrimeFactor();
    }

    @Test
    public void testPrimeFactorOf1() {
        assertEquals(Arrays.asList(), primeFactor.of(1));
    }

    @Test
    public void testPrimeFactorOf2() {
        assertEquals(Arrays.asList(3), primeFactor.of(3));
    }

    @Test
    public void testPrimeFactorOf3() {
        assertEquals(Arrays.asList(2,2), primeFactor.of(4));
    }

    @Test
    public void testPrimeFactorOf4() {
        assertEquals(Arrays.asList(7), primeFactor.of(7));
    }

    @Test
    public void testPrimeFactorOf5() {
        assertEquals(Arrays.asList(2,2,3), primeFactor.of(12));
    }

    @Test
    public void testPrimeFactorOf6() {
        assertEquals(Arrays.asList(2,3,5), primeFactor.of(30));
    }

    @Test
    public void testPrimeFactorOf7() {
        assertEquals(Arrays.asList(2,2,5,5), primeFactor.of(100));
    }
}
