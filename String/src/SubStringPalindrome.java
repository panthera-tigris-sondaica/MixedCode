public class SubStringPalindrome {
    public static boolean subStringPalindrom(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
        i++;
        j--;}
        return true;
    }
    public static void main2(String[] args) {
        String str="abcba";
        int count=0;
        for(int i=0;i<str.length();i++){

            for(int j=i+1;j<=str.length();j++){
                if(subStringPalindrom(str.substring(i,j))){
                count++;}
            }

        }
        System.out.println("value of count   "+count);
    }

    public static void main(String[] args) {
        String input = null;
        System.out.println(input+"\n"+getCompressed(input));
    }

    static String getCompressed(String str){
        StringBuilder output = new StringBuilder();
        char oldChar = str.charAt(0);
        int count=1;
        for(int i=1; i<str.length(); i++){
            char newChar = str.charAt(i);
            if(oldChar==newChar){
                count++;
            }else{
                output.append(oldChar).append(count);
                oldChar = newChar; //reset
                count=1; //reset
            }
        }
        output.append(oldChar).append(count);
        return output.toString();
    }
}
