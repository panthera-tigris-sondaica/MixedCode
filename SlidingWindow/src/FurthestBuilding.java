import java.util.PriorityQueue;

public class FurthestBuilding {
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestMost(heights,bricks,ladders));

    }
    public static int furthestMost(int[] h,int b,int l){
        int mb=0;
        int len=h.length;
        for(int i=0;i<len-1;i++){
            if(h[i+1]>h[i]){
                mb=mb+h[i+1]-h[i];
            }
        }
        if(b>=mb) return len-1;

        PriorityQueue<Integer> pq=new PriorityQueue<>((i1,i2)->{return i2-i1;});
        for(int i=0;i<len;i++) {
            if (h[i] >= h[i + 1]) continue;
            if (l == 0 && b == 0) return i;
            else {
                if (l>0 && h[i + 1] > h[i]) {
                    pq.offer(h[i + 1] - h[i]);
                    l--;

                }
                else if (!pq.isEmpty() && pq.peek()<(h[i+1]-h[i])) {
                    pq.offer(h[i+1]-h[i]);
                    b = b - pq.poll();
                } else {
                    b=b-(h[i+1]-h[i]);
                }
                if (b < 0) return i ;
            }
        }
        return len-1;
    }
}
