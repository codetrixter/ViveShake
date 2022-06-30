/**
 * @file anonymousFunctions.cpp
 * @author Abhishek
 * @brief Here we discuss the uses and purpose of lambda.
 * 1- example of a program without lambda, but needs one.
 * 2- Syntax of a lambda/closure is :
 * [captureClause](parameters) -> reurn type
 * {
 *      function body
 * }
 * 3- We can name/create variable for a lambda so that we can directly use that name 
 * while passing as function parameter.
 * 4- Lambda's can be stored using either auto(type deduction) or std::function.
 * 5- use auto when initializing variable with lambda and use std::function otherwise.
 * @version 0.1
 * @date 2022-06-27
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <array>
#include <string_view>
#include <algorithm>
#include <functional>

// Our function will return true if the element matches
// Here (C++17)std::string_view is the class which takes the copy of a string and then if another string is created from it
// the new string will not be copied, instead it will be used as a reference to the original string
// (no new memory allocated)
/* bool containsNut(std::string_view str)
{
    // std::string_view::find returns std::string_view::npos if it doesn't find
    // the substring. Otherwise it returns the index where the substring occurs
    // in str.
    return (str.find("nut") != std::string_view::npos);
}

int main()
{
    std::array<std::string_view, 4> arr{ "apple", "banana", "walnut", "lemon" };

    // Scan our array to see if any elements contain the "nut" substring
    // Here containsNut() function is only used once and then never again, so it is useless to define it with name.
    // We can use lambdas here to avoid such single use functions.
    //auto found{ std::find_if(arr.begin(), arr.end(), containsNut) };

    //Lambda version, this type of use of lambda right where it is used is also called function literal.
    auto found = std::find_if(arr.begin(), arr.end(), [](std::string_view str) {
        //body of the nameless function goes here.
        //return type of this function is deduced automatically by the compiler, by looking at the 
        //last line of the function.
        return (str.find("nut") != std::string_view::npos);
    });

    if (found == arr.end())
    {
        std::cout << "No nuts\n";
    }
    else
    {
        std::cout << "Found " << *found << '\n';
    }

    return 0;
} */

//*************naming a lambda***
//naming the lambda so that it can be used easily without confusion.
//instead of auto as a type inference, we can also use function pointer as long as the capture is empty.
// bool (*isEven)(int) {
//     [] (int n) {
//         return ((n%2) == 0);
//     }
// };

// int main(int argc, char const *argv[])
// {
//     std::vector<int> array{ 2, 4, 6 };
//     //std::all_of is a part of algorithm header, and it iterates through the given data structor and
//     //checks for condition for each element of the structure
//     std::cout << std::all_of(/* firs position interator */array.begin(), /* end pos iterator */array.end(), 
//     /* pred function that accepts an element and return bool */ isEven);
//     return 0;
// }
//*************naming a lambda***
//*************storing lambda***
/* int main(int argc, char const *argv[])
{
    //this version cannot have captures
    int (*addNumbers1)(int, int){
        [](int a, int b)
        {
            return a+b;
        }
    };

    std::cout << addNumbers1(10, 20) << std::endl;

    //This version can have captures as well
    std::function<int(int,int)> addNumbers2{
        [](int a, int b)
        {
            return a+b;
        }
    };

    std::cout << addNumbers2(20, 30) << std::endl;

    //This version of lambda can also have captures
    auto addNumbers3{
        [](int a, int b)
        {
            return a+b;
        }
    };

    std::cout << addNumbers1(30, 40) << std::endl;
    return 0;
} */
//*************storing lambda***
//*************using std::function for func param***
// We don't know what fn will be. std::function works with regular functions and lambdas.
//Here auto cannot be used, it is only allowed since c++20.
void repeat(int repetitions, const std::function<void(int)>& fn)
{
  for (int i{ 0 }; i < repetitions; ++i)
  {
    fn(i);
  }
}

int main()
{
  repeat(3, [](int i) {
    std::cout << i << '\n';
  });

  return 0;
}
//*************using std::function for func param***