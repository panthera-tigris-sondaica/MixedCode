public class Subsequence {
        public static void main(String[] args) {
            String s="abc";
            String t="ahbgdc";
            boolean flag=isSubsequence(s,t);
            System.out.println(flag);
        }
        public static boolean isSubsequence(String s, String t) {
            int l=s.length();
            int m=t.length();
            int i=0;
            int j=0;
            while(i<l && j<m){
                if(s.charAt(i)==t.charAt(j)){
                    i++;
                    j++;
                }
                else j++;
            }
            if(i==l) return true;
            return false;

        }
    }

