
public class Main {
    public static void main(String[] args) {
        // 实现类对象作为实参实现多态
        Circle c = new Circle(2.1);
        Rectangle r = new Rectangle(5.0, 2.2);

        System.out.println(volume(c, 2.0));
        System.out.println(volume(r, 2.0));

        // 匿名类对象作为实参实现多态
        Shape s = new Shape() {
            double a=4.0;
            double h=3.2;
            
            public double area() {
                return a*h/2;
            }
        };
        System.out.println(volume(s, 2.0));

        // Lambda表达式对象作为实参实现多态
        double a = 2.3;
        double h = 3.8;
        Shape s1 = () -> a * h / 2.0;
        System.out.println(volume(s1, 2.0));
    }

    // 接口类型形参，可实现多态
    static double volume(Shape s, double height) {
        return s.area() * height;
    }

}

// 接口
interface Shape {
    double area();
}

// 实现类
class Circle implements Shape {
    double r;

    /**
     * @param r
     */
    public Circle(double r) {
        this.r = r;
    }

    public double area() {
        return Math.PI * r * r;
    }
}

class Rectangle implements Shape {
    double a, b;

    /**
     * @param a
     * @param b
     */
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {
        return a * b;
    }
}
