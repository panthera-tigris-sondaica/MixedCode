import java.util.LinkedList;
import java.util.List;

public class RemoveConsecutiveArray {
    public static void main(String[] args) {
        int[] arr={1,2,2,3,10,10,10,4,4,4,5,7,7,2};
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(arr[0]);

        boolean flag=false;
       for(int i=1;i< arr.length;i++){
           if(arr[i]==ll.peekLast()){
               flag=true;
           }
           else{
               if(flag){
                   ll.removeLast();
                   flag=false;
               }
               ll.addLast(arr[i]);
           }
       }
        System.out.println(ll);

    }
}
