public class StringSimilarityInspector {
    int score;

    public StringSimilarityInspector() {
        this.score = 0;
    }

    public int checkLength(String inputString, String inputString2) {
        assertIllegalArgument(inputString);

        double shorter = Math.min(inputString2.length(), inputString.length());
        double longer = Math.max(inputString2.length(), inputString.length());

        if (shorter == longer)
            score += 60;
        else if (longer < shorter * 2) {
            score += (shorter - (longer - shorter)) * 60 / shorter;
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
