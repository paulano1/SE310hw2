import java.io.Serializable;

public class TrueFalseQuestion extends Question implements Serializable {
    private boolean response;
    public TrueFalseQuestion( String prompt) {
        super("TF", prompt);
    }

    public void setResponse(boolean response) {
        this.response = response;
    }
    public boolean getResponse(){
        return response;
    }
}
