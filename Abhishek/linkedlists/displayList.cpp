#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <iomanip>

struct Node
{
    int data;
    struct Node *next;
} *first = NULL;

void create(int A[], int n)
{
    int i;
    struct Node *t, *last;
    first = (struct Node *)malloc(sizeof(struct Node));
    first->data = A[0];
    first->next = NULL;
    last = first;
    for (i = 1; i < n; i++)
    {
        t = (struct Node *)malloc(sizeof(struct Node));
        t->data = A[i];
        t->next = NULL;
        last->next = t;
        last = t;
    }
}

int countNodes(struct Node *p)
{
    int count = 0;
    while(p != NULL)
    {
        count++;
        p = p->next;
    }
    return count;
}

int countNodeRecursive(struct Node *p)
{
    static int count = 0;
    if(p == NULL)
        return count;
    else
        count++;
    return countNodeRecursive(p->next);
}

int sumNodes(struct Node *p)
{
    static int sum = 0;
    while(p != NULL)
    {
        sum += p->data;
        p = p-> next; 
    }
    return sum;
}

int sumNodeRecursive(struct Node *p)
{
    static int sum = 0;
    if(p == NULL)
        return sum;
    sum += p->data;
    return sumNodeRecursive(p->next);
}

bool search(struct Node *p, int element)
{
    bool found = false;
    while(p != NULL)
    {
        if(p->data == element)
            found = true;
        p = p->next;
    }
    return found;
}

bool searchRecursive(struct Node *p, int element)
{
    if(p == NULL)
        return false;
    else if(p->data == element)
        return true;
    return searchRecursive(p->next, element);
}

/**
 * @brief remove duplicates from a sorted list.
 * 
 * @param p 
 */

void removeDuplicatesSorted(struct Node *p)
{
    while(p != NULL)
    {
        if(p->next != NULL && p->data == p->next->data)
        {
            struct Node *temp = p->next;
            p->next = p->next->next;
            free(temp);
        }  
        else    
            p = p->next;
    }
}

void reverse(struct Node *p)
{
    struct Node *temp = NULL, *prevNode = NULL;
    while(p != NULL)
    {
        prevNode = p;
        p = p->next;
        prevNode->next = temp;
        temp = prevNode;
    }
    first = temp;
}

void reverseRecursive(struct Node *prev, struct Node *curr)
{
    static struct Node *temp = NULL, *prevNode = NULL;
    if(curr != NULL)
    {
        reverseRecursive(curr, curr->next);
        curr->next = prev;
    }
    else
        first  = prev;
}

void Display(struct Node *p)
{
    while (p != NULL)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}

void RecursiveDisplay(struct Node *p)
{
    if(p != NULL)
    {
        printf("%d", p->data);
        RecursiveDisplay(p->next);
    }
}

void ReverseDisplay(struct Node *p)
{
    if (p != NULL)
    {
        ReverseDisplay(p->next);
        printf("%d ", p->data);
    }
}

int main()
{
    struct Node *temp;
    int A[] = {10, 20, 20, 20, 30, 30, 40, 50};
    std::cout <<"****create and display linked list**** \n";
    create(A, 8);
    Display(first);
    std::cout << "\n";

    //count iterative and recursive
    // std::cout << countNodes(first);
    // std::cout << countNodeRecursive(first);

    //sum pf all nodes
    // std::cout << sumNodes(first);
    // std::cout << sumNodeRecursive(first);

    //searching in a linked list
    // std::cout << std::boolalpha << search(first, 2);
    // std::cout << std::boolalpha << searchRecursive(first, 32);

    //removiing duplicates from the sorted list.
    // removeDuplicatesSorted(first);
    // Display(first);

    std::cout <<"****reversing a linked list using sliding pointer method**** \n";
    reverseRecursive(NULL, first);
    Display(first);
    std::cout << "\n";
    return 0;
}