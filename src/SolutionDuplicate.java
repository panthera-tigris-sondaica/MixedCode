import java.sql.SQLOutput;

class SolutionDuplicate {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        int j=0, current=0;
        for(int i=1;i<nums.length;i++){
            current = nums[i];
            j = i-1;
            while(j>=0 && current<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }

            if(j>=0 && current==nums[j]){
                return true;
            }

            nums[j+1] = current;
        }

        return false;
    }
}
