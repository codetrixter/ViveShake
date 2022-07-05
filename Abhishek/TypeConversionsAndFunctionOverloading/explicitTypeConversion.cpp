/**
 * @file explicitTypeConversion.cpp
 * @author Abhsihek
 * @brief Here we discuss types of casting and what are those:
 * 1- There are total five types of casting supported by c++:
 *  a- c-style cast.
 *  b- const cast.-> rarely used
 *  c- static cast.
 *  d- dynamic cast.
 *  e- reinterpret cast.-> rarely used
 * 
 * @version 0.1
 * @date 2022-07-05
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

int main(int argc, char const *argv[])
{
    int x{3};
    int y{4};

    //Here 3 is converted to type double which converst the 4 into double as well
    //(due to priority arithmetic promotion).
    double d{ (double)3/4};
    std::cout << d;

    return 0;
}

