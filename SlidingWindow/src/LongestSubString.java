public class LongestSubString {
    public static String convert(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int idx = i;
            int southidx = 2*(n - 1 - i);
            int northidx = 2*i;
            boolean goingSouth=true;

            while (idx < s.length()) {
                sb.append(s.charAt(idx));
                if (i == 0) idx += southidx;
                else if (i == n - 1) idx += northidx;
                else{
                    if(goingSouth){
                        idx+=southidx;
                    }
                    else idx+=northidx;

                }
                goingSouth=!goingSouth;

            }
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String str="PAYPALISHIRING";
        int n=4;
        String s=convert(str,n);
        System.out.println(s);

    }
}
