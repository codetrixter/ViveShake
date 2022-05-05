public class FarthestFromZero {

    public static void main(String args []) {
        int[] a1 = {1, 3, 5, -2, 1, 4};
        int[] a2 = {-6,1, -5, 3, 5, -2, 1, 4,7};
        System.out.println(farthest(a1));
        System.out.println(farthest(a2));
    }
    
    private static int farthest(int[] arr) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(Math.abs(arr[i]) >= Math.abs(ans)  ) {
                if(Math.abs(arr[i]) > Math.abs(ans))
                    ans = arr[i];
                else if(arr[i] < ans){
                    ans = arr[i];
                }

            }
        }
        return ans;
    }
}
