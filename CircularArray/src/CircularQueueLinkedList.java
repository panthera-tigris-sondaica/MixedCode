import java.util.LinkedList;

public class CircularQueueLinkedList {
    static class Qa {
        Node head;
        Node tail;

        int maxsize;
        int curSize;

        public Qa(int size){
            this.maxsize=size;
            this.curSize=0;
        }

        public static class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;

            }
        }

        public void add(int val) {
            if(curSize>maxsize) {
                return;
            }
            Node n = new Node(val);
            if (head==null){
                head=tail=n;
                tail.next=head;
            }
            else{
                tail.next=n;
                tail=n;
                tail.next=head;
            }

            curSize++;
        }
        public Node remove(){
            if(head==null) {
                System.out.println("List is Empty");
                return null;
            }
            else{
                Node temp=head;
                head=head.next;
                tail.next=head;
                temp.next=null;
                curSize--;
                return temp;
            }

        }

        public void display(){
            if(head==null){
                System.out.println("List is Empty");
            }
            else{
                Node temp=head;
                System.out.println("CurrentSize"+curSize);
                do{
                    System.out.print(temp.val+"->");
                    temp=temp.next;
                }while(temp!=head);
                //System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Qa n=new Qa(6);
        n.add(2);
        n.add(3);
        n.add(2);
        n.add(2);
        n.add(5);
        n.add(6);
        n.add(7);
        n.remove();
        n.remove();


        n.display();

    }
}
