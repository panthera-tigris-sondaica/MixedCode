public class MultMat {
    public static void main(String[] args) {
        int[][] arr1={{1,2,1},{3,1,2}};
        int[][] arr2={{2,1},{1,3},{1,1}};
        int r1=arr1.length;
        int c1=arr2[0].length;
        int[][] arr3 = newMul(arr1,arr2,r1,c1);
        printArray(arr3);
    }
    public static int[][] newMul(int[][] arr1,int[][] arr2, int r1, int c1){
        int[][] arr3=new int[r1][c1];
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr2[i].length;j++)
            {
                arr3[i][j] = getValue(arr1,arr2,i,j);

            }
        }
        return arr3;
    }

    private static int getValue(int[][] arr1, int[][] arr2, int i, int j) {
        int sum = 0;
        for(int k=0;k< arr2.length;k++){
            sum +=arr1[i][k]*arr2[k][j];
        }
        return sum;
    }

    public static void printArray(int[][] arr3){
        for(int i=0;i<arr3.length;i++)
        {
            for(int j=0;j<arr3[i].length;j++)
            {
                System.out.print(arr3[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
