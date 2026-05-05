import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class J46 {
    public  static void main(String[] args) throws IOException {
        System.out.println("File Handling");
        File f1 = new File("words1.txt");
        FileWriter fw1 = new FileWriter("out1.txt");
        Scanner sc1 = new Scanner(f1);
        String s1 = sc1.nextLine();
        System.out.println(s1);
        fw1.write(s1);
        fw1.close();

    }
}
