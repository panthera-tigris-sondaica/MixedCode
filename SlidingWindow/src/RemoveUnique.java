import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveUnique {
    public static void main(String[] args) {
        int[] arr={4,3,1,1,3,3,2};
        int k=3;
        int num=findLeastNumOfUniqueInts(arr,k);
        System.out.println(num);
    }
    public  static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n: arr){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        for(int n: map.entrySet().stream().sorted((a, b)-> a.getValue()-b.getValue())
                .map(i->i.getKey()).collect(Collectors.toList())) {
            int freq = map.get(n);
            if (k >= freq) {
                k -= freq;
                map.remove(n);
            } else {
                map.put(n, freq - k);
                break;
            }
        }
        return map.keySet().size();
    }
}