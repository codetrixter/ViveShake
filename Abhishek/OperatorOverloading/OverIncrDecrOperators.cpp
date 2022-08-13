/**
 * @file OverIncrDecrOperators.cpp
 * @author Abhishek
 * @brief Here we explore the following:
 * 1- Prefix increment and decrement operator overloading.
 * @version 0.1
 * @date 2022-08-12
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

class Digit
{
private:
    int m_digit;
public:
    Digit(int digit=0)
        : m_digit{digit}
    {
    }

    Digit& operator++();
    Digit& operator--();

    friend std::ostream& operator<< (std::ostream& out, const Digit& d);
};

Digit& Digit::operator++()
{
    if(m_digit == 9)
        m_digit = 0;
    else
        ++m_digit;

    return *this;
}

Digit& Digit::operator--()
{
    if(m_digit == 0)
        m_digit = 9;
    else
        --m_digit;

    return *this;
}

std::ostream& operator<< (std::ostream& out, const Digit& d)
{
    return out << d.m_digit;
}

int main(int argc, char const *argv[])
{
    Digit digit(8);

    std::cout << digit;
    std::cout << ++digit;
    std::cout << ++digit;
    std::cout << --digit;
    std::cout << --digit;
    return 0;
}
