/**
 * @file functionPointers.cpp
 * @author Abhishek
 * @brief here we look at the syntax and uses of function pointers:
 * 1- The function call makes the program execution jump to a function definition, whenever a 
 * function is called using ().
 * 2- syntax of a function pointer:
 *  --> int (*funptr)() : here, funptr is a function pointer to a function who has a return type of integer and takes
 *      no parameters.
 * 
 * 3- Assigning a function to a function pointer.
 * 4- Calling functions using function pointer.
 * 5- passing functions as argumenst to other functions AKA callback functions.
 * @version 0.1
 * @date 2022-06-18
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>
#include <utility>

//*********point 1***
/* int foo()   //code for foo starts at memory address 0x002717f0
{
    return 5;
}

int main(int argc, char const *argv[])
{
    //the execution pointer jumps to address of foo function i.e 0x002717f0
    std::cout << foo();

    //prints the address of the function foo()
    std::cout << reinterpret_cast<void*>(foo);  
    return 0;
} */
//*********point 1***

//*********point 3 and 4***
/* int foo()
{
    return 5;
}

int goo(int a, int b)
{
    return a+b;
}
int main(int argc, char const *argv[])
{
    int (*funptr1)() {&foo};
    std::cout << (*funptr1)();

    int (*funptr2)(int, int) = &goo;
    std::cout << funptr2(10, 20);
    return 0;
} */
//*********point 3 and 4***

//*********point 5***
/* void swap(int& first, int& second)
{
    int temp = first;
    first = second;
    second = temp;
} */
void selectionSort(int* arr, int size)
{
    for(int  i = 0; i < size-1; i++)
    {
        int smallest = i;
        for(int j = i+1; j < size; j++)
        {
            if(arr[smallest] > arr[j])
                smallest  = j;
        }
        std::swap(arr[i], arr[smallest]);
    }
}

int main(int argc, char const *argv[])
{
    int array[6] = {5, 3, 7, 1, 2, 9};
    selectionSort(array, 6);

    for(int i = 0; i < 6; i++)
    {
        std::cout << array[i];
    }
    return 0;
}

//*********point 5***