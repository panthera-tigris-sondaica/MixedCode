public class TwoSum {
    public static void main(String... args){
        int[] numbers={5,25,75,67};
        int target=100;
        int k = 0;
        for (int i = 0; i < numbers.length; ++i) {
            if (numbers[i] != target) {
                numbers[k] = numbers[i];
                k++;
            }
        }
        for(int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }


    }
}
