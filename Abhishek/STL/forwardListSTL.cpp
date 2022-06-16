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
int main(int argc, char const *argv[])
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
}
//*****************assign()***