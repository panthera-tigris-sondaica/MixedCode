public class UberSol {
    public static void main(String[] args) {
        Node n = getNode();
        Node ptr = n;
        flatten(n);
        System.out.println("Flatten Done");

        //print
        ptr = n;
        while(ptr!=null){
            System.out.print(ptr.val+" -> ");
            ptr = ptr.right;
        }
        System.out.println("NULL");
    }

    private static Node getNode(){
        /*10->9->>7->6->NULL
        |         |
        v         13
        5->11->12
        */
        Node n = new Node(10);
        n.down = new Node(5);
        n.down.right = new Node (11);
        n.down.right.right = new Node(12);
        n.right = new Node(9);
        n.right.right = new Node(7);
        n.right.right.down = new Node(13);
        n.right.right.right = new Node(6);
        return n;
    }

    /*
        10->9->8->7->6->NULL
        |         |
        v         13
        5->11->12

        first call :
            n = 10->null
            temp = 9
            second call :
                n = 10 -> 5
                n.down = null
                whjile:
                    n = 12
            12->9
    */

    private static Node flatten(Node n){
        if(n.right!=null && n.down!=null){
            Node temp = n.right;
            n.right = null;
            Node tail = flatten(n);
            tail.right = temp;
            n = tail;
        }else if(n.down!=null){
            n.right = n.down;
            n.down = null;
        }
        while(n.right!=null){
            n=n.right;
            if(n.down!=null){
                Node temp = n.right;
                n.right = null;
                Node tail = flatten(n);
                tail.right = temp;
                n = tail; //till tail we are already flatten
            }
        }
        return n;
    }
}
class Node{
    int val;
    Node right;
    Node down;

    Node(int val){
        this.val = val;
    }
}
/*
temp = 10->next (which is 9)
tail = flatten(10) -> it should return tail of flatten
10>5>4>3>9
10->next= 5
tail.next = temp

class LL{
    int value;
    LL next;
    LL down;
}

10->9->8->7->6->NULL
|         |
v         13
5->11->12
|
v
4
|
v
3
|
v
NULL

10 > 5 > 4 > 3 > 11 > 12 > 9 > 8 > 7 > 13> 6 > null
     |
n = node 10
temp = node 9
//if down node then only call flatten method
flatten(Node n){ //it return tail element
    if(n is havign right and down both pointer not null){
        temp = n.next
        n.next = null;
        flatten(n).next = temp
    }else if(only down node){
        n.next = n.down;
        n.down = null;
        repeat these steps for all down nodes
    }
    get tail of node n
    return tail
}
*/