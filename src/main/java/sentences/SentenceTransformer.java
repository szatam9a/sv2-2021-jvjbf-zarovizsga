package sentences;

import java.util.Locale;

public class SentenceTransformer {


    public String shortenSentence(String sentence) {
        String result;
        String[] tmpray = sentence.split(" ");

        if (checkSentenceIfValid(sentence)) {
            if (tmpray.length > 4) {
                return tmpray[0] + " ... " + tmpray[tmpray.length - 1];
            }
        }
        return sentence;
    }

    private boolean checkSentenceIfValid(String sentence) {
        int length = sentence.length();
        String validEnds = ".!?";

        if (!validEnds.contains(sentence.substring(length - 1, length))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
        String firstLetter = sentence.substring(0, 1);
        if (!sentence.substring(0, 1).equals(firstLetter.toUpperCase(Locale.ROOT))) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        return true;
    }

}
