public class Factorial {
    public static void main(String[] args) {
        int n = 6;
        int m = findFact(n);
        System.out.println(m);
    }

    private static int findFact(int n) {
        if (n == 0 || n == 1) return n;
        return n * findFact(n - 1);
    }

}
