public class RotateArr {
    public static void main(String... args) {
        int[] nums ={1,2,3,4,5,6};
        int k=4;
        k=k%nums.length;
        if(k<0){
            k=k+nums.length;
        }
        reverseArr(nums,0,nums.length-k-1);
        reverseArr(nums,nums.length-k,nums.length-1);
        reverseArr(nums,0,nums.length-1);
    }
    public static void reverseArr(int[] a, int start, int end){
        while(start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }

    }
}
