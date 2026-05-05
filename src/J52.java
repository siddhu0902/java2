import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J52 {
    public static void main(String[] args) {
        System.out.println("Throws Keyword");
        File f1 = new File("words.txt");
        try {
            Scanner sc1 = new Scanner(f1);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
