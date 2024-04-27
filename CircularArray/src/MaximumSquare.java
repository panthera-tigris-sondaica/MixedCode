public class MaximumSquare {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        int size = maximalSquare(matrix);
        System.out.println("Max Sqr: "+size);
    }

    public static int maximalSquare(int[][] a) {
        int maxSize = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if(a[i][j]==1){
                    int localSize=1;
                    while(checkSquare(a,i,j,localSize+1)){
                        localSize++;
                    }
                    if(localSize>maxSize)
                        maxSize=localSize;
                }
            }
        }
        return maxSize;
    }

    private static boolean checkSquare(int[][] a, int k, int l, int r) {
        if(k+r<a.length && l+r<a[0].length){
            System.out.println("k and l r "+k+" "+l+"r="+r);

            for(int i=k; i<k+r; i++){
                if(a[k+r-1][i]==0 || a[i][k+r-1]==0) return false;
            }
//        for(int i=k;i<k+r;i++){
//            for(int j=l;j<l+r;j++){
//                System.out.println(i+" "+j);
//                if(a[j][i]!=1 && (a[i][j]!=1)){
//                    return false;
//                }
//                else continue;
//            }
//        }
            return true;
        }
        else{
            return false;
        }
    }
}