/**
 * @file pow.cpp
 * @author Abhishek
 * @brief
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

    Example 1:
    Input: x = 2.00000, n = 10
    Output: 1024.00000

    Example 2:
    Input: x = 2.10000, n = 3
    Output: 9.26100

    Example 3:
    Input: x = 2.00000, n = -2
    Output: 0.25000
    Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * @version 0.1
 * @date 2022-09-30
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <bits/stdc++.h>

// double myPow(double x, int n)
// {
//     double result = 1;
//     if (n == 0)
//         return 1.0;
//     if (n > 0)
//     {
//         while (n > 0)
//         {
//             result *= x;
//             n--;
//         }
//     }

//     if (n < 0)
//     {
//         while (n < 0)
//         {
//             result /= x;
//             n++;
//         }
//     }

//     return result;
// }
double myPow(double x, int n)
{
    if (n == INT_MAX)
        return x;
    else if (n == INT_MIN)
        return (x == 1 || x == -1) ? 1 : 0;
    if (n < 0)
        x = 1 / x, n *= -1;
    double ans = 1;
    for (int i = 0; i < n; i++)
        ans = ans * x;
    return ans;
}

int main(int argc, char const *argv[])
{
    std::cout << myPow(2, -2);
    return 0;
}
