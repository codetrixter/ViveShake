public class LastServived {
    

    public static void main(String[] args) {
        System.out.println(josephus(3, 2));
    }
        
   public static int josephus(int n, int k)
   {
       return josephus_solution(n,k)+1;
   }
   
   
   static int josephus_solution(int n, int k)
   {
      if(n==1)
      {
          return 0;
      }
      return (josephus_solution(n-1,k)+k)%n;
   }
   
   
}
