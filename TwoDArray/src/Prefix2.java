public class Prefix2 {
    public static void main(String[] args) {
        int[] nums={2,3,7,5,10};
        int[] sums=findPrefix(nums);
        for(int m:sums){
            System.out.print(m+" ");
        }
        System.out.println();
    }

    private static int[] findPrefix(int[] nums) {
        int max=nums[0];
        nums[0]+=max;
        for(int i=1;i<nums.length;i++){
            if(max<nums[i]) {
                max=nums[i];
            }
            nums[i]+= max+nums[i-1];

        }
        return nums;
    }
}
