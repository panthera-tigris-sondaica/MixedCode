public class ArrayPractise {
    public static void main(String... args) {
        //int[][] mat={{1, 2, 3, 4},
        //{5, 6, 7, 8},
        //
        int[] arr = {7, 1, 5, 3, 6, 4};
        int m = profit(arr);
        System.out.println("m= " + m);
//        int[][] mat ={{1,2,3},
//                {4,5,6},{7,8,9}};
////        int[] a=findPeak(nums);
//        //int [][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int[] arr=finddiagonal(mat);
//        for(int n:arr){
//            System.out.print(n+",");
    }




    public static int profit(int[] prices){
        int max=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]<=prices[j]){
                    max=Math.max(max,prices[j]-prices[i]);

                }
                else continue;
            }
        }
        return max;
    }

    private static int[] finddiagonal(int[][] mat) {
        if(mat==null||mat.length==0) return new int[0];
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int i = 0; int j = 0;
        int k = 0; int l=0;
        while (k < res.length) {
            while(j<n-1){
                res[k++]=mat[i][j++];
            }
            while(i<m-1){
                res[k++]=mat[i++][j];
            }
            while(j>l){
                res[k++]=mat[i][j--];
            }
            while(i>l){
                res[k++]=mat[i--][j];
            }
            m--;
            n--;
            i++;
            j++;
            if(i==m && j==n) res[k++]=mat[i][j];
            l++;
        }
        return res;//[1,2,3,4,8,12,11,10,9,5,6,7]

    }
    }

