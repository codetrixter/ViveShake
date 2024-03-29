/**
 * @file updatedThreadSafeStack.cpp
 * @author Abhishek
 * @brief Here we updated the threadSafe stack implementation to avoid race conditions inherit through interface:
 * 1- one way to solve race conditions inherit from interface, is to combine top and pop functionalities which can be seen below.
 * @version 0.1
 * @date 2022-10-09
 * 
 * @copyright Copyright (c) 2022
 * 
 */
#pragma once
#include <iostream>
#include <mutex>
#include <stack>
#include <thread>
#include <memory>
#include <stdexcept>

template<typename T>
class thread_safe_stack {
	std::stack<std::shared_ptr<T>> stk;
	std::mutex m;

public:
	void push(T element)
	{
		std::lock_guard<std::mutex> lg(m);
		stk.push(std::make_shared<T>(element));
	}

    // Here we have combined top and pop functionalities 
	std::shared_ptr<T> pop()
	{
		std::lock_guard<std::mutex> lg(m);
		if (stk.empty())
		{
			throw std::runtime_error("stack is empty");
		}

		std::shared_ptr<T> res(stk.top());
		stk.pop();
		return res;
	}

    //Another version (call by value)
	void pop(T& value)
	{
		std::lock_guard<std::mutex> lg(m);
		if (stk.empty()) throw std::runtime_error("stack is empty");
		value = *(stk.top().get());
		stk.pop();
	}


	bool empty()
	{
		std::lock_guard<std::mutex> lg(m);
		return stk.empty();
	}

	size_t size()
	{
		std::lock_guard<std::mutex> lg(m);
		return stk.size();
	}
};
