import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст для аналізу:");
        String text = scanner.nextLine();

        while (true) {
            System.out.println("Оберіть операцію:");
            System.out.println("1. Пошук слова");
            System.out.println("2. Замінити слово");
            System.out.println("3. Підрахунок кількості слів");
            System.out.println("4. Вихід");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введіть слово для пошуку:");
                    String searchWord = scanner.nextLine();

                    Predicate<String> findWord = s -> s.contains(searchWord);

                    if (findWord.test(text)) {
                        System.out.println("Слово знайдено у тексті.");
                    } else {
                        System.out.println("Слово не знайдено у тексті.");
                    }
                    break;

                case 2:
                    System.out.println("Введіть слово для заміни:");
                    String oldWord = scanner.nextLine();
                    System.out.println("Введіть нове слово:");
                    String newWord = scanner.nextLine();

                    BiFunction<String, String, String> replaceWord = (textToModify, word) -> textToModify.replaceAll(word, newWord);

                    String modifiedText = replaceWord.apply(text, oldWord);
                    System.out.println("Оновлений текст:");
                    System.out.println(modifiedText);
                    break;

                case 3:
                    Function<String, Integer> countWords = t -> t.split("\\s+").length;

                    int wordCount = countWords.apply(text);
                    System.out.println("Кількість слів у тексті: " + wordCount);
                    break;

                case 4:
                    System.out.println("Вихід з програми.");
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}