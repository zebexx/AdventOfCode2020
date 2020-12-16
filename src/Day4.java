

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day4 {

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> a1 = new ArrayList<>();
        ArrayList<String> passports = new ArrayList<>();
        int validPassCount = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("input\\day4input.bat"));      
            String line = "";
            while ((line = br.readLine()) != null) {
                a1.add(line);
            }
            br.close();
            int index = 0;
            while (index < a1.size()){
                String toAdd = "";
                while (index < a1.size() && !a1.get(index).isBlank()) {
                    toAdd += a1.get(index) + " ";
                    index++;
                }
                passports.add(toAdd);
                index++;
            }
            for (int i = 0; i < passports.size(); i++) {
                String pass = passports.get(i);
                Scanner sc = new Scanner(pass);
                ArrayList<String> fields = new ArrayList<>();
                while (sc.hasNext()) {
                    fields.add(sc.next());
                }
                if (fields.size() == 7){
                    int validFieldCount = 0;
                    for (int j = 0; j < fields.size(); j++) {
                        String field = fields.get(j);
                        if (field.startsWith("ecl") || field.startsWith("pid")
                            || field.startsWith("eyr") || field.startsWith("hcl")
                            || field.startsWith("byr") || field.startsWith("iyr")
                                                       || field.startsWith("hgt")) {
                            validFieldCount++;
                        }
                    }
                    if (validFieldCount == 7) {
                        validPassCount++;
                    }
                } else if (fields.size() == 8) {
                    validPassCount++;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: " + ex);
        } catch (IOException io) {
            System.out.println("IO Exception: " + io);
        }
        System.out.println(validPassCount);
    }
}
