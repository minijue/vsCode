func fib(n: Int) -> Int {
  return n < 2 ? n : (fib(n: n-1) + fib(n: n-2))
}
print(fib(n: 3))