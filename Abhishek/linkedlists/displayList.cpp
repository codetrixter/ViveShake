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
    int A[] = {3, 5, 7, 10, 25, 8, 32, 2};
    create(A, 8);
    Display(first);

    //count iterative and recursive
    // std::cout << countNodes(first);
    // std::cout << countNodeRecursive(first);

    //sum pf all nodes
    // std::cout << sumNodes(first);
    // std::cout << sumNodeRecursive(first);

    //searching in a linked list
    std::cout << std::boolalpha << search(first, 2);
    std::cout << std::boolalpha << searchRecursive(first, 32);

    return 0;
}