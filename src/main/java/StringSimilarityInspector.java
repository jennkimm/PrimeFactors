public class StringSimilarityInspector {
    String answer;
    int score;

    public StringSimilarityInspector() {
        this.score = 0;
    }

    public int checkLength(String inputString) {
        assertIllegalArgument(inputString);

        double shorter = Math.min(answer.length(), inputString.length());
        double longer = Math.max(answer.length(), inputString.length());

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
