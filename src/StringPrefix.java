import java.util.Arrays;

public class StringPrefix {
    public static void main(String... args){
        String[] str={"flower","fz","flight"};
      /*  Arrays.sort(str);
        for(String s: str){
            System.out.println(s);
        }*/
        System.out.println(findPrefix(str));
    }

    private static String findPrefix(String[] strs) {
        if (strs.length == 0 ) return "";
        String prefix = strs[0];
        for(int index=1;index<strs.length;index++){
            while(strs[index].indexOf(prefix) != 0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}
