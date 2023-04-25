interface NumericFunc {
  int func(int n);
}

public class Example {
  public static void main(String[] args) {
    NumericFunc smallest = n -> {
      int result = 1;
      n = n < 0 ? -n : n;
      for (int i = 2; i <= n / i; i++)
        if ((n % i) == 0) {
          result = i;
          break;
        }
      return result;
    };
  }
}
