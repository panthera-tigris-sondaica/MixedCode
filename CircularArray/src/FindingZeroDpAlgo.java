public class FindingZeroDpAlgo {
    public static void main(String[] args) {
        int[][] input =
                //{
//                {0,1,1,1},
//                {1,1,0,1},
//                {0,1,1,1},
//                {1,1,1,1}
//        };
        {{1,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,1,1,1},{1,1,1,0,0,1,1,1,1,0},{0,1,1,1,0,1,1,1,1,1},{0,0,1,1,1,1,1,1,1,0},{1,1,1,1,1,1,0,1,1,1},{0,1,1,1,1,1,1,0,0,1},{1,1,1,1,1,0,0,1,1,1},{0,1,0,1,1,0,1,1,1,1},{1,1,1,0,1,0,1,1,1,1}};
        print("Input Array:",input);
        int[][] result = updateDpMatrix(input);
        print("Output Array:",result);
        int[][] expected = {{2,1,0,0,1,0,0,1,1,0},{1,0,0,1,0,1,1,2,2,1},{1,1,1,0,0,1,2,2,1,0},{0,1,2,1,0,1,2,3,2,1},{0,0,1,2,1,2,1,2,1,0},{1,1,2,3,2,1,0,1,1,1},{0,1,2,3,2,1,1,0,0,1},{1,2,1,2,1,0,0,1,1,2},{0,1,0,1,1,0,1,2,2,3},{1,2,1,0,1,0,1,2,3,4}};
        print("Expected Array", expected);
    }

    private static int[][] updateDpMatrix(int[][] input) {
        int m=input.length;
        int n=input[0].length;
        int[][] result = new int[m][n];
        result[0][0] = input[0][0]==0?0:m+n;

        //first row using right
        for(int j=1; j<n; j++){ //row 0
            if(input[0][j]==0) result[0][j]=0;
            else result[0][j] = result[0][j-1]+1;
        }
        //first column using down
        for(int i=1; i<m; i++){ //col 0
            if(input[i][0]==0) result[i][0]=0;
            else result[i][0] = result[i-1][0]+1;
        }

        //every row towards right
        for(int i=1; i<m; i++) for(int j=1; j<n; j++){
            if(input[i][j]==0) result[i][j]=0;
            else result[i][j] = result[i][j-1]+1;
        }

        //every column towards down
        for(int i=1; i<m; i++) for(int j=1; j<n; j++){
            result[i][j] = Math.min(result[i][j],result[i-1][j]+1);
        }

        //for last row towards left
        for(int j=n-2; j>=0; j--){
            result[m-1][j] = Math.min(result[m-1][j],result[m-1][j+1]+1);
        }

        //for last column towards up
        for(int i=m-2; i>=0; i--){
            result[i][n-1] = Math.min(result[i][n-1],1+result[i+1][n-1]);
        }

        //every row towards left
        for(int i=m-2; i>=0; i--) for(int j=n-2; j>=0; j--){
            result[i][j] = Math.min(result[i][j],1+result[i][j+1]);
        }

        //every column towards up
        for(int i=m-2; i>=0; i--) for(int j=n-2; j>=0; j--){
            result[i][j] = Math.min(result[i][j],1+result[i+1][j]);
        }

        return result;
    }

    private static void print(String msg, int[][] arr){
        System.out.println(msg);
        for(int i=0; i<arr.length; i++){
            for (int j=0; j< arr[0].length; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
