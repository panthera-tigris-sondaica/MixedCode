import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindingNearestZeroMine {
    public static void main(String[] args) {
        int[][] input = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };
        print("Input Array:",input);
        int[][] result = new Solution().updateMatrix(input);
        print("Output Array:",result);
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

    //BFS - Scan from Zero Node
    static class Solution{
        public int[][] updateMatrix(int[][] input) {
            int m = input.length;
            int n = input[0].length;
            int[][] result = new int[m][n];

            Queue<int[]> q = new LinkedList<>();

            for(int i=0; i<m; i++) for (int j=0; j<n; j++){
                if(input[i][j]!=0) {
                    result[i][j]=-1;
                }else{
                    q.offer(new int[]{i,j});
                }
            }

            //BFS
            while(!q.isEmpty()){
                int[] cell = q.poll();
                for(int[] nbr : getValidNbrs(cell,result,m,n)){
                    result[nbr[0]][nbr[1]] = result[cell[0]][cell[1]]+1;
                    q.offer(nbr);
                }
            }

            return result;
        }

        private List<int[]> getValidNbrs(int[] cell, int[][] result, int m, int n) {
            List<int[]> l = new ArrayList<>();
            int i=cell[0];
            int j=cell[1];
            if(j-1>=0 && result[i][j-1]==-1) l.add(new int[]{i,j-1});
            if(j+1<n && result[i][j+1]==-1) l.add(new int[]{i,j+1});
            if(i-1>=0 && result[i-1][j]==-1) l.add(new int[]{i-1,j});
            if(i+1<m && result[i+1][j]==-1) l.add(new int[]{i+1,j});
            return l;
        }
    }

    //Brute Force - Naive Approach
    static class Solution1 {
        public int[][] updateMatrix(int[][] input) {
            int m = input.length;
            int n = input[0].length;
            int[][] result = new int[m][n];

            for(int i=0; i<m; i++) for (int j=0; j<n; j++) if(input[i][j]!=0) result[i][j]=-1;
            for(int d=1; d<=m+n-2; d++)
                for(int i=0; i<m; i++) for (int j=0; j<n; j++){
                    if(result[i][j]==-1){
                        if(minNext(i,j,d-1,result,m,n)){
                            result[i][j]=d;
                        }
                    }
                }

            return result;
        }

        private static boolean minNext(int i, int j, int dis, int[][]res, int m, int n){
            return isEqual(res,m,n,i,j-1,dis)
                    || isEqual(res,m,n,i,j+1,dis)
                    || isEqual(res,m,n,i-1,j,dis)
                    || isEqual(res,m,n,i+1,j,dis);
        }

        private static boolean isEqual(int[][] res, int m, int n, int i, int j, int d){
            if(i<0||i>=m) return false;
            if(j<0||j>=n) return false;
            return d == res[i][j];
        }
    }
}
