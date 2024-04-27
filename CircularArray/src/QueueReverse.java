import java.util.Stack;

public class QueueReverse {
    public static void main(String[] args) throws Exception {
        QueueCircularArray q=new QueueCircularArray();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.display();
        stackUsingReverseQueue(q);
    }

    private static void stackUsingReverseQueue(QueueCircularArray q) throws Exception {
        System.out.println("Queue Reverse method");
        Stack<Integer> st=new Stack();
        //System.out.println("size of q"+q.size);
        do{
            System.out.println("stack added "+st.push(q.remove())+" ");
            System.out.println("Queue after removal"+q.size);
            q.display();
        }while(q.size>1);



    }

}
