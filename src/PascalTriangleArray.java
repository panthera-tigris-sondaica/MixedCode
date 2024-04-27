public class PascalTriangleArray {
    public static void main(String[] args) {
        int m = 5;
        int[][] mi = callMethodPascal(m);
        for (int i = 0; i < mi.length; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(mi[i][j] + "\t");

            System.out.println();
        }
        System.out.println(mi[3][2]);
    }
    private static int[][] callMethodPascal(int m) {
        int[][] arr =new int[m][0];
        int[] prevRow={1};
        arr[0]=prevRow;
        for(int i=1;i<m;i++){
            arr[i]=new int[i+1];
            arr[i][0]=1;
            for(int j=1;j<i;j++){
                arr[i][j]=prevRow[j-1]+prevRow[j];
            }
            arr[i][arr[i].length-1]=1;
            prevRow=arr[i];
        }
        return arr;
    }


}
