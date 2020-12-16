

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day12 {
    public static void main(String[] args) throws IOException {
        int x = 0;
        int y = 0;
        int[] N = {0,1};
        int[] E = {1,0};
        int[] S = {0,-1};
        int[] W = {-1,0};

        ArrayList<int[]> d= new ArrayList<int[]>();
        d.add(N);
        d.add(E);
        d.add(S);
        d.add(W);

        int direction = 1;

        ArrayList<String> input = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader("input\\day12input.txt"));
        String read = "";
        while((read = br.readLine()) != null) {
            input.add(read);
        }

        

        for(String line : input) {
            int distance = Integer.parseInt(line.substring(1));
            
            if (line.startsWith("F")) {
                x += distance*d.get(direction)[0];
                y += distance*d.get(direction)[1];
            }
            else if (line.startsWith("N")) {
                x += distance*N[0];
                y += distance*N[1];
            }
            else if (line.startsWith("E")) {
                x += distance*E[0];
                y += distance*E[1];
            }
            else if (line.startsWith("S")) {
                x += distance*S[0];
                y += distance*S[1];
            }
            else if (line.startsWith("W")) {
                x += distance*W[0];
                y += distance*W[1];
            }
            else if (line.startsWith("L")) {
                int turn = distance / 90;
                direction -= turn;
                while(direction < 0) {
                    direction += 4;
                }
            }
            else if (line.startsWith("R")) {
                int turn = distance / 90;
                direction += turn;
                while(direction > 3) {
                    direction -= 4;
                }
            }
            
            
            System.out.println(x + " " + y + " " + direction + line);
            
        }
        System.out.println(x + " " + y);
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
