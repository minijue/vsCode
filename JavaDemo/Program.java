import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int[] monthdays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        if (year <= 0 || month < 1 || month > 12 || day < 0) {
            System.out.println("Invalid date!");
        } else {
            if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
                monthdays[1] = 29;
            }
            if (day > monthdays[month - 1])
                System.out.println("Invalid date!");
            else {
                int days = 0;
                for (int i = 0; i < month - 1; i++) {
                    days += monthdays[i];
                }
                System.out.println(days + day);
            }
        }
        sc.close();
    }
}
