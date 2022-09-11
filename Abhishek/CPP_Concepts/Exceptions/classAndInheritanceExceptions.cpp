/**
 * @file classAndInheritanceExceptions.cpp
 * @author Abhishek
 * @brief Here we discuss about the exceptional scenarios related to following:
 * 1- member functions: Exceptions can be used to indiacate error conditions that may occur  during the execution of out member function.
 * 2- Inheritance: 
 * @version 0.1
 * @date 2022-09-11
 * 
 * @copyright Copyright (c) 2022
 * 
 */
//*************In operator overloaded subscript***
/* int& IntArray::operator[](const int index)
{
    if (index < 0 || index >= getLength())
        throw index;

    return m_data[index];
} */
//*************In operator overloaded subscript***
#include <iostream>

class Member
{
public:
	Member()
	{
		std::cerr << "Member allocated some resources\n";
	}

	~Member()
	{
		std::cerr << "Member cleaned up\n";
	}
};

class A
{
private:
	int m_x {};
	Member m_member;

public:
	A(int x) : m_x{x}
	{
		if (x <= 0)
			throw 1;    //when an exception is thown here, the destructor of already allocated Member object is called and resource is freed.
	}

	~A()
	{
		std::cerr << "~A\n"; // should not be called, since the object is never constructed properly when exception occurs.
	}
};


int main()
{
	try
	{
		A a{1};
	}
	catch (int)
	{
		std::cerr << "Oops\n";
	}

	return 0;
}