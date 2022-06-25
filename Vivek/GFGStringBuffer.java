public class GFGStringBuffer {
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("GeeksforGeeks");
        // Getting the length of the string
        int p = s.length();
        // Getting the capacity of the string
        int q = s.capacity();
        // Printing the length and capacity of
        // above generated input string on console
        System.out.println("Length of string GeeksforGeeks="
                           + p);
        System.out.println(
            "Capacity of string GeeksforGeeks=" + q);
        
        // Java Program to Illustrate StringBuffer class
        // via replace() method
        s = new StringBuffer("GeeksforGeeks");
        s.replace(5, 8, "are");
        // Returns GeeksareGeeks
        System.out.println(s);


        s = new StringBuffer("GeeksforGeeks");
 
        s.delete(0, 5);
        // Returns forGeeks
        System.out.println(s);
        s.deleteCharAt(7);
        // Returns forGeek
        System.out.println(s);


        s = new StringBuffer("GeeksGeeks");
        // Invoking reverse() method
        s.reverse();
        // Returns "skeeGrofskeeG"
        System.out.println(s);

        // Creating an object of StringBuffer class
        s = new StringBuffer("GeeksGeeks");
        // Inserting element and position as an arguments
        s.insert(5, "for");
        // Returns GeeksforGeeks
        System.out.println(s);
        s.insert(0, 5);
        // Returns 5GeeksforGeeks
        System.out.println(s);
        s.insert(3, true);
        // Returns 5GetrueeksforGeeks
        System.out.println(s);
        s.insert(5, 41.35d);
        // Returns 5Getr41.35ueeksforGeeks
        System.out.println(s);
        s.insert(8, 41.35f);
        // Returns 5Getr41.41.3535ueeksforGeeks
        System.out.println(s);
        // Declaring and initializing character array
        char geeks_arr[] = { 'p', 'a', 'w', 'a', 'n' };
        // Inserting character array at offset 9
        s.insert(2, geeks_arr);
        // Returns 5Gpawanetr41.41.3535ueeksforGeeks
        System.out.println(s);


        s = new StringBuffer("Geeksfor");
        // Usage of append() method
        s.append("Geeks");
        // Returns GeeksforGeeks
        System.out.println(s);
        s.append(1);
        // Returns GeeksforGeeks1
        System.out.println(s);
    }
}
