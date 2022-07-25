/**
 * @file lambdaCaptures.cpp
 * @author Abhishek
 * @brief Here we discuss about the usage of captures in lambda:
 * 1- These are used to give access to the surrounding variables of the lambda to to the lambda.
 * 2- The defaulkt values captured by the lambda are of constant type and cannot be changed.
 * @version 0.1
 * @date 2022-07-24
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>
#include <array>
#include <string_view>
#include <string>
#include <algorithm>
//************ point-1***
/* int main(int argc, char const *argv[])
{
    std::array<std::string_view, 4> arr{"apple", "banana", "walnut", "lemon"};

    // Ask the user what to search for.
    std::cout << "search for: ";

    std::string search{};
    std::cin >> search;

    auto found{std::find_if(arr.begin(), arr.end(), [search](std::string_view str)
                            {
                                // Search for @search rather than "nut".
                                return (str.find(search) != std::string_view::npos); // Error: search not accessible in this scope 
                            }
                        )};

    if (found == arr.end())
    {
        std::cout << "Not found\n";
    }
    else
    {
        std::cout << "Found " << *found << '\n';
    }

    return 0;
} */
//************ point-1***
//************ point-2***
int main(int argc, char const *argv[])
{
    int  ammo{ 10 };

    auto shoot
    {
        [ammo]() mutable
        {   
            --ammo;     //error: decrement of read-only variable ‘ammo’
            std::cout << "Pew ! " << ammo << "shots left. \n";
        }
    }; 

    shoot();
    std::cout << ammo << "shots left\n";

    return 0;
}
//************ point-2***
