/* 
Given a linked list, the task is to complete the function maxPalindrome() which returns an
integer denoting  the length of the longest palindrome list that exist in the given linked list.

Input:
The first line of input contains an integer T denoting the number of test cases.
Then T test cases follow. The first line of each test case contains an integer N
denoting the size of the linked list . Then in the next line are N space separated
values of the given linked list.

Output:
For each test case output will be the required max length of the palindrome present
in the given linked list.

User Task:
The task is to complete the function maxPalindrome() which should count the length
of longest palindrome in the given list and return it.

Constraints:
1 <= T <= 100
1 <= N <= 100

Example:
Input:
2
7
2 3 7 3 2 12 24
5
12 4 4 3 14

Output:
5
2

Explanation:
Testcase 1: 2 -> 3 -> 7 -> 3 -> 2 is the linked list whose nodes leads to a palindrome as 2 3 7 3 2.
 
 */

public class LengthOfLongestPolyndromeInLL {
    
    public static void main(String[] args) {
        // 2 3 7 3 2 12 24
        Nod head = new Nod(2);
        head.next = new Nod(3);
        head.next.next = new Nod(7);
        head.next.next.next = new Nod(3);
        head.next.next.next.next = new Nod(2);
        head.next.next.next.next.next = new Nod(12);
        head.next.next.next.next.next.next = new Nod(24);

        System.out.println(maxPalindrome(head));
    }

    /*
     * Time Complexity = O(n^2)
     * Space Complexity = O(1)
     */
    public static int maxPalindrome(Nod head) {

        Nod prev = null;
        Nod curr = head;

        int result = 0;

        while (curr != null) {
            Nod next = curr.next;
            curr.next = prev;

            // odd length polyndrome check
            result = Math.max(result, 2 * checkPolyLength(prev, next) + 1);

            // even length polyndrome check
            result = Math.max(result, 2 * checkPolyLength(curr, next));

            prev = curr;
            curr = next;
        }
        return result;
    }

    private static int checkPolyLength(Nod n1, Nod n2) {
        int count = 0;
        for (; n1 != null && n2 != null; n1 = n1.next, n2 = n2.next) {
            if (n1.data == n2.data) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

class Nod {

    int data;
    Nod next;

    public Nod(int data) {
        this.data = data;
    }
}