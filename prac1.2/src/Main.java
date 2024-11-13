import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String inputText = scanner.nextLine();

        System.out.println("Введіть літеру для фільтрації слів:");
        String filterLetter = scanner.nextLine().toLowerCase();

        List<String> words = splitIntoWords(inputText);

        List<String> filteredWords = filterWordsByLetter(words, filterLetter);

        Set<String> uniqueWords = findUniqueWords(words);

        List<String> sortedWords = sortWordsAlphabetically(words);

        long uniqueWordCount = countUniqueWords(words);

        System.out.println("Результати:");
        System.out.println("Слова, що починаються з літери \"" + filterLetter + "\": " + filteredWords);
        System.out.println("Унікальні слова: " + uniqueWords);
        System.out.println("Слова за алфавітом: " + sortedWords);
        System.out.println("Кількість унікальних слів: " + uniqueWordCount);
    }

    public static List<String> splitIntoWords(String text) {
        return Stream.of(text.split("\\s+"))
                .map(word -> word.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase())
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
    }

    public static List<String> filterWordsByLetter(List<String> words, String letter) {
        return words.stream()
                .filter(word -> word.startsWith(letter))
                .collect(Collectors.toList());
    }

    public static Set<String> findUniqueWords(List<String> words) {
        return new HashSet<>(words);
    }

    public static List<String> sortWordsAlphabetically(List<String> words) {
        return words.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static long countUniqueWords(List<String> words) {
        return words.stream()
                .distinct()
                .count();
    }
}