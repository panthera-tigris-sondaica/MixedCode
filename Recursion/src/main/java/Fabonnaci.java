class Fabonnaci {
    public static void main(String[] args) {
        int n = 5;
        //for(int i=0; i<=n; i++){
            System.out.println(recussive(n));
        //}
        //printFibo(0,n,0,1);
    }

    private static void printFibo(int i, int n, int a, int b) {
        if(i!=n) {
            printFibo(i + 1, n, b,a+b);
        }
        System.out.println(i+": "+a);
    }


    // 0 1 1 2 3 5
    // 0 1 2 3 4 5 6
    private static int recussive(int n) {
        if (n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        return recussive(n - 1) + recussive(n - 2);
    }
}