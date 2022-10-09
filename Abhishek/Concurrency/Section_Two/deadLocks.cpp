/**
 * @file deadLocks.cpp
 * @author Abhishek
 * @brief Here we discuss about dead locks:
 * 1- In case one the locks are acuired for both account 1 and 2 by both the threadds and then transfer function is waiting for same lock to 
 * to be acquired again.
 * @version 0.1
 * @date 2022-10-09
 *
 * @copyright Copyright (c) 2022
 *
 */
#include <iostream>
#include <mutex>
#include <thread>
#include <string>
#include <chrono>

/*********************************************** example 1 ***********************************/
class bank_account
{
    double balance;
    std::string name;
    std::mutex m;

public:
    bank_account(){};

    bank_account(double _balance, std::string _name) : balance(_balance), name(_name) {}

    bank_account(bank_account &acc) = delete;
    bank_account &operator=(bank_account &acc) = delete;

    void withdraw(double amount)
    {
        std::lock_guard<std::mutex> lg(m);
        balance -= amount;
    }

    void deposite(double amount)
    {
        std::lock_guard<std::mutex> lg(m);
        balance += amount;
    }

    void transfer(bank_account &from, bank_account &to, double amount)
    {
        std::lock_guard<std::mutex> lg_1(from.m);
        std::cout << "lock for " << from.name << " account acquire by " << std::this_thread::get_id() << std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(1000));

        std::cout << "waiting to acquire lock for " << to.name << " account by  " << std::this_thread::get_id() << std::endl;
        // This has already been acquired by the thread_2 function call.
        std::lock_guard<std::mutex> lg_2(to.m);

        from.balance -= amount;
        to.balance += amount;
        std::cout << "transfer to - " << to.name << "   from - " << from.name << "  end \n";
    }
};

void run_code1()
{
    bank_account account;

    bank_account account_1(1000, "james");
    bank_account account_2(2000, "Mathew");

    std::thread thread_1(&bank_account::transfer, &account, std::ref(account_1), std::ref(account_2), 500);
    std::this_thread::sleep_for(std::chrono::milliseconds(100));
    std::thread thread_2(&bank_account::transfer, &account, std::ref(account_2), std::ref(account_1), 200);

    thread_1.join();
    thread_2.join();
}

/*********************************************** example 2 ***********************************/
std::mutex m1;
std::mutex m2;

void m1_first_m2_second()
{
    std::lock_guard<std::mutex> lg1(m1);
    std::this_thread::sleep_for(std::chrono::milliseconds(1000));
    std::cout << "thread " << std::this_thread::get_id() << " has acquired lock for m1 mutex, its wait for m2 \n";
    //This lock has already been acquired by thread_2 call.
    std::lock_guard<std::mutex> lg2(m2);
    std::cout << "thread " << std::this_thread::get_id() << " has acquired lock for m2 mutex \n";
}

void m2_first_m1_second()
{
    std::lock_guard<std::mutex> lg1(m2);
    std::this_thread::sleep_for(std::chrono::milliseconds(1500));
    std::cout << "thread " << std::this_thread::get_id() << " has acquired lock for m2 mutex, its wait for m1 \n";
    //This lock has already been acquired by thread_1 call.
    std::lock_guard<std::mutex> lg2(m1);
    std::cout << "thread " << std::this_thread::get_id() << " has acquired lock for m1 mutex \n";
}

void run_code2()
{
    std::thread thread_1(m1_first_m2_second);
    std::thread thread_2(m2_first_m1_second);

    thread_1.join();
    thread_2.join();
}

int main()
{
    //run_code1();
    //run_code2();
    return 0;
}
