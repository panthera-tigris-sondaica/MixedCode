import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        String str=minWindow(s,t);
        System.out.println(str);
    }
    public static String minWindow(String s, String t) {
            int tLength = t.length(), sLength = s.length();
            if (tLength > sLength) {
                return "";
            }
            int[] charCount = new int[128]; // account for upper and lowercase
            for (char c : t.toCharArray()) {
                charCount[c]++;
            }

            int count = tLength;
            int leftPointer = 0, rightPointer = 0, minLeftPointer = 0, minWindowLength = Integer.MAX_VALUE;
            char[] sCharArray = s.toCharArray();

            while (rightPointer < sLength) {
                char curChar = sCharArray[rightPointer];
                if (charCount[curChar] > 0) {
                    count--;
                }

                charCount[curChar]--;
                rightPointer++;

                while (count == 0) {
                    if (rightPointer - leftPointer < minWindowLength) {
                        minLeftPointer = leftPointer;
                        minWindowLength = rightPointer - leftPointer;
                    }

                    if (charCount[sCharArray[leftPointer]] == 0) {
                        count++;
                    }

                    charCount[sCharArray[leftPointer]]++;
                    leftPointer++;
                }
            }

            return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minLeftPointer, minLeftPointer + minWindowLength);
        }
    }

