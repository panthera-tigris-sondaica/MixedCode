public class FlowerPlant {
    public static void main(String[] args) {
        int[] flowerbed={1,0,0,0,1,1,0};
        int n=2;
        int len = flowerbed.length;
        for (int i = 0; i < len && n > 0; i += 2) {
        if (flowerbed[i] == 0) {
            System.out.println("show i value first"+i);
            if (i == len - 1 || flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
            } else {
                i++;
                System.out.println("value of i "+i);
            }
        }

    }
        System.out.println(n<=0);
  }
}
