import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
    public static void createSurvey(){
        ArrayList<Question> listOfQuestions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {

            System.out.println("What type of question would you like to enter? (TF/Matching)");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("TF")) {
                System.out.println("Enter the prompt for the True/False question:");
                String prompt = scanner.nextLine();
                TrueFalseQuestion tfq = new TrueFalseQuestion(prompt);
                listOfQuestions.add(tfq);
            }
            else if (type.equalsIgnoreCase("matching")) {
                System.out.println("Enter the prompt for the Matching question:");
                String prompt = scanner.nextLine();
                System.out.println("How many pairs do you want to enter for the matching question?");
                int pairs = scanner.nextInt();
                scanner.nextLine();
                HashMap<String, String> matchPairs = new HashMap<>();
                for (int j = 0; j < pairs; j++) {
                    System.out.println("Enter key for pair " + (j + 1) + ":");
                    String key = scanner.nextLine();
                    System.out.println("Enter value for pair " + (j + 1) + ":");
                    String value = scanner.nextLine();

                    matchPairs.put(key, value);
                }

                MatchingQuestion mq = new MatchingQuestion(prompt, matchPairs);
                listOfQuestions.add(mq);
            }
        }
        try {
            SurveySerializer.serialize(listOfQuestions, "questions.ser");
        } catch (IOException e) {
            System.out.printf(e.getLocalizedMessage());
        }

    }

    public static void main(String[] args){
        answerSurvey();
        }

    private static void answerSurvey() {

    }
}
}