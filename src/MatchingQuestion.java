import java.io.Serializable;
import java.util.HashMap;

public class MatchingQuestion extends Question implements Serializable {

    HashMap<String, String> response;
    public MatchingQuestion(String questionType, String prompt) {
        super(questionType, prompt);
    }

    public void setResponse(HashMap<String, String> response) {
        this.response = response;
    }

    public HashMap<String, String> getResponse() {
        return response;
    }
}
