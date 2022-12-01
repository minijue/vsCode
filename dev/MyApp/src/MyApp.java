import java.util.Scanner;

public class MyApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        System.out.println(f);
        sc.close();
    }
}