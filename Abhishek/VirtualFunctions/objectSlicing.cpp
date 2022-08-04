/**
 * @file objectSlicing.cpp
 * @author Abhishek
 * @brief Here we discuss about Object Slicing:
 * 1- Whenever we assign a derived instance to a base instance, only the base class part of the object 
 * is copied and the rest is removed, this is called slicing.
 * 2- There are several ways in which object slicing can occur, some of them are:
 *      a. passing argumenst to fuctions by value.
 *      b. using vectoes of type base class.
 * 3- 
 * @version 0.1
 * @date 2022-08-04
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

class Base
{
protected:
    int m_value{};

public:
    Base(int value)
        : m_value{ value }
    {
    }

    virtual const char* getName() const { return "Base"; }
    int getValue() const { return m_value; }
};

class Derived: public Base
{
public:
    Derived(int value)
        : Base{ value }
    {
    }

    const char* getName() const override { return "Derived"; }
};

//a version of object slicing
void printName(Base base)
{
    std::cout << base.getName() << " " << base.getValue();
}

int main(int argc, char const *argv[])
{
    /* Derived der{10};
    //here derived part of the object is sliced off when assigning derived object to base class object.
    //Here a copy constructor is called which is initializing base object using derived instance.
    Base base{der};

    //Hence ony base part of the functionality is ran
    std::cout << base.getName() << " " << base.getValue(); */

    //-------------------------------------

    Derived derived{ 5 };
    

    return 0;
}
