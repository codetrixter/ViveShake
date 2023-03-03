/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go
 * outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21

    Constraints:
    -231 <= x <= 231 - 1
*/
#include <bits/stdc++.h>
using namespace std;

/* int reverse(int x)
{
    vector<int> rev;
    if (x / 10 == 0)
        return x;

    int temp = abs(x);
    int sum = 0;
    while (temp != 0)
    {
        rev.push_back(temp % 10);
        temp = temp / 10;
    }

    int n = rev.size() - 1;
    for (auto i : rev)
    {
        sum += i * pow(10, n--);
        if (sum > INT_MAX)
            return 0;
    }

    if (x < 0)
        return sum * -1;
    else
        return sum;
} */
//---------Alternate working within range------
int reverse(int x)
{
    int reverseNumber = 0;
    while (x != 0)
    {
        int remainder = x % 10;
        if ((reverseNumber > INT_MAX / 10) || ((reverseNumber == INT_MAX / 10) && (remainder > 7)))
            return 0;
        if ((reverseNumber < INT_MIN / 10) || ((reverseNumber == INT_MIN / 10) && (remainder < -8)))
            return 0;
        reverseNumber = reverseNumber * 10 + remainder;
        x = x / 10;
    }
    return reverseNumber;
}

//-----------------------------------------------

int main(int argc, char const *argv[])
{
    cout << reverse(123);
    return 0;
}
