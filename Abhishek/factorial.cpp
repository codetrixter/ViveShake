#include <iostream>

int factorial(int num)
{
    if(num == 0)
    {
        return 1;
    }
    else
    {
        return num*factorial(num-1);
    }
}

int main(int argc, char const *argv[])
{
    std::cout << factorial(6);
    return 0;
}
