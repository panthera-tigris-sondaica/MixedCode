public class Dividend {
    public static void main(String[] args) {
        int dividend=-2147483648;
        int divisor=1;
        int s=divi(dividend,divisor);
        System.out.println(s);
    }

    private static int divi(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
            long sign=0;
            if((dividend>0 && divisor<0) || (dividend<0 && divisor>0))sign=-1;
            long divd=Math.abs((long)dividend);
            long divs=Math.abs((long)divisor);
            long quo=0;
            while(divd>=divs){
                divd-=divs;
                quo++;
            }
            if(sign==-1)
                quo=-quo;

            return Math.toIntExact(quo);

        }

}
