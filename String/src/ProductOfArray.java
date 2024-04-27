public class ProductOfArray{
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int[] res=productExceptSelf(arr);
    }
    public static int[] productExceptSelf(int[] nums) {
        int prefix =1;
        int result[] = new int[nums.length];
        for(int i=0;i<nums.length;++i) {
            result[i] = prefix;
            prefix = prefix * nums[i];
        }
        prefix = 1;
        for(int i=nums.length-1;i>=0;--i) {
            result[i] = result[i]*prefix;
            prefix = prefix * nums[i];
        }
        return result;
    }

}
