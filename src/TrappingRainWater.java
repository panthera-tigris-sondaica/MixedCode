import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        int m=largestRectangleArea(arr);
        System.out.println("\nsum of all="+m);
        //System.out.print(m);
    }

    public static int largestRectangleArea(int[] heights){
        int left[]= new int[heights.length];
        left[0]=-1;
        for(int i=1; i<heights.length; i++){
            int p= i-1;
            while(p!=-1 && heights[p]>=heights[i]){
                p= left[p];
            }
            left[i]=p;
        }
        int right[]= new int[heights.length];
        right[heights.length-1]= heights.length;
        for(int i= heights.length-2; i>=0; i--){
            int p= i+1;
            while(p!=heights.length && heights[p]>= heights[i]){
                p = right[p];
            }
            right[i]=p;
        }
        int maxarea=0;
        for(int i=0; i<heights.length; i++){
            int area= heights[i]*(right[i]-left[i]-1);
            maxarea= Math.max(area, maxarea);
        }
        return maxarea;

    }
    public static int largestRectangleArea2(int[] heights) {
        int maxArea=0;

        for(int i=0;i<heights.length;i++){

            if(heights[i]==0) continue;
            int width=1;
            int minHeight=heights[i];
            int area1=width*heights[i];
            if(i==heights.length-1 && heights[i]>0){
                maxArea=Math.max(maxArea,minHeight*width);

            }
            //tempArea=heights[i]*width;
            for(int j=i+1;j<heights.length;j++){
                if(heights[j]>0){
                    minHeight=Math.min(minHeight,heights[j]);
                    width++;
                    int tempArea=Math.max(minHeight*width,area1);
                    maxArea=Math.max(tempArea,maxArea);
                }
                else {
                    maxArea=Math.max(area1,maxArea);
                    break;
                }
            }
        }
        return maxArea;

    }
    public static int maxArea(int[] height) {
        int maxA=Integer.MIN_VALUE;
        int l=height.length-1;
        int r=0;
        while(l!=r){
            int t=Math.min(height[l],height[r]);
            t=t*(l-r);
            maxA=Math.max(maxA,t);
            if(height[l]<=height[r]) l--;
            else r++;
        }
        return maxA;
    }
    public static int trap(int[] height) {
        int[] left=new int[height.length];
        int[] right=new int[height.length];
        int leftGrt=height[0];
        int rightGrt=height[height.length-1];
        left[0]=leftGrt;
        right[height.length-1]=rightGrt;
        for(int i=1;i<height.length;i++){
            leftGrt=Math.max(leftGrt,height[i]);
            left[i]=leftGrt;
        }
        System.out.println("Value of left array");
        for(int i=0;i<left.length;i++){
            System.out.print(left[i]+" ");
        }

        for(int i=height.length-2;i>=0;i--){
            rightGrt=Math.max(rightGrt,height[i]);
            right[i]=rightGrt;
        }
        System.out.println("\nValue of right array");
        for(int i=right.length-1;i>=0;i--){
            System.out.print(right[i]+" ");
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            int m=Math.min(left[i],right[i])-height[i];
            sum+=m;
        }
        return sum;
    }
}
