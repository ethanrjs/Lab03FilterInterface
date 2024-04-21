import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShortLister {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (Scanner scanner = new Scanner(selectedFile)) {
                List<String> words = new ArrayList<>();
                while (scanner.hasNext()) {
                    words.add(scanner.next());
                }
                Object[] wordsArray = words.toArray();
                List<Object> shortWords = FilterUtils.collectAll(wordsArray, new ShortWordFilter());
                shortWords.forEach(System.out::println);
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            }
        }
    }
}
