public class ReverseString {
    public static void main(String[] args) {
//        String  str ="this is a sample string";
//        String  rev = str.chars().mapToObj(i->(char)i).reduce("", (a,b) -> b+a, (s,t)->t+s);
//        System.out.println(str);
//        System.out.println(rev);

//        String str = null;
//        System.out.println(str.valueOf(10));
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));
    }
    /*
    public class Test {

    public static void main(String[] args) {
        String s1 = "abc";
        StringBuffer s2 = new StringBuffer(s1);
        System.out.println(s1.equals(s2));
    }
}
     */
}
