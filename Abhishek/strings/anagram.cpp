/**
 * @file anagram.cpp
 * @author Abhishek
 * @brief Below program checks if the given two strings are anagram or not.
 * @version 0.1
 * @date 2022-04-21
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#include <iostream>

bool isAnagram(char *s1, char *s2)
{
    int sum1 =0, sum2 = 0;
    bool status = false;
    for(int i = 0; s1[i] != '\0'; i++)
    {
        sum1 += s1[i];
    }

    for(int j = 0; s2[j] != '\0'; j++)
    {
        sum2 += s1[j];
    }

    if(sum1 == sum2)
    {
        status = true;
    }
    
    return status;
}

int main(int argc, char const *argv[])
{
    char str[] = "listen";
    char str2[] = "silent";

    std::cout << isAnagram(str, str2);

    return 0;
}
