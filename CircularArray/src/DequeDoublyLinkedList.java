public class DequeDoublyLinkedList {
    Node head;
    Node tail;
    int size;
    static class Node{
        Node prev;
        Node next;
        int val;
        Node(int val){
            this.val=val;
            this.prev=null;
            this.next=null;
        }
    }
    public void addFirst(int val){
        head=addNode(val);
    }

    private Node addNode(int val){
        Node temp=new Node(val);
        if(head==null){
            head=temp;
            tail=head;
        }
        temp.next=head;
        head.prev=temp;
        tail.next=temp;
        temp.prev=tail;
        return temp;
    }

    public void addLast(int val){
        tail=addNode(val);
    }
    public int removeFirst(){
        if(head==null) return 0;
        Node temp=head;
        if(head==tail){
            head=tail=null;
        }else {
            tail.next = head.next;
            head.next.prev = tail;
            head = head.next;
            temp.next=null;
            temp.prev=null;
        }
        return temp.val;
    }

    public int removeLast(){
        if(tail==null) return 0;
        Node temp=tail;
        if(head==tail){
            head=tail=null;}
        else{
            head.prev=tail.prev;
            tail.prev.next=head;
            tail=tail.prev;}

        return temp.val;
    }

    public void display(){
        if(head==null){
            return;
        }
        Node temp=head;
        do{
            System.out.print(temp.val+"->");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    public static void main(String[] args) {
        DequeDoublyLinkedList d=new DequeDoublyLinkedList();
        d.addFirst(1);
//        d.addFirst(2);
//        d.addFirst(3);
//        d.addFirst(4);
//        d.addFirst(5);
        d.display();
//        System.out.println("adding in last");
//        d.addLast(9);
//        d.display();
//        System.out.println("check in head's prev ");
//        System.out.println(d.head.prev.val);
//        System.out.println(d.head.next.val);
//        System.out.println("remove first calling");
        //d.removeFirst();
//        d.display();
//        System.out.println("remove from last");
       d.removeLast();
       System.out.println("removed last element");
        d.display();
    }

}
