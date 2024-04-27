import java.util.*;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] arr={1,-2,3,5,-4,-6,8,9,-1,-8,7,-3};
        int k=3;
        int[] s=findFirst(arr,k);
        for(int c:s)
        System.out.print(c+" ");
    }

    private static int[] findFirst(int[] arr,int k) {
        int[] s=new int[arr.length-k+1];
        HashMap<Integer,Integer> hs=new LinkedHashMap<>();
        for(int r=0,i=0,l=0;r<arr.length;r++){
            if(arr[r]<0) hs.put(r,arr[r]);
            if(r-l+1==k){
                if(hs.size()>0){
                    s[i++]=hs.entrySet().iterator().next().getValue();
                }
                else{
                    i++;
                }
                if(hs.containsKey(l)) hs.remove(l);
                l++;
                //Queue
            }
        }
        return s;
    }

}
