import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDA {
    public static void main(String[] args) {
        int[][] arr1={{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        for(int i=0;i< arr1.length;i++){
            arr1[i]=reverseArr(arr1[i]);
        }
//        for(int i=0;i< arr1.length;i++){
//            for(int j=0;j<arr1[0].length;j++){
//                System.out.print(arr1[i][j]+" ");
//            }
//            System.out.println();
//        }
//        for(int[] a : arr1){
//            for(int j=0;j<a.length;j++){
//                System.out.print(a[j]+" ");
//            }
//            System.out.println();
//        }
//        for(int[] a : arr1){
//            for(int n: a){
//                System.out.print(n+" ");
//            }
//            System.out.println();
//        }
    }
    public static int[] reverseArr(int[] arr1){
//        int i=0;
//        int j= arr1.length-1;
//        int temp;
//       while(i<j){


//           temp=arr1[i];
//           arr1[i]=arr1[j];
//           arr1[j]=temp;
//           i++;
//           j--;
       //}
        List<Integer> newList = Arrays.stream(arr1).boxed().collect(Collectors.toList());
        System.out.println(newList);
        Collections.reverse(newList);
        System.out.println(newList);
        return newList.stream().mapToInt(Integer::intValue).toArray();
    }
}
