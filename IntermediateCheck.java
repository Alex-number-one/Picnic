import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class IntermediateCheck {
    public static void main(String[] args) {
        String fileName = "input.txt";
        Map<String, Integer> wordFrequency = new HashMap<>();
        int totalWords = 0;
        String longestWord = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                totalWords += words.length;

                for (String word : words) {
                    if (!wordFrequency.containsKey(word)) {
                        wordFrequency.put(word, 1);
                    } else {
                        wordFrequency.put(word, wordFrequency.get(word) + 1);
                    }

                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.printf("Total number of words: %d%n", totalWords);
        System.out.printf("Longest word: %s%n", longestWord);
        System.out.println("Word frequency:");

        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
           
    }
    }
