import java.util.HashMap;

public class BaseConversion {
    static HashMap<Character,Integer> antiCode;
    static final String code ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static{
        antiCode=new HashMap<>();
        for(int i=0; i<code.length(); i++)
            antiCode.put(code.charAt(i),i);
    }
    public static void main(String[] args) {
        int m=12345;
        String str=toBase62(m);
        System.out.println(str);
        System.out.println(getBase10from62("000003D7"));
        System.out.println(getBase10from16("0007F"));
    }
    public static String toBase16(int base10) {
        String ans="";
        int y=16;
        while(base10>=y){
            ans=code.charAt(base10%y)+ans;
            base10/=y;
        }
        return code.charAt(base10)+ans;
    }

    public static String toBase62(int base10) {
        String ans="";
        int y=62;
        while(base10>=y){
            //ans=map.get(base10%y)+ans;
            ans=code.charAt(base10%y)+ans;
            base10/=y;
        }
        //return map.get(base10)+ans;
        return code.charAt(base10)+ans;
    }

    public static int getBase10from62(String input){
        int sum = 0;
        for(int i=0; i<input.length(); i++){
            sum+= antiCode.get(input.charAt(i)) * (int)Math.pow(62,input.length()-1-i);
        }
        return sum;
    }
    public static int getBase10from16(String input){
        int sum = 0;
        for(int i=0; i<input.length(); i++){
            sum+= antiCode.get(input.charAt(i)) * (int)Math.pow(16,input.length()-1-i);
        }
        return sum;
    }
}
