import java.util.Scanner;

interface SortMethod {
    void sort(int[] nums);
}

class InsertSort implements SortMethod {
    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}

class BubbleSort implements SortMethod {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}

class SortedInts {
    public static void newsort(int[] numbers, SortMethod s) {
        s.sort(numbers);
        for (int n : numbers) {
            System.out.printf("%d ", n);
        }
        System.out.println();
    }
}

public class Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ns = new int[8];
        for (int i = 0; i < ns.length; i++)
            ns[i] = sc.nextInt();
        InsertSort is = new InsertSort();
        SortedInts.newsort(ns, is);

        BubbleSort bs = new BubbleSort();
        SortedInts.newsort(ns, bs);
        sc.close();
    }
}