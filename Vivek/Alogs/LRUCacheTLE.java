import java.util.*;

/* 
 
Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 


 */

public class LRUCacheTLE {

    private DoublyLL dl;

    public LRUCacheTLE(int capacity) {
        dl = new DoublyLL(capacity);
    }

    public static void main(String[] args) {
        // 86 10 G 3 G 7 S 11 9 S 4 7 S 3 11 S 1 2 G 1 G 5 S 4 15 S 10 14 S 13 13 G 8 G
        // 7 S 7 5 S 4 12 G 5 S 3 2 G 2 S 8 7 S 1 8 S 4 14 S 7 11 S 9 15 S 13 2 S 8 5 S
        // 8 3 G 3 S 11 2 S 2 7 S 14 3 S 8 9 G 1 G 6 G 9 G 2 G 1 G 3 S 14 2 S 11 1 S 8
        // 13 G 9 G 10 G 11 G 9 G 9 G 12 G 5 G 4 G 5 S 15 12 S 8 14 S 5 8 G 2 G 2 S 6 3
        // G 12 G 11 S 5 13 S 14 15 S 7 6 G 2 G 11 G 8 G 15 S 2 12 S 14 6 S 3 10 S 5 3 S
        // 1 2 S 15 5 G 8 G 12 G 1 G 15 S 8 5 G 5 S 5 5 G 8 S 8 9 S 12 7 S 5 8 G 1 G 3 G
        // 7 G 7 S 2 12
        // Ans: -1 -1 2 -1 -1 -1 -1 -1 2 8 -1 15 7 8 2 15 -1 1 15 15 -1 -1 14 -1 7 7 -1 1 7 1 14 12 14 -1 2 5 3 5 2 10 6 6
        LRUCacheTLE obj = new LRUCacheTLE(10);
        String[] operations = { "G", "3", "G", "7", "S", "11", "9", "S", "4", "7", "S", "3", "11",
                "S", "1", "2", "G", "1", "G", "5", "S",
                "4", "15", "S", "10", "14", "S", "13", "13", "G", "8", "G", "7", "S", "7", "5", "S", "4", "12",
                "G", "5", "S", "3", "2", "G", "2", "S", "8", "7", "S", "1", "8", "S", "4", "14", "S", "7",
                "11", "S", "9", "15", "S", "13", "2", "S", "8", "5", "S", "8", "3", "G",
                "3", "S", "11", "2", "S", "2", "7", "S", "14", "3", "S", "8", "9", "G", "1", "G", "6", "G",
                "9", "G", "2", "G", "1", "G", "3", "S", "14", "2", "S", "11", "1", "S", "8", "13", "G", "9",
                "G", "10", "G", "11", "G", "9", "G", "9", "G", "12", "G", "5", "G", "4", "G", "5", "S", "15",
                "12", "S", "8", "14", "S", "5", "8", "G", "2", "G", "2", "S", "6", "3", "G", "12", "G", "11",
                "S", "5", "13", "S", "14", "15", "S", "7", "6", "G", "2", "G", "11", "G", "8", "G", "15", "S",
                "2", "12", "S", "14", "6", "S", "3", "10", "S", "5", "3", "S", "1", "2", "S", "15", "5", "G",
                "8", "G", "12", "G", "1", "G", "15", "S", "8", "5", "G", "5", "S", "5", "5", "G", "8", "S", "8",
                "9", "S", "12", "7", "S", "5", "8", "G", "1", "G", "3", "G", "7", "G", "7", "S", "2", "12" };

        int i = 0;
        int count = 1;
        while (i < operations.length) {
            String lit = operations[i++];
            if (lit == "G") {
                System.out.print(obj.get(Integer.parseInt(operations[i++])) + " ");
            } else {
                obj.set(Integer.parseInt(operations[i++]), Integer.parseInt(operations[i++]));
            }
            System.out.println("count========================= " + count++);
        }
    }

    public int get(int key) {
        return dl.get(key);
    }

    public void set(int key, int value) {
        System.out.println(dl);
        dl.set(key, value);
    }
}

class DoublyLL {
    private Node head;
    private Node tail;
    int size = 0;
    int capacity;
    Map<Integer, Integer> map;

    public DoublyLL(int cap) {
        capacity = cap;
        map = new HashMap<>();
    }

    public int get(int key) {
        System.out.println("G (" + key + ")");
        if (map.containsKey(key)) {
            set(key, map.get(key));
            return map.get(key);

        }
        return -1;
    }

    public void set(int key, int value) {
        System.out.println();
        System.out.println("S (" + key + ", " + value + ")");
        System.out.println();
        if (map.containsKey(key)) {// data is alread there in the list
            // find the data and bring it to top
            map.put(key, value);
            if (size == 1)
                return;
            Node node = find(key);
            if (node == null)
                return;
            if (node == head)
                return;// no need to update
            if (node == tail) {
                node.prev.next = null;
                tail = node.prev;
                node.prev = null;
                node.next = head;
                head.prev = node;
                head = node;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        } else {
            map.put(key, value);
            if (size < capacity) {
                add(key);
            } else {
                removeLast();
                add(key);
            }
        }
        System.out.println("list size()  " + size);
    }

    private Node find(int data) {
        for (Node temp = head; temp != null; temp = temp.next) {
            if (temp.data == data) {
                return temp;
            }
        }
        return null;
    }

    // This logic is for set which adds data
    // in starting position as per LRU
    public void add(int data) {
        if (size == 0) {
            head = tail = new Node(data, null, null);
        } else {
            head.prev = new Node(data, head, null);
            head = head.prev;
        }
        size++;
    }

    private void removeLast() {
        int key;
        // System.out.println("--------------- "+tail.data);
        if (size == 1) {
            key = head.data;
            head = tail = null;
        } else {
            key = tail.data;
            Node temp = tail;
            tail = temp.prev;
            temp.prev = null;
            tail.next = null;
        }
        map.remove(key);
        size--;
    }

    public String toString() {
        Node temp = head;
        Node temp2 = tail;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb.append("head(" + head + ")[ ");
        while (temp != null) {
            sb.append(temp + "->");
            temp = temp.next;
        }
        while (temp2 != null) {
            sb2.append(temp2 + "->");
            temp2 = temp2.prev;
        }
        sb.append("null");
        sb2.append(">");
        sb.append(" ] tail(" + tail + ")");
        return sb.toString() + " : " + sb2.toString();
    }

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        public String toString() {
            return "" + data;
        }
    }

}
