/**
 * @file vectorstl.cpp
 * @author Abhishek
 * @brief Exploring vector STL and its functions and properties:
 * 1- Vectors are dnamic arrays that have the ability to resize itself accordingly.
 * 2- Removal from last takes constant time.
 * 3- insertions and deletion from beginning and middle takes linear time.
 * @version 0.1
 * @date 2022-06-08
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <vector>

//***************traversing the vector
/* int main(int argc, char const *argv[])
{
    std::vector<int> lVect;

    for(int i = 0; i < 5; i++)
        lVect.push_back(i);
    
    //begin()->returns an iterator pointing to the first element in the vector.
    //end()->returns an iterator pointing to the theoritical element that follows the last element of the vector.
    std::cout << "\n traversing using begin() and end(): ";
    for(auto i = lVect.begin(); i != lVect.end(); ++i)
        std::cout << *i << " ";
    
    //begin()->returns a reverse iterator pointing to the last element in the vector.
    //end()->returns a reverse iterator pointing to the theoritical element that follows the first element of the vector.
    std::cout << "\n traversing using cbegin() and cend(): ";
    for(auto i = lVect.cbegin(); i != lVect.cend(); ++i)
        std::cout << *i << " ";

    //begin()->returns a constant iterator pointing to the first element in the vector.
    //end()->returns a constant iterator pointing to the theoritical element that follows the last element of the vector.
    std::cout << "\n traversing using rbegin() and rend(): ";
    for(auto i = lVect.rbegin(); i != lVect.rend(); ++i)
        std::cout << *i << " ";

    //begin()->returns a constant iterator pointing to the last element in the vector.
    //end()->returns a constant iterator pointing to the theoritical element that follows the first element of the vector.
    std::cout << "\n traversing using crbegin() and crend(): ";
    for(auto i = lVect.crbegin(); i != lVect.crend(); ++i)
        std::cout << *i << " ";

    return 0;
} */
//***************traversing the vector

//***************exploring capcity functions of vector
int main(int argc, char const *argv[])
{
    std::vector<int> lVect;

    for(int i = 1; i <= 5; i++)
        lVect.push_back(i);

    //returns the number of elements in the vector.
    std::cout << "\n size of the vector is: " << lVect.size();
    //returns the max amount of elements that the vector can hold.
    std::cout << "\n max size of the vector is: " << lVect.max_size();
    //returns the size of the storage space allocated to the vector, expressed as number of elements.
    std::cout << "\n capacity of the vector is: " << lVect.capacity();

    //resizes the vector to size 4.
    lVect.resize(4);
    std::cout << "\n resized vector size is: " << lVect.size();

    //checks if the vector is empty or not.
    if(!lVect.empty())
        std::cout << "\n vector is not empty";
    else
        std::cout << "vector is empty";
    
    //resizes the capacity of the vector to its size and destry all the elements beyond the capacity.
    lVect.shrink_to_fit();
    std::cout << "\n vector elements are: ";
    for(auto it = lVect.begin(); it != lVect.end(); ++it)
        std::cout << *it;
    
    //resize(n)-> it requests the vector capacity to be at least enough to accomodate n elements.
    return 0;
}

//***************exploring capcity functions of vector


