import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        String str="a.b,.";
        System.out.println(reverseVowels(str));
    }
        public static String reverseVowels(String s) {
            char[] arr=s.toCharArray();
            Set<Character> hs=Set.of('a','e','i','o','u','A','E','I','O','U');
            int j=arr.length-1;
            for(int i=0;i<j;){
                if(!hs.contains(arr[j])){j--;}
                else if(!hs.contains(arr[i])){i++;}
                else if(hs.contains(arr[j]) && hs.contains(arr[i])){
                    char temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                    j--;
                }
            }
            return String.valueOf(arr);
        }
    }

