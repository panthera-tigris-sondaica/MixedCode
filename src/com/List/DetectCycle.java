package com.List;
class DetectCycle {
   public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

         public static void print(Node b){
             Node a=b;
             while(a!=null){
                 System.out.println(a.val);
                 a=a.next;
             }
         }
         public static Node cycle(Node head){
             Node slow=head;
             Node fast=head;
             while(fast!=null && fast.next!=null){
                  slow=slow.next;
                  fast=fast.next.next;
                  if(slow==fast){
                       System.out.println("found cycle in list");
                       return slow;}
             }
              System.out.println("did not find cycle in the list");
             return null;
         }

         public static Node splitLinkedList(Node head){//3 2 4 1 2 8 10 13 15 17 20 22 19
            Node even =new Node(100);
            Node headeven=even;
            Node curr=head;
            Node t=head;

            while(curr!=null && curr.next!=null){
                    if(curr.val % 2 == 0) {
                        even.next = curr;
                        even = even.next;
                        curr = curr.next;
                    }
                    if (curr != null && curr.val % 2 != 0 && curr == head) curr = curr.next;
                    if (curr!=null && curr.val % 2 != 0 && curr != head) {
                        t.next = curr;
                        t = curr;
                        curr = curr.next;
                    }
                }
            even.next=null;
            t.next=headeven.next;
            //head=t;
            return head;
         }

         public static Node intersectionInList(Node head){
             Node slow=head;
             Node fast=cycle(head);
             if(fast!=null) {
                  while (slow != fast) {
                       slow = slow.next;
                       fast = fast.next;
                  }
                  if(slow==fast)return slow;
             }
             return fast;
         }
         public static Node findTheLink(Node head1,Node head2){
            Node temp1=head1;
            Node temp2=head2;
            int l1=0;
            int l2=0;
            while(temp1!=null){
                temp1=temp1.next;
                l1++;
            }
             while(temp2!=null){
                 temp2=temp2.next;
                 l2++;
             }
             temp1=head1;
             temp2=head2;
             int diff=Math.abs(l1-l2);
             if(l1>l2){
                 for(int i=1;i<=diff;i++){
                     temp1=temp1.next;
                 }
             }
             else{
                 for(int i=1;i<=diff;i++){
                     temp2=temp2.next;
                 }
             }

             while(temp1!=null && temp2!=null){
                 temp1=temp1.next;
                 temp2=temp2.next;
                 if(temp1==temp2)return temp1;
             }

            return null;
         }

        public static void main(String[] args) {
        Node a=new Node(3);
        Node b=new Node(2);
        Node c=new Node(4);
        Node d=new Node(1);
        Node e=new Node(2);
        Node f=new Node(8);
        Node g=new Node(10);
        Node h=new Node(13);
        Node i=new Node(15);
        Node j=new Node(17);
            Node k=new Node(20);
            Node l=new Node(22);
            Node m=new Node(19);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
        h.next=i;
        i.next=j;
        j.next=k;
        k.next=l;
        l.next=m;

        //print(a);
        Node after=splitLinkedList(a);
        print(after);
       /* Node k=cycle(a);
        System.out.println(k.val);
        System.out.println("call intersection method");
        Node l=intersectionInList(a);
        System.out.println(l.val);*/
         //Node k = findTheLink(a,g);
           // System.out.println(k.val);



        }

    }
}
