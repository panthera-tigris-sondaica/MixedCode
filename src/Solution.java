import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

class Solution{
    public static void main(String... args){

        A a = new A();
        int[] nums={4,3,2,7,8,2,11};
        List<Integer> l=a.findDisappearedNumbers(nums);
        System.out.println(l.size());
        //System.out.println(l.method());
        System.out.println(l);
    }
}

class A {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return new MyList(nums);
    }

    private static class MyList extends ArrayList<Integer> {
        int[] nums;

        public MyList(int[] nums) {
            this.nums = nums;
        }
        public int size() {
            if (nums != null) {
                method();
                System.out.println("return values from method()");
            }
            return super.size();
        }
        public void method() {
            System.out.println("inside method()");
            if(nums==null) return;
            int[] nums = this.nums;

            System.out.println("nums value"+nums);
            Set<Integer> set = new HashSet<>(nums.length + 3, 3f);

            for (int num : nums) {
                set.add(num);
            }
            for (int i = nums.length; i > 0; i--) {

                if (!set.contains(i)) {
                    super.add(i);
                }
            }
            this.nums = null;
        }
    }
}
