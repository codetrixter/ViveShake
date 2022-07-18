public class MinimumNumOfJumps {
    
    public static void main(String[] args) {

        int[] ar = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(ar));//2

        int [] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ;
        System.out.println(minJumps(arr));//3

        int[] arrr = {1, 0, 3, 2, 6, 7};
        System.out.println(minJumps(arrr));//-1
    }

    static int minJumps(int[] arr){
        // your code here
        int[] minJumpForIndex = new int[arr.length];
        
        //It is starting point so reaching here no steps are required
        minJumpForIndex[0] = 0;
        //for(int i = 1; i < arr.length; i++) { // this logic is being handled in for loop as optimization
        //    minJumpForIndex[i] = -1; 
        //} 
        
        for(int i = 1; i < arr.length; i++) {
            minJumpForIndex[i] = -1;
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
