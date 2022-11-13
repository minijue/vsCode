public class MyApp {
    public static void main(String[] args) {
        int a = 15, b = 20;
		System.out.println("调用方法前，a=" + a + "，b=" + b);
		
		Test.swap(a, b);
		System.out.println("调用方法后，a=" + a + "，b=" + b);
    }
}
