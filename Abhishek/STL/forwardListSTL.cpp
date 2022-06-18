/**
 * @file forwardListSTL.cpp
 * @author Abhishek
 * @brief Here we explore forward list and all its members:
 * 1- assign() function is overloaded to achieve multiple functionalities.
 * @version 0.1
 * @date 2022-06-16
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <forward_list>

//*****************assign()***
/* int main(int argc, char const *argv[])
{
    std::forward_list<int> fList1;
    std::forward_list<int> fList2;
    std::forward_list<int> fList3;

    //storing random elements
    fList1.assign({1, 2, 3});

    //storing repeatable elements
    fList2.assign(5, 10);

    //assignment via another list
    fList3.assign(fList1.begin(), fList1.end());

    for(auto i: fList1)
        std::cout << i << " ";
    std::cout << std::endl;

    for(auto i: fList2)
        std::cout << i << " ";
    std::cout << std::endl;

    for(auto i: fList3)
        std::cout << i << " ";
    std::cout << std::endl;

    return 0;
} */
//*****************assign()***

//*****************push_front(), emplace_front() and pop_frot()***
int main(int argc, char const *argv[])
{
    std::forward_list<int> fList {1, 2, 3, 4, 5, 6};

    std::cout << "The list initialized: ";
    for(auto i: fList)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    //pushing the element to the stsr of the list
    fList.push_front(60);
    std::cout << "The list after push_front: ";
    for(auto i: fList)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    //puhses element to the front of the lsit without copy.
    fList.emplace_front(70);
    std::cout << "The list afteremplace_front: ";
    for(auto i: fList)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;

    //deletes first element of the list.
    fList.pop_front();
    std::cout << "The list after pop_front: ";
    for(auto i: fList)
    {
        std::cout << i << " ";
    }
    std::cout << std::endl;
    return 0;
}

//*****************push_front(), emplace_front() and pop_frot()***