import java.util.*;

public class FindingNearZero {
    public static void main(String[] args) {
        int[][] input = {
                {0,1,1,1},
                {1,1,0,1},
                {0,1,1,1},
                {1,1,1,1}
        };
        print("Input Array:",input);
        int[][] result = updateMatrix(input);
        print("Output Array:",result);
    }

    private static int[][] updateMatrix(int[][] input) {
        int m= input.length;
        int n=input[0].length;
        int[][] result=new int[m][n];
        Queue<Cell> q=new LinkedList<>();
        Set<Cell> nonProcessed = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(input[i][j]==0){
                    q.offer(new Cell(i,j));
                }
                else{
                    result[i][j]=-1;
                    nonProcessed.add(new Cell(i,j));
                }
            }
        }
        while(q.size()>0 && nonProcessed.size()>0){
            Cell c=q.poll();
            List<Cell> ll=findNextAdjacentCell(c.i,c.j,result,m,n);
            for(Cell a:ll){
                result[a.i][a.j]=1+result[c.i][c.j];
                q.offer(a);
                nonProcessed.remove(a);
            }

        }
        return result;
    }

    static class Cell{
        int i, j;
        public Cell(int i,int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cell cell = (Cell) o;
            return i == cell.i && j == cell.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    private static List<Cell> findNextAdjacentCell(int i, int j,int[][] result,int m,int n) {
        List<Cell> l=new LinkedList<>();

        //i-1,j
        if((i-1>=0) && result[i-1][j]==-1) l.add(new Cell(i-1,j));
        //i+1,j
        if(i+1<m && result[i+1][j]==-1) l.add(new Cell(i+1,j));
        //i,j-1
        if(j-1>=0 && result[i][j-1]==-1) l.add(new Cell(i,j-1));
        //i,j+1
        if(j+1<n && result[i][j+1]==-1) l.add(new Cell(i,j+1));

        return l;
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
