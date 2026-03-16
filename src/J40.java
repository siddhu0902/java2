import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J40 {
    public static boolean Palindrome(String s1) {
        if (s1 == null) {
            return false;
        }
        s1 = s1.toLowerCase();
        String reverse = "";
        for (int i = s1.length() - 1; i >= 0; i--) {
            reverse = reverse + s1.charAt(i);
        }
        return s1.equals(reverse);
    }
    public static void Palindrome(File f1) throws FileNotFoundException {
        Scanner sc = new Scanner(f1);
        while (sc.hasNextLine()) {
            String word = sc.nextLine();
            if (Palindrome(word)) {
                System.out.println(word);
            }
        }
        sc.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("words.txt");
        Palindrome(file);
    }
}
