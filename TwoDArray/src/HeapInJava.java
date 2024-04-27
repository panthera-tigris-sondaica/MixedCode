import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapInJava {
    public static void main(String[] args) {
        int[] arr={7,10,4,3,20,15};
        int k=3;
        int ans=findGreater(arr,k);
        System.out.println(ans);
    }

    private static int findGreater(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        int i=0;
        for(;i<arr.length;i++){
            pq.offer(arr[i]);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        return pq.peek();
    }

}
