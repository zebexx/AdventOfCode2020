

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day12pt2 {
    public static void main(String[] args) throws IOException {
        int x = 0;
        int y = 0;

        int wx = 10;
        int wy = 1;

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
            int turns = (distance / 90) % 4;
            
            if (line.startsWith("F")) {
                x += wx*distance;
                y += wy*distance;
            }
            else if (line.startsWith("N")) {
                wx += distance*N[0];
                wy += distance*N[1];
            }
            else if (line.startsWith("E")) {
                wx += distance*E[0];
                wy += distance*E[1];
            }
            else if (line.startsWith("S")) {
                wx += distance*S[0];
                wy += distance*S[1];
            }
            else if (line.startsWith("W")) {
                wx += distance*W[0];
                wy += distance*W[1];
            }
            else if (line.startsWith("L")) {
                
                for (int i = 0; i < turns ; i++) {
                    int tmpx = wx;
                    int tmpy = wy;
                    wx = -tmpy;
                    wy = tmpx;
                }
            }
            else if (line.startsWith("R")) {
                
                for (int i = 0; i < turns ; i++) {
                    int tmpx = wx;
                    int tmpy = wy;
                    wx = tmpy;
                    wy = -tmpx;
                }
            }
            
            
            System.out.println(x + " " + y + " " + wx + " " + wy + " " + line);
            
        }
        System.out.println(x + " " + y);
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
