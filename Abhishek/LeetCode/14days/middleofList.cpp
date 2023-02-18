/**
 * *Given the head of a singly linked list, return the middle node of the linked list.

    If there are two middle nodes, return the second middle node.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

    Example 2:
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    
    Constraints:
    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
*/

#include <bits/stdc++.h>

// ListNode *middleNode(ListNode *head)
// {
//     // using Floyd's cycle find algorithm aka fast and sloww pointer technique
//     ListNode *slow = head, *fast = head;

//     while (slow->next != NULL && fast->next != NULL && fast->next->next != NULL)
//     {
//         slow = slow->next;
//         fast = fast->next->next;
//     }
//     if (fast->next != NULL)
//         return slow->next;
//     return slow;
// }

int main(int argc, char const *argv[])
{

    return 0;
}
