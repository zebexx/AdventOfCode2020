
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    private int[] start = { 0, 0 };

    public static ArrayList<String> read() throws FileNotFoundException {
        Scanner s = new Scanner(new File("input\\day3input.txt"));
        ArrayList<String> output = new ArrayList<String>();

        while (s.hasNextLine()) {
            output.add(s.nextLine());
        }
        return output;
    }

    public static int path(ArrayList<String> map) {
        int trees = 0;
        int right = 1;
        int current = 0;
        char tree = '#';
        for(int i = 0; i < map.size(); i+=2) {
            if(current > (map.get(i).length()-1)) {
                current -= map.get(i).length();
            }
            if(map.get(i).charAt(current) == tree) {
                trees++;
            }
            current +=right;
        }
        return trees;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(path(read()));
    }
}
