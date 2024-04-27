public class NumMatrix {
    private int[][] matrix;
    int sum;
    int sum2;
    public NumMatrix(int[][] mat) {
        this.matrix=mat;
        findRowPrefixSumRowWise();
        System.out.println();
        findColWise();
        System.out.println(sumRegion(0,1,0,2));
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if(row1==0 && col1==0)
            return matrix[row2][col2];
        else if(row1>=1 && col1>=1)
            return matrix[row2][col2]-matrix[row2][col1-1]-matrix[row1-1][col2]+matrix[row1-1][col1-1];
        return 0;
    }
    private void findRowPrefixSumRowWise() {
        int r=matrix.length;
        int c= matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        print();
    }

    private void findColWise() {
        int r=matrix.length;
        int c= matrix[0].length;
        for(int i=0;i<c;i++){
            for(int j=1;j<r;j++){
                matrix[j][i]+=matrix[j-1][i];
            }
        }
        print();
    }

    public void print(){
        int r=matrix.length;
        int c= matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //int[][] mat={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        int[][] mat={{8,-4,5},{-1,4,4},{-2,3,1},{-4,4,3}};//,[0,1,0,2],[1,1,1,2],[0,1,0,2]}};
        //int[][] mat={{-4,-5}};
        NumMatrix obj=new NumMatrix(mat);
        /*obj.findRowPrefixSumRowWise();
        System.out.println();
        obj.findColWise();*/
    }
}
