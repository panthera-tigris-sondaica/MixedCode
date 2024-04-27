import java.util.HashMap;
import java.util.Map;

public class MetrixCountStrikes{
    public static void main(String[] args) {
        int [][] arr = new int[][]{
                {1,11,23},
                {5,17,21},
                {8,13,25}
        };

        int[] input = new int[]{1,10,14,23,5,17,21,8,23,22,25};
        int[] output = getStrike(arr,input);

        for(int i=0; i<output.length; i++){
            System.out.println("After Marking "+input[i]+", \tTotal Strikes: "+output[i]);
        }
    }

    static int[] getStrike(int[][] metrix, int[] input){
        Metrix m = new Metrix(metrix);
        int [] output = new int[input.length];
        for(int i=0; i<output.length; i++){
            output[i] = m.accept(input[i]);
        }
        return output;
    }

}

class Metrix{

    Map<Integer,int[]> map;
    int current=0;
    boolean[][] arr;
    public Metrix(int[][] arr){
        map = new HashMap<>();
        for(int i=0; i< arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                map.put(arr[i][j],new int[]{i,j});
            }
        }
        this.arr=new boolean[arr.length][arr[0].length];
    }

    public int accept(int n) {
        if(map.containsKey(n)){
            int[] cord = map.get(n);
            arr[cord[0]][cord[1]]=true;
            calculate();
        }
        return current;
    }

    private void calculate() {
        int count = 0;

        //row and column
        for(int i=0; i< arr.length; i++){
            boolean rowSum=true;
            boolean colSum=true;
            for(int j=0; j<arr[i].length; j++){
                rowSum &=arr[i][j];
                colSum &=arr[j][i];
            }
            if(rowSum) count++;
            if(colSum) count++;
        }

        //diagonal
        boolean diag1=true, diag2=true;
        for(int i=0; i<arr.length;i++){
            diag1 &=arr[i][i];
            diag2 &=arr[i][arr.length-1-i];
        }
        if(diag1) count++;
        if(diag2) count++;

        current=count;
    }
}