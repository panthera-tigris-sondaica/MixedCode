import java.util.Arrays;

public class ReplaceArray {
    public static void main(String... args) {
        int[] num = {2,1,4,2};
        int res = replaceInPlaceArr(num);
        //for (int i = 0; i < res.length; i++) {
            System.out.println(res);

        //}
    }

    public static int replaceInPlaceArr(int[] heights) {
        int n=heights.length;
        int min=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(heights[i]>max)
                max=heights[i];
            if(heights[i]<min)
                min=heights[i];
        }
        int[] count=new int[max+1];
        Arrays.fill(count,0);
        for(int i=0;i<n;i++){
            count[heights[i]]+=1;
        }
        //perform cumulative sum
        for(int i=1;i<=max;i++){
            count[i]=count[i]+count[i-1];
        }
        //take an output array of size n
        int[] output=new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[heights[i]]-1]=heights[i];
            count[heights[i]]--;
        }
        int k=0;
        for(int i=0;i<heights.length;i++){
            if(heights[i]!=output[i])k++;
        }

        return k;
    }
}


            /*int p=0;
            int q=1;
            while(p<nums.length && q<nums.length){
                if(nums[p]!=0 && nums[q]==0){
                    p++;
                    q++;
                }
                else if(nums[p]==0 && nums[q]==0){
                    q++;
                }

                else if(nums[p]!=nums[q] && nums[p]==0){
                    nums[p]=nums[q];
                    nums[q]=0;
                    p++;
                    q++;
                }
                else if(nums[p]!=0 && nums[q]!=0){
                    p++;
                    q++;
                }



            }*/
