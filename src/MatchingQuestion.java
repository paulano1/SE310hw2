import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MatchingQuestion extends Question implements Serializable {

    HashMap<String, String> matchPairs;
    HashMap<String, String> response;
    public MatchingQuestion(String prompt, HashMap<String, String> matchPairs) {
        super("matching", prompt);
        this.matchPairs = matchPairs;
    }

    public void setResponse(HashMap<String, String> response) {
        this.response = response;
    }

    public HashMap<String, String> getResponse() {
        return response;
    }

}
