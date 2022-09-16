import java.io.*;
import java.util.Scanner;

public class JAVADEMO {
    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileInputStream("d:\\a.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String str;
        while (sc.hasNext()) {
            str = sc.nextLine();
            System.out.println(str);
        }
        sc.close();

    }
}
