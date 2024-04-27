
public class ConcatString {
    public static void main(String[] args) {
        int carry=0;
        String a="1011";
        String b="101";
        int length1=a.length()-1;
        int length2=b.length()-1;
        StringBuilder sb=new StringBuilder();
        while(length1>=0 || length2>=0 || carry==1)
        {
            if(length1>=0) carry+=a.charAt(length1--)-'0';
            if(length2>=0) carry+=b.charAt(length2--)-'0';
            sb.append(carry%2);
            carry/=2;
        }
        System.out.println(sb.reverse().toString());
    }
}
