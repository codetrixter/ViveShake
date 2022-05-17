/**
 * @file displayCircularList.cpp
 * @author Abhishek
 * @brief creation and manipulation of circular list.
 * @version 0.1
 * @date 2022-05-17
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

struct Node
{
    int data;
    struct Node *next;
}*first = NULL;

void create(int *A, int size)
{
    struct Node *t, *last;
    first = (struct Node*)malloc(sizeof(struct Node));
    first->data = A[0];
    first->next = first;
    last = first;
    for(int i = 1; i < size; i++)
    {
        t = (struct Node*)malloc(sizeof(struct Node));
        t->data = A[i];
        last->next = t;
        t->next = first;
        last = t;
    }
}

void display(struct Node *start)
{
    struct Node *temp = start;
    while(temp->next != start)
    {
        std::cout << temp->data << " ";
        temp = temp->next;
    }
    if(temp->next = start)
        std::cout << temp->data;
}

struct Node* displayRecursive(struct Node * start)
{
    if(start->next == first)
    {
        std::cout << start->data;
        return start;
    }
    else
    {
        std::cout << start->data << " ";
        return displayRecursive(start->next);
    }
}

int main(int argc, char const *argv[])
{
    int A[] = {10, 30, 2, 50, 1};
    create(A, 5);
    displayRecursive(first);
    return 0;
}
