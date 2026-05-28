public class StringSimilarityInspector {
    public static final int MAX_LENGTH_SCORE = 60;
    int score;

    public StringSimilarityInspector() {
        this.score = 0;
    }

    public int checkLength(String inputString, String inputString2) {
        assertIllegalArgument(inputString);

        double shorter = Math.min(inputString2.length(), inputString.length());
        double longer = Math.max(inputString2.length(), inputString.length());

        if (shorter == longer)
            score += MAX_LENGTH_SCORE;
        else if (longer < shorter * 2) {
            score += (shorter - (longer - shorter)) * MAX_LENGTH_SCORE / shorter;
        }

        return score;
    }

    private static void assertIllegalArgument(String guessString) {
        if (guessString == null) {
            throw new IllegalArgumentException();
        }
        for (char c : guessString.toCharArray()) {
            if (c < 'A' || c > 'z') {
                throw new IllegalArgumentException();
            }
        }
    }
}
