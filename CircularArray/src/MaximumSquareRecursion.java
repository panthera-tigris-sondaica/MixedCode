public class MaximumSquareRecursion {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int size = maximalSquare(matrix);
        System.out.println("Max Sqr: "+size);
    }
    public static int maximalSquare(int[][] mat){
        int m= mat.length;
        int n=mat[0].length;

        int maxArea=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println("Before recursion call i="+i+" j="+j);
                int curArea=findSquareArea(mat,i,j);
                if(curArea>maxArea)
                    maxArea=curArea;
            }
        }
        return maxArea*maxArea;
    }

    private static int findSquareArea(int[][] mat, int i, int j) {
        System.out.println("After recursion call i ="+i+" j="+j);
        if(i> mat.length-1 || j>mat[0].length-1f || mat[i][j]==0){
            return 0;
        }
        int sum=1+Math.min(
                    findSquareArea(mat,i+1,j+1),
                    Math.min(
                            findSquareArea(mat,i+1,j),
                            findSquareArea(mat,i,j+1)
                    )
            );
        return sum;
    }
}
