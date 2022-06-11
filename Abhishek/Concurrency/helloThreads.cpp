/**
 * @file helloThreads.cpp
 * @author Abhishek
 * @brief creating and using threads
 * @version 0.1
 * @date 2022-06-11
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <thread>

void task1()
{
    std::cout << "Beauty is only skin deep";
}

int main(int argc, char const *argv[])
{
    std::thread t1(task1);  //thread t1 starts runnning
    //t1.join();      //main thread waits for t1 to finish
    t1.detach();      //t1 will free on its own, meaning main and t1 thread run in parallel -- daemon thread

    //returns true if thread is joinable.
    if(t1.joinable())
        t1.join();

    return 0;
}
