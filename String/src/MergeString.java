public class MergeString {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        String str1="priya";
        String str2="Ritvik";
        int n=Math.min(str1.length(),str2.length());
        for(int i=0;i<n;i++){
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        System.out.println(sb);
        sb.append(str1.substring(n)).append(str2.substring(n));
        System.out.println(sb);
    }
}
