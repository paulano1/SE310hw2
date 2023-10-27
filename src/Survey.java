import java.util.Scanner;
import java.util.HashMap;

public class Survey {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assuming you want to collect 5 questions for simplicity.
        // You can adjust this number based on your needs.
        Question[] questions = new Question[2];

        for (int i = 0; i < questions.length; i++) {
            System.out.println("What type of question would you like to enter? (TF/Matching)");
            String type = scanner.nextLine();

            if (type.equalsIgnoreCase("TF")) {
                System.out.println("Enter the prompt for the True/False question:");
                String prompt = scanner.nextLine();

                TrueFalseQuestion tfq = new TrueFalseQuestion(prompt);
                System.out.println("Enter the response (true/false):");
                boolean response = scanner.nextBoolean();
                scanner.nextLine(); // Consume the newline character

                tfq.setResponse(response);
                questions[i] = tfq;

            } else if (type.equalsIgnoreCase("Matching")) {
                System.out.println("Enter the prompt for the Matching question:");
                String prompt = scanner.nextLine();

                MatchingQuestion mq = new MatchingQuestion("Matching", prompt);

                System.out.println("How many pairs do you want to enter for the matching question?");
                int pairs = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                HashMap<String, String> response = new HashMap<>();
                for (int j = 0; j < pairs; j++) {
                    System.out.println("Enter key for pair " + (j + 1) + ":");
                    String key = scanner.nextLine();
                    System.out.println("Enter value for pair " + (j + 1) + ":");
                    String value = scanner.nextLine();

                    response.put(key, value);
                }

                mq.setResponse(response);
                questions[i] = mq;

            } else {
                System.out.println("Invalid question type.");
                i--; // decrement i to re-enter the question
            }
        }

        // Display entered questions and responses
        for (Question question : questions) {
            System.out.println("Prompt: " + question.prompt);
            if (question instanceof TrueFalseQuestion) {
                TrueFalseQuestion tfq = (TrueFalseQuestion) question;
                System.out.println("Response: " + tfq.getResponse());
            } else if (question instanceof MatchingQuestion) {
                MatchingQuestion mq = (MatchingQuestion) question;
                System.out.println("Responses: " + mq.getResponse());
            }
        }

        scanner.close();
    }
}
