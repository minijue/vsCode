public class App {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        System.out.println("Hello, World!");

        s.student = "Hello";
    }
}

class Student {
    String student;
}