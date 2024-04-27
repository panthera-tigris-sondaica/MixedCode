import java.util.HashSet;
import java.util.Set;

public class UgluNum {
    public static void main(String[] args) {
        long n = 7;
        boolean flag = isUgly(n);
        System.out.println(flag);
    }

    public static boolean isUgly(long n) {
            if (n == 0)
                return false;

            for (final int prime : new int[] {2, 3, 5})
                while (n % prime == 0)
                    n /= prime;

            return n==1;
        }
//    public static boolean isPrime(long num){
//        if(num==2) return true;
//        for(long i=2;i<=Math.sqrt(num);i++){
//            if(num%i==0) return false;
//        }
//        return true;
//    }
}
