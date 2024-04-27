import java.util.ArrayList;
import java.util.List;

public class KidCandles {
    public static void main(String[] args) {
        int[] arr={2,3,5,1,3};
        int n=3;
        List<Boolean> res=kidsWithCandies(arr,n);
        System.out.println(res);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<candies.length;i++){
            if(candies[i]>=max)
                max=candies[i];
        }
        for(int can:candies){
           res.add(can+extraCandies>=max);

        }

        return res;
    }
}
