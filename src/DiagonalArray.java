import java.util.ArrayList;
import java.util.List;
public class DiagonalArray {

    public static void main(String... args){
        int [][] mat={{7,2},{9,3},{6,5
        }};
        List<Integer>arr=finddiagonal(mat);
        for(int n:arr){
            System.out.print(" "+n+" ");
        }
    }

    private static List<Integer> finddiagonal(int[][] mat) {
        if(mat==null||mat[0].length==0) return List.of();
        if(mat.length==1) {
            List<Integer> l=new ArrayList<>();
            for(int n:mat[0])
                l.add(n);
            return l;
        }
        int m = mat.length;
        int n = mat[0].length;

        List<Integer> res = new ArrayList<>(m*n);
        int i = 0; int j = 0;
        int k = m*n; int l=0;
        while (res.size()<k) {
            if(i==m-1 && j==n-1) res.add(mat[i][j]);
            while(j<n-1 && res.size()<k){
                res.add(mat[i][j++]);
                System.out.println(res);
            }
            while(i<m-1 && res.size()<k){
                res.add(mat[i++][j]);
                System.out.println(res);
            }
            while(j>l && res.size()<k){
                res.add(mat[i][j--]);
                System.out.println(res);
            }
            while(i>l && res.size()<k){
                res.add(mat[i--][j]);
                System.out.println(res);
            }
            m--;
            n--;
            i++;
            j++;
            l++;
           // min++;
        }
        System.out.println(res);
        return res;
    }

}
