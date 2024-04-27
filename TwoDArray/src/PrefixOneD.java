import javax.swing.*;

public class PrefixOneD {
    public static void print(int[] nums){
        for(int i:nums)
            System.out.print(i+" ");
    }
    public static void main(String[] args) {
        int[] nums={-2, 0, 3, -5, 2, -1};
        PrefixOneD ob=new PrefixOneD(nums);
        ob.print(nums);
        System.out.println("sumRange");
        System.out.println(ob.sumRange(2,5));
    }
        int[] nums;
        public PrefixOneD(int[] nums) {
            this.nums=nums;
            for(int i=1;i<nums.length;i++){
                nums[i]+=nums[i-1];
            }
        }

        public int sumRange(int left, int right) {
            if(left!=0)
            return nums[right]-nums[left];
            else return nums[right];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

