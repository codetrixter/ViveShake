/**
 * @file exceptionHandlingBasics.cpp
 * @author Abhishek Mishra
 * @brief Here we discuss about the exception and how they are caught and thrown:
 * 1- Basic use of try, catch and throw.
 * 2-
 * @version 0.1
 * @date 2022-09-06
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <string>

int main(int argc, char const *argv[])
{
    try
    {
        // Statements that may throw exceptions you want to handle go here
        throw -1; // here's a trivial example
    }
    catch (int x)
    {
        // Any exceptions of type int thrown within the above try block get sent here
        std::cerr << "We caught an int exception with value: " << x << '\n';
    }
    catch (double) // no variable name since we don't use the exception itself in the catch block below
    {
        // Any exceptions of type double thrown within the above try block get sent here
        std::cerr << "We caught an exception of type double" << '\n';
    }
    catch (const std::string&) // catch classes by const reference
    {
        // Any exceptions of type std::string thrown within the above try block get sent here
        std::cerr << "We caught an exception of type std::string" << '\n';
    }

    std::cout << "Continuing on our merry way\n";
    return 0;
}
