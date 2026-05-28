public class StringSimilarityInspector {
    public static final int MAX_LENGTH_SCORE = 60;
    public static final int MAX_ALPHA_SCORE = 40;
    int score;

    public int checkString(String inputString, String inputString2) {

        assertIllegalArgument(inputString);
        assertIllegalArgument(inputString2);

        score = 0;
        checkLength(inputString, inputString2);
        checkAlpha(inputString, inputString2);
        return score;
    }

    private void checkLength(String inputString, String inputString2) {
        double shorter = Math.min(inputString2.length(), inputString.length());
        double longer = Math.max(inputString2.length(), inputString.length());

        if (shorter == longer)
            score += MAX_LENGTH_SCORE;
        else if (longer < shorter * 2) {
            score += (shorter - (longer - shorter)) * MAX_LENGTH_SCORE / shorter;
        }
    }

    private void checkAlpha(String inputString, String inputString2) {
        if (inputString.equals(inputString2)) {
            score += MAX_ALPHA_SCORE;
        } else {
            boolean[] first = new boolean[26];
            boolean[] second = new boolean[26];

            for (int i = 0; i < inputString.length(); i++) {
                first[inputString.charAt(i) - 'A'] = true;
            }

            for (int i = 0; i < inputString2.length(); i++) {
                second[inputString2.charAt(i) - 'A'] = true;
            }

            int totalCnt = 0;
            int sameCnt = 0;

            for (int i = 0; i < 26; i++) {

                if (first[i] || second[i]) {
                    totalCnt++;
                }

                if (first[i] && second[i]) {
                    sameCnt++;
                }
            }

            score += (sameCnt * 40) / totalCnt;
        }
    }

    private static void assertIllegalArgument(String guessString) {
        if (guessString == null) {
            throw new IllegalArgumentException();
        }
        for (char c : guessString.toCharArray()) {
            if (c < 'A' || c > 'Z') {
                throw new IllegalArgumentException();
            }
        }
    }
}
