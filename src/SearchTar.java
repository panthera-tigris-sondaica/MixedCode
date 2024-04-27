public class SearchTar {
    public static void main(String[] args) {
        int[] nums={1,3,7,9,11,12,45};
        int g=45;
        int s=search(nums,g);
        System.out.println(s);
    }
        public static int search(int []nums, int target) {
            int n=nums.length-1;
            int s=0;
            int e=n-1;
            while(s<=e){
                int mid=(s+e)/2;
                if(nums[mid]==target){
                    return mid;
                }
                else if(nums[mid]>target){
                    e=mid-1;
                }
                else{
                    s=mid+1;
                }
                System.out.println("hi");
            }

            return -1;
        }
    }

