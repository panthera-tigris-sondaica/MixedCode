public class SpiralMat {
    public static void main(String[] args) {
        int n=5;
        int[][] mat=sprl(n);
        for(int[] m:mat){
            for(int i:m){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static int[][] sprl(int n){
            int topRow=0;int bottomRow=n-1;int leftCol=0;int rightCol=n-1;
            int[][] mat=new int[n][n];
            int total=1;
            while(total<=n*n){
                for(int i=leftCol;i<=rightCol;i++){
                    mat[topRow][i]=total;
                    total++;
                }
                topRow++;
                for(int i=topRow;i<=bottomRow;i++){
                    mat[i][rightCol]=total;
                    total++;
                }
                rightCol--;
                for(int i=rightCol;i>=leftCol;i--){
                    mat[bottomRow][i]=total;
                    total++;
                }
                bottomRow--;
                for(int i=bottomRow;i>=topRow;i--){
                    mat[i][leftCol]=total;
                    total++;
                }
                leftCol++;
            }
            return mat;

        }
    }
