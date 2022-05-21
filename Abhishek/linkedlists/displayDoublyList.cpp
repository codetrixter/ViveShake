/**
 * @file displayCircularList.cpp
 * @author Abhishek
 * @brief creation and manipulation of doubly list.
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
    struct Node *prev;
} *first = NULL;

void create(int *A, int size)
{
    struct Node *t, *last;
    first = (struct Node *)malloc(sizeof(struct Node));
    first->data = A[0];
    first->next = NULL;
    first->prev = NULL;
    last = first;
    for (int i = 1; i < size; i++)
    {
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = NULL;
        t->prev = last;
        last->next = t;
        last = t;
    }
}

void display(struct Node *start)
{
    struct Node *temp = start;
    while (temp != NULL)
    {
        std::cout << temp->data << " ";
        temp = temp->next;
    }

    std::cout << "\n";
}

void insertAtMid(struct Node *start, int element)
{
    struct Node *it = start;
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->data = element;
    while(it != NULL)
    {
        if(it->data == element)
        {
            newNode->prev = it->prev;
            newNode->next = it;
            it->prev->next = newNode; 
            it->prev = newNode;
            break;
        }
    }
}

void displayReverse(struct Node *start)
{
    struct Node *temp = start;
    while (temp->next != NULL)
    {
        temp = temp->next;
    }

    while(temp != NULL)
    {
        std::cout << temp->data << " ";
        temp = temp->prev;
    }
}

int main(int argc, char const *argv[])
{
    int A[] = {10, 30, 2, 50, 1};
    create(A, 5);
    display(first);
    //displayReverse(first);

    //insert at middle
    insertAtMid(first, 2);
    display(first);
    return 0;
}
