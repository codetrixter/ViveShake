/**
 * @file BinaryTreeADT.cpp
 * @author Abhishek
 * @brief Here we will try to create a Binry Tree implementation and perform various operations on it.
 * @version 0.1
 * @date 2022-06-18
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <queue>

struct Node
{
    struct Node* lchild;
    int data;
    struct Node* rchild; 
}*root = NULL;

void createBT()
{
    struct Node* temp;
    std::queue<struct Node*> add;
    int value;

    //take the root of the binary tree from the command line.
    std::cout << "Enter the root Node : " ;
    std::cin >> value;
    root = (struct Node*)malloc(sizeof(struct Node));
    root->data = value;
    root->lchild = root->rchild = NULL;
    add.push(root);

    while(!add.empty())
    {
        struct Node* ptr = add.front();
        add.pop();
        if(ptr->lchild == NULL)
        {
            //take the left or right child of the tree from the command line.
            std::cout << "Enter left child of : " << ptr->data;
            std::cin >> value;
            if(value != -1)
            {
                temp = (struct Node*)malloc(sizeof(struct Node));
                temp->data = value;
                temp->lchild = temp->rchild = NULL;
                ptr->lchild = temp;
                add.push(temp);
            }
        }
        if(ptr->rchild == NULL)
        {
            //take the left or right child of the tree from the command line.
            std::cout << "Enter right child of : " << ptr->data;
            std::cin >> value;
            if(value != -1)
            {
                temp = (struct Node*)malloc(sizeof(struct Node));
                temp->data = value;
                temp->lchild = temp->rchild = NULL;
                ptr->rchild = temp;
                add.push(temp);
            }
        }
    }
}

void preOrderTraversal(struct Node* node)
{
    if(node)
    {
        std::cout << node->data << " ";
        preOrderTraversal(node->lchild);
        preOrderTraversal(node->rchild);
    }
}

int main(int argc, char const *argv[])
{
    //creates a Binary Tree by taking node informations as command line arguments.
    createBT();
    //prints the data of Binary Tree using preOrder traversal technique.
    preOrderTraversal(root);

    return 0;
}
