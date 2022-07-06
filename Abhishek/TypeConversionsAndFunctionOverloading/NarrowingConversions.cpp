/**
 * @file NarrowingConversions.cpp
 * @author Abhishek
 * @brief Here we discuss the Numeric conversion that narrow the width of the type:
 * 1- This may result in the loss of data/precision, such conversions are like:
 *  a- floating to integral.
 *  b- wider integral to narrower integral.
 * 2- We should avoid such conversions in general, if needed we can use static_cast for explicit conversions.
 * @version 0.1
 * @date 2022-07-01
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

int main(int argc, char const *argv[])
{
    double d = 5.0;

    int val = 0;
    //explicit conversion
    val = static_cast<int>(d);

    std::cout << val;
    return 0;
}
