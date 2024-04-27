import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum  {
    public static void main(String[] args) {
        int[] nums={1000000000,1000000000,1000000000,1000000000};
        int tar=-294967296;
        List<List<Integer>> ll=fourSum(nums,tar);
        System.out.println(ll);
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        if (nums.length < 4) return ll;
        Arrays.sort(nums);
        for (int i = 0; i <=nums.length-4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val1 = nums[i];
            int tar=target-val1;
            List<List<Integer>> threeSumList = threeSum(nums, tar, i + 1);
            for (List<Integer> l : threeSumList) {
                l.add(val1);
                ll.add(l);
            }
        }
        return ll;
    }

    public static List<List<Integer>> threeSum(int[] nums,int tar,int k) {
        List<List<Integer>> ll=new ArrayList<>();
        int n=nums.length;
        if(n-k<3) return ll;
        for(int i=k;i+2<nums.length;i++){
            if(i>k && nums[i]==nums[i-1]) continue;
            long ntar=(long)tar-(long)nums[i];
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                if(l<r && nums[l]+nums[r]<ntar) l++;
                else if(l<r && nums[l]+nums[r]>ntar) r--;
                else if(l<r && nums[l]+nums[r]==ntar){
                    List<Integer> group = new ArrayList<>();
                    group.add(nums[i]);
                    group.add(nums[l++]);
                    group.add(nums[r--]);
                    ll.add(group);
                    while(l<r && nums[l]==nums[l-1]) l=l+1;
                    while(l<r && nums[r]==nums[r+1]) r=r-1;
                }
            }

        }
        return ll;
    }
}

