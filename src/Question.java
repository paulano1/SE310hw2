import java.io.Serializable;

public abstract class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    String questionType;
    String prompt;
    public Question(String questionType, String prompt){
        this.prompt = prompt;
        this.questionType= questionType;
    }

    public String getQuestionType(){
        return questionType;
    }
}
