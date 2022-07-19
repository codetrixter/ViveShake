import java.util.*;

public class CountRightMinElements {
    
    List<Pair> a = new ArrayList<>();
    int[] ans;

    public static void main(String[] args) {
        int [] arr = {12, 1, 2, 3, 0, 11, 4};
        int n = 7;
        int[] result = new CountRightMinElements().constructLowerArray(arr, n);
        for(int a : result)
        System.out.print(a+" ");
    }
 

     int[] constructLowerArray(int[] arr, int n) {
	    ans = new int[n];
	    for(int i=0;i<n;i++){
	        a.add(new Pair(arr[i],i));
	    }
	    mergesort(0,n-1);
	    return ans;
	}
    
    void merge(int l,int mid,int r){
        int i=l,j=mid+1;
        int cnt=0;
        List<Pair> temp = new ArrayList<>();
        while(i<=mid && j<=r){
            if(a.get(i).first>a.get(j).first){
                cnt++;
                temp.add(a.get(j++));
            }else{
                ans[a.get(i).second]+=cnt;
                temp.add(a.get(i++));
            }
        }
        while(i<=mid){
            ans[a.get(i).second]+=cnt;
            temp.add(a.get(i++));
        }
        while(j<=r){
            temp.add(a.get(j++));
        }
        int idx=0;
        for(int x=l;x<=r;x++){
            a.set(x, temp.get(idx++));
        }
    }
    
    void mergesort(int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergesort(l,mid);
            mergesort(mid+1,r);
            merge(l,mid,r);
        }
    }
}

class Pair {
    int first, second;
    public Pair(int a, int b) {
        first = a;
        second = b;
    }
}