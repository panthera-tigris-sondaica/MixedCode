public class MaxZero {
    public static void main(String[] args) {
        int[] arr={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;
        System.out.println(longestOnes(arr,k));
    }
        public static int longestOnes(int[] nums, int k) {
            int i=0;
            int j=0;
            while(j<nums.length){
                if(nums[j]==0){
                    k--;
                }
                if(k<0){
                    if(nums[i]==0)
                        k++;
                    i++;
                }
                j++;
            }
            return j-i;
        }
    }

