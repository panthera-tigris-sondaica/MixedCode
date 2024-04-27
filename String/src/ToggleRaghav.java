import java.util.stream.Stream;

public class ToggleRaghav {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("PriyaSinghChauhan");
//
//        System.out.println(sb);
//        for(int i=0;i<sb.length();i++){
//            char t=sb.charAt(i);
//            sb.setCharAt(i,(char)(t>=97?t-32:t+32));
//        }
//        System.out.println(sb);


        String str = "PriyaSinghChauhan";
        System.out.println(str);
        str.chars().map(t->t>=97?t-32:t+32).forEach(t->System.out.print((char)t));
    }
}
