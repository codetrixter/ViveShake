/**
 * @file functionOverloading.cpp
 * @author Abhishek
 * @brief Here we discuss the intrecacies of function overloading:
 * 1- 
 * @version 0.1
 * @date 2022-07-14
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

int add(int a, int b)
{
    return a+b;
}

//error: ambiguating new declaration of ‘double add(int, int)’ , note: old declaration ‘int add(int, int)’
/* double add(int a, int b)
{
    return a+b;
} */

double add(double da, double db)
{
    return da+db;
}
int main(int argc, char const *argv[])
{
    std::cout << add(4, 5);
    std::cout << add(10.5, 10.0);
    return 0;
}
