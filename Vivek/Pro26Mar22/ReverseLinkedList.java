package Pro26Mar22;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

//Output:
// 1 2 3 4 5 
// Reversed list:
// 5 4 3 2 1
public class ReverseLinkedList {
    public static void main(String args []) {
        ListNode head = new ListNode(1);
        ListNode secNode = head.next = new ListNode(2);
        ListNode thirListNode = secNode.next = new ListNode(3);
        ListNode fourListNode = thirListNode.next = new ListNode(4);
        fourListNode.next = new ListNode(5);//fifth node

        //printing list
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }

        head = reverseList(head);
        System.out.println("\nReversed list:");
        //printing reversed list
        temp = head;
        while(temp != null) {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }

    //logic: reverse list
    private static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
