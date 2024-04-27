public class FindDiagonal {
    public static void main(String[] args) {
        int[][] arr1 = {{1,5,9},{10,11,13},{12,13,15}};
        int k=8;
        int arr = kthSmallest(arr1,k);

            System.out.print(arr);
    }
    public static boolean isPrime(int arr){

            boolean flag = true;
            int x = (int) (Math.sqrt(arr));
            if(arr%2==0)flag=false;
            else for (int j = 3; j <= x; j+=2) {
                if (arr% j == 0) {
                    flag = false;
                    break;
                }
            }
      return flag;
    }
    public static int diagonalPrime(int[][] nums) {
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            boolean flag=isPrime(nums[i][i]);
            if (flag)
                max = Math.max(nums[i][i],max);
        }

        for (int i = 0; i < nums.length; i++) {
            boolean flag=isPrime(nums[i][nums.length-i-1]);
            if (flag)
                max = Math.max(nums[i][nums.length-i-1],max);
        }

        return max;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0) return 0;
        int m=k/matrix.length;
        int l=k%matrix.length;
        return matrix[m][l-1];

    }


}

