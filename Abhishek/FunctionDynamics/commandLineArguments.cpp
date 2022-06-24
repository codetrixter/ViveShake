/**
 * @file commandLineArguments.cpp
 * @author Abhishek
 * @brief Here we look at how command line arguments work:
 * 
 * @version 0.1
 * @date 2022-06-24
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

int main(int argc, char const *argv[])
{
    for(int i = 0; i < argc; i++)
    {
        std::cout << i << ' ' << argv[i] << "\n";
    }
    return 0;
}
