package google;

public class IslandPeri {
    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        //System.out.println("grid length"+grid.length);
        IslandPeri i=new IslandPeri();
        int c=i.islandPerimeter(grid);
        System.out.println("value of c "+c);

    }
    int count=0;
    public int islandPerimeter(int[][] grid){
        count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]==1){
                    System.out.println("value of i and j"+i+ " " +j);
                    dfs(grid,i,j);
                    break;
                }

            }
        }
        return count;
    }

    public void dfs(int[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]==0){
            System.out.println("value of i "+i+" value of j "+j);
            //System.out.println(" inside dfs value of count "+count);
            count++;
            return;
        }
        if(grid[i][j]==-1) {
            return;
        }
        grid[i][j]=-1;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
