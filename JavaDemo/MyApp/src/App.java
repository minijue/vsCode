
import java.util.Scanner;


public class App{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Fraction a =new Fraction(in.nextInt(),in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close(); 
    }

}

class Fraction {
    int a, b;
    Fraction(int a1, int b1) {
        a = a1;
        b = b1;
    }

    private void yunfeng()
    {
        int aa = Math.abs(a);
        int bb = Math.abs(b);
        if (a * b >= 0) {
            a = aa;
            b = bb;
        }
        else {
            a = -aa;
            b = bb;
        }

        for (int i = aa > bb ? bb : aa; i > 0; i--)
        {
            if (aa % i == 0 && bb % i == 0)
            {
                a /= i;
                b /= i;
                break;
            }
        }
    }

    void print()   {

        if (b == 0)
            System.out.println("错误，分母不能为0");

        else if (a == 0)
            System.out.println("0");
        else {
            yunfeng();
            if (a != b)
                System.out.printf("%d/%d\n", a, b);
            else
                System.out.println("1");
        }
    }

    Fraction plus(Fraction b2) {
        Fraction C;
        int p = b;
        a *= b2.b;
        b *= b2.b;
        b2.a *= p;
        b2.b *= p;
        C.a = a + b2.a;
        C.b = b;
        return C;
    }

    Fraction multiply(Fraction b2)   {
        Fraction C;
        C.a = a * b2.a;
        C.b = b * b2.b;
        return C;
    }

}
