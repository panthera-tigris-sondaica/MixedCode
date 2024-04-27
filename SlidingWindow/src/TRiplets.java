import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TRiplets {
    public static void main(String[] args) {
        int[] nums={-2,-1,-1,1,1,2,2};
        int tar=0;
        List<List<Integer>> ll=threeSum(nums,tar);
        System.out.println(ll);
    }
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> ll=new ArrayList<>();
        int n=nums.length;
        if(n<4) return new ArrayList<>();
        Arrays.sort(nums);
        for(int k=0;k+3<nums.length;k++){
            if(k>0 && nums[k]==nums[k-1]) continue;
            int ktar=target-nums[k];
            for(int i=k+1;i+2<nums.length;i++){
                if(i>1 && nums[i]==nums[i-1]) continue;
                int ntar=ktar-nums[i];
                int l=i+1;
                int r=nums.length-1;
                while(l<r && nums[r]+nums[r-1]>=ntar){
                    if(l<r && nums[l]+nums[r]<ntar) l++;
                    else if(l<r && nums[l]+nums[r]>ntar) r--;
                    else if(l<r && nums[l]+nums[r]==ntar){
                        ll.add(Arrays.asList(nums[k],nums[i],nums[l++],nums[r--]));
                        while(l<r && nums[l]==nums[l-1]) l=l+1;
                        while(l<r && nums[r]==nums[r+1]) r=r-1;
                    }
                }

            }

        }
        return ll;
    }
}
