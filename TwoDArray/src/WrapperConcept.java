import java.net.StandardSocketOptions;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class WrapperConcept {
    public static void main(String[] args) {

        Queue<Integer> q=new LinkedList<>(); //1->5->4->1->2
        q.add(1);
        q.add(5);
        q.add(4);
        q.add(1);
        q.add(2);
        //System.out.println(q);
        Queue<Integer> h=new ArrayDeque<>();
        while(q.size()>0){
            System.out.println(q.peek());
            h.add(q.poll());
            //q.poll();
        }
        System.out.println(q.size());
    }
}
