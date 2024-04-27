public class QueueCircularArray {
    //public static class Cqa{
        int f=-1;
        int r=-1;
        int[] arr=new int[6];
        int size=0;
        public void add(int x) throws Exception{
            if(size==arr.length) throw new Exception("Queue is full");
            else if(size==0) {
                f=r=0;
                arr[0]=x;
            }
            else if(r<arr.length-1){
                arr[++r]=x;
            }
            else if(r==arr.length-1){
                r=0;
                arr[0]=x;
            }
            size++;
        }
        public int  remove() throws Exception{
            if(size==0) {throw new Exception("Queue is empty");
            }
            else{
                int val=arr[f];
                if(f==arr.length-1) f=0;
                else f++;
                size--;
                return val;            }
        }
        public int peek() throws Exception {
            if(size==0) {throw new Exception("Queue is empty");
            }
            return arr[f];
        }
        public void display() throws Exception {
            if(size==0) {throw new Exception("Queue is empty");
            }
            else if(f<=r){
            for(int i=f;i<=r;i++) System.out.print(arr[i]+" ");
            }
            else{
                for(int i=f;i<arr.length;i++) System.out.print(arr[i]+" ");
                for(int i=0;i<=r;i++) System.out.print(arr[i]+" ");
            }

           /* System.out.println("display array");
            for(int i=0;i<arr.length;i++){
                System.out.println(arr[i]);
            }*/
        }


    public static void main(String[] args) throws Exception {
        QueueCircularArray c=new QueueCircularArray();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);
        //c.size;
        c.display();
        c.remove();
        System.out.println("after remove");
        c.display();
        c.remove();
        c.add(1);
        c.add(8);
        System.out.println("after remove");
        c.display();




    }

    static {
            //Math.log10()
    }
}
