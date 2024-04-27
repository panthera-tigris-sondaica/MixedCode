public class FindDiff {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cadeb";
        char c = findTheDifference(s, t);
        System.out.println(c);
    }

    //    public static char findTheDifference(String s, String t) {
//        char[] ch = s.toCharArray();
//        char[] c = t.toCharArray();
//        char result = 0;
//
//        for (int i = 0; i < ch.length; i++) {
//            result ^= ch[i];
//        }
//
//        for (int i = 0; i < c.length; i++) {
//            result ^= c[i];
//        }
//
//        return result;
//    }
    public static char findTheDifference(String t, String s) {
        char c = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = false;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return s.charAt(i);
            }
        }
        return c;
    }
}
