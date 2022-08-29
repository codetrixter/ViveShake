/**
 * @file smartPointers.cpp
 * @author Abhishek
 * @brief here we discuss the usefullness of smart pointers:
 * 1- These help prevent memory leaks.
 * @version 0.1
 * @date 2022-08-29
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>

template <typename T>
class Auto_ptr1
{
    T *m_ptr;

public:
    // Pass in a pointer to "own" via the constructor
    Auto_ptr1(T *ptr = nullptr)
        : m_ptr(ptr)
    {
    }

    // The destructor will make sure it gets deallocated
    ~Auto_ptr1()
    {
        delete m_ptr;
    }

    // Overload dereference and operator-> so we can use Auto_ptr1 like m_ptr.
    T &operator*() const { return *m_ptr; }
    T *operator->() const { return m_ptr; }
};

// A sample class to prove the above works
class Resource
{
public:
    Resource() { std::cout << "Resource acquired\n"; }
    ~Resource() { std::cout << "Resource destroyed\n"; }
    void sayHi() { std::cout << "Hi!\n"; }
};

//Here in this function if the Auti_ptr was not smart then the function would have returned after receiving x as 0 and ptr would be left dangling.
void someFunction()
{
    Auto_ptr1<Resource> ptr(new Resource()); // ptr now owns the Resource

    int x;
    std::cout << "Enter an integer: ";
    std::cin >> x;

    if (x == 0)
        return; // the function returns early

    // do stuff with ptr here
    ptr->sayHi();
}   //The destructor of Auto_ptr will be invoked at the end of this function, no matter how this function terminates.

int main()
{
    Auto_ptr1<Resource> res(new Resource()); // Note the allocation of memory here

    // ... but no explicit delete needed

    // Also note that the Resource in angled braces doesn't need a * symbol, since that's supplied by the template
    someFunction();

    return 0;
} // res goes out of scope here, and destroys the allocated Resource for us