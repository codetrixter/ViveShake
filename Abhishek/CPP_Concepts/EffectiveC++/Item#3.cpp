/**
 * *Use const whenever posiible.
*/
#include <iostream>

char greeting[] = "Hello";
char *p = greeting;
//non-const pointer, const data
const char *p1 = greeting;
//const poiter, non-const data
char* const p3 = greeting;
//const pointer and data
const char* const p2 = greeting;

int main(int argc, char const *argv[])
{
    
    return 0;
}
