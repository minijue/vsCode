import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

class Fraction {
    private int a, b;

    public Fraction(int a, int b) {
        this.a = a;
        this.b = b;
        yuefen();
    }

    private void yuefen() {
        int aa = (int) Math.abs(a);
        int ab = (int) Math.abs(b);
        if (a * b >= 0) {
            a = aa;
            b = ab;
        } else {
            a = -aa;
            b = ab;
        }
        for (int i = ((aa < ab) ? aa : ab); i > 1; i--) {
            if (a % i == 0 && b % i == 0) {
                a /= i;
                b /= i;
                break;
            }
        }
    }

    public Fraction multiply(Fraction b2) {
        return new Fraction(a * b2.a, b * b2.b);
    }

    public Fraction plus(Fraction b2) {
        return new Fraction(a * b2.b + b * b2.a, b * b2.b);
    }

    public void print() {
        if (b == 0)
            System.out.println("错误，分母不能为0");
        else {
            if (a == 0)
                System.out.println("0");
            else {
                if (b == 1)
                    System.out.println(a);
                else {
                    System.out.println(a + "/" + b);
                }
            }
        }
    }
}