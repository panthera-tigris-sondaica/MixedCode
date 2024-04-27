public class Divisors {
    public static void main(String[] args) {
        int num=2016;
        System.out.println(checkPerfectNumber(num));
    }
    public static boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sum = 1;

        for (int i = 2; i <= Math.sqrt(num); ++i)
            if (num % i == 0){
                System.out.println(num/i);
                sum += i + num / i;}

        return sum == num;
    }
}
