package com.List;

public class LinkedList {
    class Node {
        public int val;
        public Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    int size;

    LinkedList() {
        head = new Node(-1);
        head.next = null;
        size = 0;

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            int counter = 0;
            Node curr = head;
            while (counter != (index)) {
                curr = curr.next;
                counter++;
            }
            return curr.val;
        }
    }

    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head.next;
        head.next = n;
        size++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public void addAtIndex(int index, int val) {
        Node n = new Node(val);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        n.next = cur.next;
        cur.next = n;
    }

    public int deleteNthNodeFromLast(int n) {
        Node fast = head;
        Node slow = head;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        Node m = slow.next;
        slow.next = slow.next.next;
        return m.val;

    }

    public Node reverseList() {
        Node a = head;
        Node temp = head;
        while (temp.next != null && temp.next.next != null) {
            Node tail = temp.next;
            temp.next = temp.next.next;
            tail.next = head;
            head = tail;
        }
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        return head;
    }

    public Node reverseBetween(int left, int right) {
        if (head == null || head.next == null) return head;
        if (left == right) return head;
        Node a = head;
        Node leftr = null;
        Node rightr = null;
        //Node p=null;
        int p = left - 1;
        int count = 0;
        while (a != null) {
            a = a.next;
            count++;
            if (count == left) {
                leftr = a;
            }
            if (count == right)
                rightr = a;

        }
        Node lefti = leftr;
        Node curr = lefti.next;
        Node temp = curr.next;
        while (lefti != rightr) {
            curr.next = lefti;
            lefti = curr;
            curr = temp;
            if (temp != null)
                temp = temp.next;
        }
        leftr.next = curr;
        a = head;
        count = 0;
        while (count != p && a.next != null) {
            a = a.next;
            count++;
        }
        a.next = rightr;
        rightr = head;
        return head;
    }

    public Node reverseTraverse() {
        Node prev = null;
        Node curr = head;
        Node temp = curr.next;
        while (temp != null) {
            curr.next = prev;
            prev = curr;
            curr = temp;
            head = curr;
            temp = temp.next;
        }
        curr.next = prev;
        return head;
    }

    public int pairSum() {
        head=head.next;
        if(head==null || head.next==null) return head.val;
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=reverseTemp(slow.next);
        slow.next=temp;
        Node p1=head;
        int max=Integer.MIN_VALUE;
        while(temp!=null){
            int c=p1.val+temp.val;
            if(c>=max){
                max=c;
            }
            p1=p1.next;
            temp=temp.next;
        }
        return max;
    }
    public static Node reverseTemp(Node n){
        if(n==null || n.next==null) return n;
        Node prev=null;
        Node curr=n;
        Node temp=null;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }

    public void removeDuplicate() {
        Node curr = head;
        Node temp = curr.next;
        if (head == null && head.next == null) return;
        while (temp.next != null) {
            if (curr.val == temp.val) {
                curr.next = temp;
                temp = temp.next;
            }

        }
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public Node delInBetween(int data) {
        Node curr = head;
        Node temp = curr;


        while (temp!= null) {//[1,2,6,3,4,5,6]
            while(head!=null && head.val==data)
                head=head.next;
            if (temp.val != data) {
                curr = temp;


            } else {
                while (temp.next!=null && temp.val == data) {
                    temp = temp.next;
                }
                if(temp.next==null && temp.val==data){
                    curr.next=null;
                    break;
                }
                curr.next = temp;
                curr = temp;

            }
            temp = temp.next;


        }
        return head;
    }
    public Node swap(){
        head=head.next;
        Node curr=head;
        Node temp=curr.next;
        Node prev=null;

        while(curr.next!=null && curr.next.next!=null){
            prev=curr;
            //prev.next=null;
            curr.next=curr.next.next;
            if(curr==head){
                temp.next=head;
                head=temp;
            }
            else
                temp.next=curr;

            curr=curr.next;
            temp=curr.next;
            if(temp!=null)
            prev.next=temp;


        }
        if(curr==head && curr.next!=null && curr.next.next==null) {
            temp.next = head;
            curr.next = null;
            head=temp;
        }
        else if(curr.next!=null && curr.next.next==null) {
            temp.next = curr;
            curr.next = null;
        }
        return head;
    }

    public Node swapNumbers(int k){

        //Node dummy=new Node(0);
        //dummy.next=head;
        Node sp=head;
        Node bp=head;
        Node c;
        int i=1;
        while(i<=k){
            i++;
            sp=sp.next;
        }
        c=sp;
        while(sp!=null){
            sp=sp.next;
            bp=bp.next;
        }
        int t=bp.val;
        bp.val=c.val;
        c.val=t;

        return head.next;
    }



}
class My {
    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        //obj.addAtHead(12);
//        obj.addAtHead(15);
//        obj.addAtHead(14);
//        obj.addAtHead(13);
//        obj.addAtHead(12);
//        obj.addAtHead(11);
//        obj.addAtHead(10);
//        obj.addAtHead(9);
//        obj.addAtHead(7);
//        obj.addAtHead(8);
        obj.addAtHead(4);
       obj.addAtHead(3);
        obj.addAtHead(90);
        obj.addAtHead(100);
        obj.print();
        System.out.println("\ncall swapnumbers method");
//        System.out.println("whats wrong");
        obj.swapNumbers(4);
        obj.print();
        System.out.println("\nend");


    }

}