

public class Day2Check {

    private int min;
    private int max;
    private char c;
    private String password;
    
    public Day2Check(int min, int max, char c, String password) {
        this.min = min;
        this.max = max;
        this.c = c;
        this.password = password;
    }

    public int getMin() {
        return this.min;
    }
    public int getMax() {
        return this.max;
    }
    public char getChar() {
        return this.c;
    }
    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return min + ", " + max + ", " + c + ", " + password;
    }
}
