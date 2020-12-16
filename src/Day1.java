import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class Day1 {


    public static ArrayList<Integer> readInput(Path input) throws IOException {
        List<String> numberString = Files.readAllLines(input);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < numberString.size(); i++) {
            numbers.add(Integer.parseInt(numberString.get(i)));
        }
        return numbers;
    }

    public static void answer(ArrayList<Integer> numbers) {

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                for (int x = 0; x < numbers.size(); x++) {
                    if (numbers.get(i)+numbers.get(j)+numbers.get(x) == 2020) {
                        System.out.println(numbers.get(i) * numbers.get(j) * numbers.get(x));
                        return;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Path input = Path.of("input\\day1input.txt");
        
        answer(readInput(input));
    }
}