public class Toggle2 {
    private static final char DIFF =  ' '; //ASCII 32

    public static void main(String[] args) {
        String input = "PhYsiCs";
        String output = toggleCase(input);
        System.out.println(input);
        System.out.println(output);
    }

    private static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            sb.append(toggleChar(str.charAt(i)));
        }
        return sb.toString();
    }

    private static char toggleChar(char c) {
        return (char) (isCapital(c)?c+DIFF:c-DIFF);
    }

    private static boolean isCapital(char c){
        return c>='A' && c<='Z';
    }
}
