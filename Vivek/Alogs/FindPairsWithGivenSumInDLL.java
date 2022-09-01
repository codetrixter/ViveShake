import java.util.*;

import javax.sound.midi.Soundbank;

/* 
Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.

 

Example 1:

Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
Output: (1, 6), (2,5)
Explanation: We can see that there are two pairs 
(1, 6) and (2,5) with sum 7.
 

Example 2:

Input: 
1 <-> 5 <-> 6
target = 6
Output: (1,5)
Explanation: We can see that there is one pairs  (1, 5) with sum 6.

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findPairsWithGivenSum() which takes head node of the doubly linked list and an integer target as input parameter and returns an array of pairs. If there is no such pair return empty array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
Constraints:
1 <= N <= 105
1 <= target <= 105
 */

public class FindPairsWithGivenSumInDLL {

    public static void main(String[] args) {
        Node1 head = new Node1(1);
        Node1 node1 = head.next = new Node1(2);
        node1.prev = head;
        Node1 node4 = node1.next = new Node1(4);
        node4.prev = node1;
        Node1 node5 = node4.next = new Node1(5);
        node5.prev = node4;
        Node1 node6 = node5.next = new Node1(6);
        node6.prev = node5;
        Node1 node8 = node6.next = new Node1(8);
        node8.prev = node6;
        Node1 node9 = node8.next = new Node1(9);
        node9.prev = node8;
        new FindPairsWithGivenSumInDLL().findPairsWithGivenSum(7, head).forEach(i -> {
            System.out.println(i);
        });

    }

    public ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node1 head) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Node1 start = head;
        Node1 end = head;
        while (end.next != null) {
            end = end.next;
        }

        while (end != null && start != null && end != start) {
            if (start.data + end.data == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(start.data);
                list.add(end.data);
                res.add(list);
                end = end.prev;
                start = start.next;
            } else if (start.data + end.data > target) {
                end = end.prev;
            } else {
                start = start.next;
            }
            if (end.next == start)
                break;
        }
        return res;
    }
}

class Node1 {
    int data;
    Node1 next, prev;

    Node1(int x) {
        data = x;
        next = null;
        prev = null;
    }
}
