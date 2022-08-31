import java.util.*;
public class FindAlldistinctSubsetSums {
    
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        for(int i : new FindAlldistinctSubsetSums().DistinctSum(nums)) {
            System.out.print(" "+i);
        }
    }

    public int[] DistinctSum(int[] nums)
    {
        // Code here
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            Set<Integer> setTemp = new HashSet<>();
            
            for(Integer num : set) {
                setTemp.add(num);//adding origin num 0, 1
                setTemp.add(num + nums[i]);//adding new num in set
            }
            setTemp.add(nums[i]);
            set = setTemp;
        }
        int n = set.size();
        int k = 0;
        int arr[] = new int[n];
        for(int num : set) {
            arr[k++] = num;
        }
        
        Arrays.sort(arr);
        return arr;
    }
}
