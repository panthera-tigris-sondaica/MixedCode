public class C1_SwapMethods {
    /*    public static <T> void swapAny(AtomicReference<T> x, AtomicReference<T> y) {
            T temp = x.get();
            x.set(y.get());
            y.set(temp);
        }

        public static void main(String[] args) {
            AtomicReference<Integer> x = new AtomicReference<>(66);
            AtomicReference<Integer> y = new AtomicReference<>(99);
            System.out.println("The value of x is : " + x.get() + " The value of y is : " + y.get());
            swapAny(x, y);
            System.out.println("The value of x is : " + x.get() + " The value of y is : " + y.get());
        }*/

        public static void swap(int x, int y){
            int t;
            t=x;
            x=y;
            y=t;
        }

        public static <T> void main(String[] args) {
            String str = "DockLake_zdhflksjdfl";
            //Integer x=new Integer(99);
            //Integer y=new Integer(66);
            int x=99;
            int y=66;
            System.out.println("x="+ x+"y="+y);
            swap(x,y);
            System.out.println("x="+ x+"y="+y);
        }
    }

class Example{
    int x;
    Example(int x){
        this.x=x;
    }
    public static void main(String[] args) {
        Example a = new Example(1);
        Example b = new Example(2);
        System.out.println("A: "+a.x+", B:"+b.x);
        m1(a,b);
        System.out.println("A: "+a.x+", B:"+b.x);
    }

    private static void m1(Example a, Example b) {
        int temp=a.x;
        a.x=b.x;
        b.x=temp;
        System.out.println("A: "+a.x+", B:"+b.x);
    }
}