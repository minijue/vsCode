import java.util.Scanner;

public class JAVADEMO {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        String article = sin.nextLine();
        sin.close();
        String[] words = article.split(" ");
        for (int i = 0; i < words.length; i++) {
            StringBuffer sb = new StringBuffer(words[i]);
            System.out.print(sb.reverse());
            if (i < words.length - 1)
                System.out.print(" ");
            else
                System.out.println();
        }
    }
}
