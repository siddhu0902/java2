import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class J56 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Testing Exceptions");
        File f1 = new File("words1.txt");
        Scanner sc1 = new Scanner(f1);
        FileWriter fw1 = new FileWriter("out2.txt");
        try{
            fw1.write("testing 1");
        }catch (IOException e){
            System.out.println("Something wrong while writing into file");
        }finally{
            fw1.close();
        }

    }
}
