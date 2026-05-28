public class StringSimilarityInspector {
    String answer;
    int score;

    public StringSimilarityInspector() {
        this.score = 0;
    }

    public int checkLength(String guessString) {
        assertIllegalArgument(guessString);

        double shortLength = answer.length();
        double longLength = guessString.length();
        if (answer.length() > guessString.length()) {
            shortLength = guessString.length();
            longLength = answer.length();
        }

        if (shortLength == longLength) {
            score += 60;
        } else if (longLength < shortLength * 2) {
            score += (int) ((1-(longLength - shortLength)/shortLength) * 60);
            System.out.println(shortLength);
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
