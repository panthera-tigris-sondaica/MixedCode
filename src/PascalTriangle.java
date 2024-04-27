import java.util.*;


public class PascalTriangle {
    public static void main(String... args) {
        int m = 6;
       findPascalTriangle(m);
        //System.out.println(l);
    }

    private static void findPascalTriangle(int rowIndex) {
        List<List<Integer>> ll = new ArrayList<>();
        Integer[] prevrow = {1};
        ll.add(Arrays.asList(prevrow));
        for (int i = 1; i <=rowIndex; i++) {
            Integer[] jarr = new Integer[i + 1];
            jarr[0] = 1;
            for (int j = 1; j < i; j++) {
                jarr[j] = prevrow[j - 1] + prevrow[j];
            }
            jarr[jarr.length - 1] = 1;
            prevrow = jarr;
            ll.add(Arrays.asList(prevrow));

        }
        System.out.println("print rowindex list" +ll);
        System.out.println(ll.get(rowIndex-2));
    }
}
     /*   List<List<Integer>> l =new ArrayList<>();
        Integer[] previousRow = {1};
        l.add(Arrays.asList(previousRow));
        for(int i=1;i<m;i++) {
            Integer[] newRow = new Integer[i+1];
            newRow[0]=1;
            for (int j = 1; j < i; j++) {
                newRow[j] = previousRow[j-1]+previousRow[j];
            }
            newRow[newRow.length-1]=1;
            previousRow = newRow;
            l.add(Arrays.asList(previousRow));
        }
        return l;*/


