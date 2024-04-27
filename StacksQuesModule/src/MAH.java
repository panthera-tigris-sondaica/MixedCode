public class MAH {
    public static int maximalRectangle(int[][] matrix) {
        int[] temp=new int[matrix[0].length];
        int AreaMax=-1;
        for(int i=0;i< matrix[0].length;i++){
            temp[i]=matrix[0][i];

        }
        int area=largestRectangleArea(temp);
        AreaMax=Math.max(AreaMax,area);
        //System.out.println(AreaMax);

        //print(temp);
        for(int i=1;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0) temp[j]=0;
                else temp[j]=temp[j]+1;
            }

            //print(temp);
            area=largestRectangleArea(temp);
            AreaMax=Math.max(AreaMax,area);

        }
        System.out.println(AreaMax);

        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix={{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        maximalRectangle(matrix);
    }
    public static int largestRectangleArea(int[] heights) {
        int[] nse=new int[heights.length];
        int[] pse=new int[heights.length];
        nse[heights.length-1]=heights.length;
        for(int i=heights.length-2;i>=0;i--){
            int p=i+1;
            while(p!=heights.length && heights[p]>=heights[i]){
                p=nse[p];
            }
            nse[i]=p;
        }
        pse[0]=-1;
        for(int i=1;i<heights.length;i++){
            int p=i-1;
            while(p!=-1 && heights[p]>=heights[i]){
                p=pse[p];
            }
            pse[i]=p;
        }
        int maxArea=-1;
        for(int i=0;i<heights.length;i++){
            int Area=heights[i]*(nse[i]-pse[i]-1);
            maxArea=Math.max(Area,maxArea);
        }
        return maxArea;
    }
}
