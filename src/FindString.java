public class FindString {
    public static void main(String[] args){
        String havoc="abc";
        String needle="c";
        int a=findStringFind(havoc,needle);
        System.out.println(a);
    }

    private static int findStringFind(String havoc, String needle) {
        int h1=havoc.length();
        int n1=needle.length();
        int i=0;
        if(h1<n1) return -1;
        if(havoc.equals(needle)) return 0;
        for(;i<=h1-n1;i++){
            String temp=havoc.substring(i,i+n1);
            int j=0;
            while(j<needle.length() && havoc.charAt(i+j)==needle.charAt(j)){
                j++;
                if(j==needle.length())
                    return i;
            }
        }
        return -1;
    }

}
