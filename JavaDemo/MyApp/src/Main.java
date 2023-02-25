import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> evennums = new ArrayList<Double>();
        double sum = 0;
        int n = 0;
        while (evennums.size() < 3) {
            double num = scanner.nextDouble();
            // your code goes here
            evennums.add(num);
            sum += num;
            n++;
        }
        // calculate and output the average integer value
        System.out.println(sum / n);
    }
}
