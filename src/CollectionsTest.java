import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;


public class CollectionsTest {

    /**
     * Подсчитывает слова на латинице. Выводит самое частое слово и сколько раз встречалось
     *
     * @param filePath путь файла
     * @return возвращает TreeMap где key = слово в файле, value = сколько раз встречается
     */
    public static TreeMap<String, Integer> wordCounter(String filePath) {

        Pattern pattern = Pattern.compile("\\W+");
        TreeMap<String, Integer> wordMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        try {
            Scanner scan = new Scanner(new File(filePath)).useDelimiter(pattern);

            while (scan.hasNext()) {

                String currentWord = scan.next();
                Integer stats = wordMap.get(currentWord);
                if (stats == null) {
                    stats = 0;
                }
                wordMap.put(currentWord, ++stats);
            }
            for (String key : wordMap.keySet())
                if (wordMap.get(key).equals(Collections.max(wordMap.values())))
                    System.out.println(key + " " + wordMap.get(key));

            return wordMap;


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;

        }


    }


    public static void main(String[] args) {


    }
}
