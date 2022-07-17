public class overloading {
    
    static void print(int a)
    {
        System.out.println(a);
    }
    static void print(double d)
    {}
    public static void main(String[] args) {
     
        print(5L);
        print(2.5);
    }
}
