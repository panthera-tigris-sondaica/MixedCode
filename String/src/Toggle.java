public class Toggle {
    public static void main(String[] args) {
        String str="PhysiCS";
        char[] sb=str.toCharArray();
        for(int i=0;i< sb.length;i++){
            if(sb[i]>='A' && sb[i]<='Z'){
                System.out.print(sb[i]+" -"+"> ");
                sb[i]= (char) (sb[i]+(char)32);
                System.out.println(sb[i]);}
            else if(sb[i]>='a' && sb[i]<='z'){
                System.out.print(sb[i]+" -"+"> ");
                sb[i]= (char) (sb[i]-(char)32);
                System.out.println(sb[i]);}
        }

        System.out.println(str);
        str=String.valueOf(sb);
       /* for(int i=0;i<sb.length;i++)
            str+=sb[i];*/
        System.out.println(str);


    }
}
