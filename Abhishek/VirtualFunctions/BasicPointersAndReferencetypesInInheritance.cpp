/**
 * @file BasicPointersAndReferencetypesInInheritance.cpp
 * @author Abhishek 
 * @brief Here we discuss about the ability to store derived class instance in base 
 * reference/pointer.
 * 1- 
 * @version 0.1
 * @date 2022-07-21
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <string_view>

class Base
{
    protected:
    int mValue {};

    public:
    Base(int value)
    : mValue(value)
    {
    }

    std::string_view getName() const 
    {
        return "Base";
    }
    int getValue() const
    {
        return mValue;
    }
};

class Derived: public Base
{
    public:
    Derived(int value)
    : Base(value)
    {
    }

    std::string_view getName() const
    {
        return "Derived";
    }
    int getValueDoubled() const
    {
        return mValue*2;
    }
};

int main(int argc, char const *argv[])
{
    Derived der{ 5 };
    std::cout << "der is " << der.getName() << " and has a value "
              << der.getValue() << std::endl;

    Derived& rDer{ der };
    std::cout << "rDer is " << rDer.getName() << " and has a value "
              << rDer.getValue() << std::endl;

    Derived* pDer{ &der };
    std::cout << "pDer is " << pDer->getName() << " and has a value "
              << pDer->getValue() << std::endl;


    //******************Base pointers and references

    Base& rDerived{der};
    Base* pDerived{&der};

    std::cout << "der is " << der.getName() << " and has a value "
              << der.getValue() << std::endl;
    std::cout << "rDerived is " << rDerived.getName() << " and has a value "
              << rDerived.getValue() << std::endl;
    std::cout << "pDerived is " << pDerived->getName() << " and has a value "
              << pDerived->getValue() << std::endl;
    return 0;
}
