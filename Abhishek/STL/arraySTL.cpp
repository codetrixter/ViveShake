/**
 * @file arraySTL.cpp
 * @author Abhishek
 * @brief Array class in c++ has following benefits compared to c-style arrays:
 * 1- These know their own size, hence while passing to functions we need to pass size as a parameter
 * 2- Array classes don't decay into pointers.
 * 3- These are generally more efficient, light-weight and reliable.
 * @version 0.1
 * @date 2022-06-12
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <array>
#include <tuple>
//************at(), get() and operator[]***

int main(int argc, char const *argv[])
{
    std::array<int, 6> ar = {1, 2, 3, 4, 5, 6};

    std::cout << "\n array elements using at() : ";
    for(int i = 0; i < 6; i++)
        std::cout << ar.at(i) << " ";
    std::cout << std::endl;

    std::cout << "\n array elements using get() : ";
    std::cout << std::get<0>(ar) << " " << std::get<1>(ar) << " ";
    std::cout << std::get<2>(ar) << " " << std::get<3>(ar) << " ";
    std::cout << std::get<4>(ar) << " " << std::get<5>(ar) << " ";
    std::cout << std::endl;

    std::cout << "\n The array elements are (using operator[]) : ";
    for ( int i=0; i<6; i++)
    std::cout << ar[i] << " ";
    std::cout << std::endl;

    return 0;
}
//************at(), get() and operator[]***
