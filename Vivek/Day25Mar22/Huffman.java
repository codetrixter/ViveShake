package Day25Mar22;

import java.util.*;

class HuffmanNode {
	
	int data;
	char c;
	HuffmanNode left;
	HuffmanNode right;
}


class MyComparator implements Comparator<HuffmanNode> {
	public int compare(HuffmanNode x, HuffmanNode y){
		return x.data - y.data;
	}
}


class Huffman {

	
	public static void main(String args []) {
		
		int n = 6;
		char[] charArray = {'a','b','c','d','e','f'};
		int[] charFreq = {5,9,12,13,16,45};
		
		PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());
		
		for(int i = 0; i < n; i++){
			HuffmanNode hn = new HuffmanNode();
			hn.c = charArray[i];
		    hn.data = charFreq[i];
			hn.left = null;
			hn.right = null;
			q.add(hn);
		}
         // create a root node
         HuffmanNode root = null;

        while(q.size() > 1) {
            // first min extract.
            HuffmanNode x = q.poll();
            // first min extract.
            HuffmanNode y = q.poll();

            HuffmanNode hn = new HuffmanNode();
            hn.c = '-';
            hn.data = x.data + y.data;
            hn.left = x;
            hn.right = y;
            
            root = hn;
            q.add(hn);
        }

        printCode(root, "");
	}

    private static void printCode(HuffmanNode node, String code) {

        if(node.left == null && node.right == null && Character.isLetter(node.c)) {
            System.out.println(node.c+": "+code);
            return;
        } 
        printCode(node.left, code+"0");
        printCode(node.right, code+"1");
    }
}