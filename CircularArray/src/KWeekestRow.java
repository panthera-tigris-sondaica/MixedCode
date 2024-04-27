import java.util.*;
import java.util.stream.Collectors;

public class KWeekestRow {
    public static void main(String[] args) {
        int[][] mat={{1,1,0},{1,0,0},{1,0,0},{1,1,1},{1,1,0},{0,0,0}}; //2,1,1,3,2,0
        int k=4;
        print("input matrix",mat);
        int[] r=kWeakestRows3(mat,k);
        print("Result",r);
        //int[] crr=new int[mat.length];
        System.out.println("print arr in main method");

    }

    public static int[] kWeakestRows(int[][] mat, int k) {
//        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
//            int result = a[1]-b[1];
//            if(result==0){
//                result = a[0]-b[0];
//            }
//            return result;
//        });
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) cnt++;
            }
            map.put(i,cnt);
            System.out.println("cnt for Row "+i+" cnt "+cnt);
        }

        List<Integer> list = map.entrySet().stream().sorted((a,b)->{
            int result = a.getValue()-b.getValue();
            if(result==0){
                result = a.getKey() - b.getKey();
            }
            return result;
        }).limit(k).map(i->i.getKey()).collect(Collectors.toList());

        int[] r=new int[k];
        int i=0;
        for(Integer num : list){
            r[i++]=num;
        }

        return r;
    }

    public static int[] kWeakestRows4(int[][] mat, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->{
            int result = a[1]-b[1];
            if(result==0){
                result = a[0]-b[0];
            }
            return result;
        });
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) cnt++;
            }
            q.offer(new int[]{i,cnt});
            System.out.println("cnt for Row "+i+" cnt "+cnt);
        }

        int[] r=new int[k];
        for(int i=0;i<k;i++){
            r[i]=q.poll()[0];
        }

        return r;
    }

    public static int[] kWeakestRows2(int[][] mat, int k) {
        int[][] arr=new int[mat.length][2];
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) cnt++;
            }
            arr[i][0]=i;
            arr[i][1]=cnt;

            System.out.println("cnt for Row "+i+" cnt "+cnt);
        }

        print("Before Sort",arr);
        Arrays.sort(arr, (a,b)->a[1]-b[1]);
        print("After Sort",arr);
        int[] r=new int[k];
        for(int i=0;i<k;i++){
            r[i]=arr[i][0];
        }

        return r;
    }

    public static int[] kWeakestRows3(int[][] mat, int k) {
        int[][] arr=new int[mat.length][2];
        for(int i=0;i<mat.length;i++){
            int cnt=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1) cnt++;
            }
            arr[i][1]=cnt;
            arr[i][0]=i;
            System.out.println("cnt for Row "+i+" cnt "+cnt);
        }

        print("Before Sort",arr);
        for(int i=0;i< arr.length-1;i++){
            for(int j=i+1;j< arr.length;j++)
            {
                if(arr[i][1]>arr[j][1]){
                    int[] temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                else if(arr[i][1]==arr[j][1] && arr[i][0]>arr[j][0]){
                    int[] temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        print("After Sort",arr);
        int[] r=new int[k];
        for(int i=0;i<k;i++){
            r[i]=arr[i][0];
        }

        return r;
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

    private static void print(String msg, int[] arr) {
        System.out.println(msg);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

    }

}
