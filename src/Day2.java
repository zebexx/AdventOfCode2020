

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

public class Day2 {

    public static ArrayList<Day2Check> read(Path input) throws NumberFormatException, IOException {
        ArrayList<Day2Check> output = new ArrayList<>();
        for (String line : Files.readAllLines(input)) {
            String[] elements = line.split(" ");
            String[] nums = elements[0].split("-");
            String c = elements[1].replace("-", "");
            output.add(new Day2Check(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]), c.charAt(0), elements[2]));
        }
        return output;
    }

    public static int valid(ArrayList<Day2Check> passwords) {
        int passed = 0;
        for (Day2Check line : passwords) {         
            if (line.getPassword().charAt(line.getMin()-1) == line.getChar() ^ line.getPassword().charAt(line.getMax()-1) == line.getChar()) {
                passed++;
            }
        }
        return passed;
    }
    public static void main(String[] args) throws IOException {
        Path input = Path.of("input\\day2input.txt");

        System.out.println(valid(read(input)));
    }
}
