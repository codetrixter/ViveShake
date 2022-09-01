/**
 * @file move-ctor&assign.cpp
 * @author Abhishek
 * @brief Here we discuss about the move constructor and move assignment operator:
 * 1- 
 * @version 0.1
 * @date 2022-08-31
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

template<typename T>
class Auto_ptr3
{
	T* m_ptr;
public:
	Auto_ptr3(T* ptr = nullptr)
		:m_ptr(ptr)
	{
	}

	~Auto_ptr3()
	{
		delete m_ptr;
	}

	// Copy constructor
	// Do deep copy of a.m_ptr to m_ptr
	Auto_ptr3(const Auto_ptr3& a)
	{
		m_ptr = new T;
		*m_ptr = *a.m_ptr;
	}

	// Move constructor
	// Transfer ownership of a.m_ptr to m_ptr
	Auto_ptr3(Auto_ptr3&& a) noexcept
		:m_ptr(a.m_ptr)
	{
		m_ptr = nullptr;	// we'll talk more about this line below
	}

	// Copy assignment
	// Do deep copy of a.m_ptr to m_ptr
	Auto_ptr3& operator=(const Auto_ptr3& a)
	{
		// Self-assignment detection
		if (&a == this)
			return *this;

		// Release any resource we're holding
		delete m_ptr;

		// Copy the resource
		m_ptr = new T;
		*m_ptr = *a.m_ptr;

		return *this;
	}

	// Move assignment
	// Transfer ownership of a.m_ptr to m_ptr
	Auto_ptr3& operator= (Auto_ptr3&& a) noexcept
	{
		// Self-assignment detection
		if (&a == this)
			return *this;

		// Release any resource we're holding
		delete m_ptr;

		//move the resource from a.m_ptr to m_ptr
		m_ptr = a.m_ptr;
		a.m_ptr = nullptr;
		
		return *this;
	}

	T& operator*() const { return *m_ptr; }
	T* operator->() const { return m_ptr; }
	bool isNull() const { return m_ptr == nullptr; }
};

class Resource
{
public:
	Resource() { std::cout << "Resource acquired\n"; }
	~Resource() { std::cout << "Resource destroyed\n"; }
};

Auto_ptr3<Resource> generateResource()
{
	Auto_ptr3<Resource> res{new Resource};
	return res; // this return value will invoke the copy constructor
}
/**
 * @brief Here the resource acquisation is done 3 times for copy version :
 * 1- At line:69.
 * 2- when genarateResource returns the res object is copy constructed into temp, which acquires a resource.
 * 3- returned res is assigned to mainres using deep copy assignment operator, hence resource is acquired here as well.
 * 
 * For move semantics following happens:
 * 1- Inside generateResource(), local variable res is created and initialized with a dynamically allocated Resource, which causes the first 
 * “Resource acquired”.
 * 2- Res is returned back to main() by value. Res is move constructed into a temporary object, transferring the dynamically created object stored 
 * in res to the temporary object.
 * 3- Res goes out of scope. Because res no longer manages a pointer (it was moved to the temporary), nothing interesting happens here.
 * 4- The temporary object is move assigned to mainres. This transfers the dynamically created object stored in the temporary to mainres.
 * 5- The assignment expression ends, and the temporary object goes out of expression scope and is destroyed. However, because the temporary no 
 * longer manages a pointer (it was moved to mainres), nothing interesting happens here either.
 * 6- At the end of main(), mainres goes out of scope, and our final “Resource destroyed” is displayed.
 * @return int 
 */
int main()
{
	Auto_ptr3<Resource> mainres;
	//In the presence of move contructor and assignment operator, copy versions are ignored.
	mainres = generateResource(); // this assignment will invoke the copy assignment

	return 0;
}