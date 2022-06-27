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

//*************naming a lmabda***

//naming the lambda so that it can be used easily without confusion.
//instead of auto as a type inference, we can also use function pointer as long as the capture is empty.
bool (*isEven)(int) {
    [] (int n) {
        return ((n%2) == 0);
    }
};

int main(int argc, char const *argv[])
{
    std::vector<int> array{ 2, 4, 6 };

    std::cout << std::all_of(array.begin(), array.end(), isEven);
    return 0;
}

//*************naming a lmabda***