import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public List<Integer> of(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; divisor * divisor <= num; divisor++) {
            while (num % divisor == 0) {
                factors.add(divisor);
                num /= divisor;
            }
        }
        if (num > 1)
            factors.add(num);
        return factors;
    }
}
