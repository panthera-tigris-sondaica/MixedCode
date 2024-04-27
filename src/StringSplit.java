public class StringSplit {
    public static void main(String[] args){ /*{
        String str="the sky    is blue";
        char[] ch=str.trim().toCharArray();
        callReverse(0,ch.length-1,ch);
        int wordStrart=0;
        int wordEnd=0;
        int i=0;
        while(i<ch.length){
            if(ch[i]==' '){
                wordEnd=i-1;
                callReverse(wordStrart,wordEnd,ch);
                i++;
                while(ch[i]==' ') i++;
                wordStrart=i;
            }
            i++;
        }
       callReverse(wordStrart, wordEnd,ch);
       }*/


    /*public static void callReverse(int from, int end, char[] input){

        while(from<end){
            char c= input[from];
            input[from++]=input[end];
            input[end--]=c;
        }*/

        String s="the sky    is blue";
        String[] str=s.trim().split(" +");
        for(int i=0;i<str.length;i++){
            StringBuilder sbl = new StringBuilder(str[i]);
            str[i]=sbl.reverse().toString();
        }
        String preOut  = String.join(" ", str);
    }


}
