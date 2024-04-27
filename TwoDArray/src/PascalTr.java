import java.util.Scanner;

public class PascalTr {

    public static void printmat(int[][] ans){
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[i].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] trans(int[][] ans,int n) {
        for(int i=0;i<n;i++){
            ans[i]=new int[i+1];
            ans[i][0]=ans[i][i]=1;
            for(int j=1;j<i;j++){
                ans[i][j]=ans[i-1][j]+ans[i-1][j-1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number ");
        int m=sc.nextInt();
        int[][] an=new int[5][];
        int[][] ans=trans(an,m);
        printmat(ans);
    }
}
