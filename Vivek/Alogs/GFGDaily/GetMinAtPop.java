import java.util.*;;
/* 

Now, we'll try to solve a famous stack problem.
You are given an array A of size N. You need to first push the elements 
of the array into a stack and then print minimum in the stack at each pop.


Input:
N = 5
A = {1 2 3 4 5}
Output: 
1 1 1 1 1
Explanation: 
After pushing elements to the stack, 
the stack will be "top -> 5, 4, 3, 2, 1". 
Now, start popping elements from the stack
popping 5: min in the stack is 1.popped 5
popping 4: min in the stack is 1. popped 4
popping 3: min in the stack is 1. popped 3
popping 2: min in the stack is 1. popped 2
popping 1: min in the stack is 1. popped 1

Input: 
N = 7
A = {1 6 43 1 2 0 5}
Output: 
0 0 1 1 1 1 1
Explanation: 
After pushing the elements to the stack, 
the stack will be 5->0->2->1->43->6->1. 
Now, poping the elements from the stack:
popping 5: min in the stack is 0. popped 5
popping 0: min in the stack is 0. popped 0
popping 2: min in the stack is 1. popped 2
popping 1: min in the stack is 1. popped 1
popping 43: min in the stack is 1. 
            popped 43
popping 6: min in the stack is 1. popped 6
popping 1: min in the stack is 1. popped 1.

 */

public class GetMinAtPop {

    static TreeMap<Integer, Integer> treeMap;
    static Stack<Integer> stack;

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = 5;

        _push(arr, n);
        _getMinAtPop(stack);
        System.out.println();
        int[] arr2 = { 1, 6, 43, 1, 2, 0, 5 };
        int n2 = 7;

        _push(arr2, n2);
        _getMinAtPop(stack);

        /*
         * Output:
         * 1 1 1 1 1 //for first input
         * 0 0 1 1 1 1 1 //for second input
         */
    }

    // Function to push all the elements into the stack.
    public static Stack<Integer> _push(int arr[], int n) {
        stack = new Stack<>();
        treeMap = new TreeMap();
        // your code here
        for (int i = 0; i < n; i++) {
            stack.push(arr[i]);
            if (treeMap.containsKey(arr[i])) {
                treeMap.put(arr[i], treeMap.get(arr[i]) + 1);
            } else {
                treeMap.put(arr[i], 1);
            }
        }
        return stack;
    }

    // Function to print minimum value in stack each time while popping.
    static void _getMinAtPop(Stack<Integer> s) {
        // your code here
        int n = s.size();
        for (int i = 0; i < n; i++) {
            int num = stack.pop();
            int min = treeMap.firstKey();
            System.out.print(min + " ");
            if (num == min) {
                if (treeMap.get(num) == 1) {
                    treeMap.remove(num);
                } else {
                    treeMap.put(num, treeMap.get(num) - 1);
                }
            } else {
                if (treeMap.get(num) > 1) {
                    treeMap.put(num, treeMap.get(num) - 1);
                } else {
                    treeMap.remove(num);
                }

            }
        }

    }
}
