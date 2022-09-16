#include <iostream>
using namespace std;

bool isPalindrome(int x)
{
    // complete the function
    int digits[10];
    int num = x;
    int i = 0;
    while (x > 0)
    {
        digits[i++] = x % 10;
        x /= 10;
    }
    int r = 0;
    for (int j = 0; j < i; j++)
    {
        r = r * 10 + digits[j];
    }

    return r == num;
}

int main()
{
    int n;
    cin >> n;

    if (isPalindrome(n))
    {
        cout << n << " is a palindrome";
    }
    else
    {
        cout << n << " is NOT a palindrome";
    }
    return 0;
}