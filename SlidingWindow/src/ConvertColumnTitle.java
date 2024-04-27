public class ConvertColumnTitle {
    public static void main(String[] args) {
        int d=28;
        String str=convertToTitle(d);
        System.out.println(str);
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb =new StringBuilder();
            while(columnNumber>0){
                int rem=columnNumber%26;
                char c=(char)(rem +'A'-1);
                sb.append(c);
                columnNumber=columnNumber/26;
            }

        return sb.reverse().toString();
    }
}
