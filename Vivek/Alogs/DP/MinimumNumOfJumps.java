/* 
Given an array of N integers arr[] where each element represents the 
max number of steps that can be made forward from that element. Find 
the minimum number of jumps to reach the end of the array (starting from the first element). 
If an element is 0, then you cannot move through that element.
 */

public class MinimumNumOfJumps {
    
    public static void main(String[] args) {
      
        /* 
        N = 6
        arr = {1, 4, 3, 2, 6, 7}
        Output: 2 
        Explanation: 
        First we jump from the 1st to 2nd element 
        and then jump to the last element.
         */
        int[] ar = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(ar));//2

        /* 
        Input:
        N = 11 
        arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} 
        Output: 3 
        Explanation: 
        First jump from 1st element to 2nd 
        element with value 3. Now, from here 
        we jump to 5th element with value 9, 
        and from here we will jump to the last. 
         */
        int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
        System.out.println(minJumps(arr));//3

        int[] arrr = {1, 0, 3, 2, 6, 7};
        System.out.println(minJumps(arrr));//-1
    }

    static int minJumps(int[] arr){
        int[] minJumpForIndex = new int[arr.length];
        
        //It is starting point so reaching here no steps are required
        minJumpForIndex[0] = 0;
        //for(int i = 1; i < arr.length; i++) { // this logic is being handled in for loop as optimization
        //    minJumpForIndex[i] = -1; 
        //} 
        
        for(int i = 1; i < arr.length; i++) {
            minJumpForIndex[i] = -1;// as optimization from above
            for(int j = 0; j < i; j++) {
                if(j + arr[j] >= i) {
                    int jumpRequiredToReach_i_from_j = minJumpForIndex[j] + 1;
                    if(minJumpForIndex[i] == -1 || jumpRequiredToReach_i_from_j < minJumpForIndex[i]) {
                        minJumpForIndex[i] = jumpRequiredToReach_i_from_j;
                    }
                }
            }
            //if we couldn't come till then we cannot go further
            if(minJumpForIndex[i] == -1) return -1;
        }
        
        return minJumpForIndex[arr.length - 1];
    } 
}
