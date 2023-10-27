import java.io.*;
import java.util.ArrayList;
import java.nio.file.*;
public class SurveySerializer {

    public static void serialize(ArrayList<Question> questions, String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath();
        Path parentDir = path.getParent();

        if (parentDir != null && !Files.exists(parentDir)) {
            Files.createDirectories(parentDir);
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(questions);
        }
    }

    public static Question[] deserialize(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Question[]) ois.readObject();
        }
    }
}