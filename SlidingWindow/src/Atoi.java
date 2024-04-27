public class Atoi {
    public static void main(String[] args) {
        String s="+1";
        System.out.println(myAtoi(s));
    }
        public static int myAtoi(String s) {
            s=s.trim();
            if(s.length()==0) return 0;
            boolean neg=false;
            long ans =0;
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(i==0){
                    if(c=='-') {
                        neg=true;
                        continue;
                    }
                    if(c=='+') {
                        neg=false;
                        continue;
                    }
                }
                if(c>='0' && c<='9'){
                    int dig=c-'0';
                    ans=ans*10+dig;
                }
                else {
                    break;
                }
                if(neg){
                    long check=-ans;
                    if(check<Integer.MIN_VALUE)
                        return Integer.MIN_VALUE;
                }
                else{
                    if(ans>Integer.MAX_VALUE)
                        return Integer.MAX_VALUE;
                }


            }
            if(neg)
                ans=-ans;
            return (int)ans;
        }
    }

