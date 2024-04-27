public class SplitReverse {
    public static void main(String[] args){
        String s="the sky is blue";
            char[] ch=s.toCharArray();
            int wordStart=0,i=0,wordEnd=0;
            while(i<ch.length){
                if(ch[i]==' '){
                    wordEnd=i-1;
                    callReverseFunc(wordStart,wordEnd,ch);
                    if(ch[i+1]!= ' ')
                        wordStart=i+1;
                }
                i++;

            }
            callReverseFunc(wordStart,wordEnd,ch);

        }
    public static void callReverseFunc(int wordStart, int wordEnd, char[] ch) {
        while (wordStart < wordEnd) {
            char temp = ch[wordStart];
            ch[wordStart++] = ch[wordEnd];
            ch[wordEnd--] = temp;
        }

    }
}
