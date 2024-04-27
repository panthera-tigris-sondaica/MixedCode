import java.util.HashMap;
import java.util.Map;

public class NextGreater {
    public static void main(String[] args) {
        int[] nums1={1,3,2};
        int[] nums2={4,2,3,1};
        int[] arr=nextGreaterElement(nums1,nums2);
        for(int i:arr)
        System.out.println(i);
    }
    public  static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n-1;i++){
            int ele=nums2[i];
            int val=-1;

            for(int j=i+1;j<n;j++){
                if(nums2[i]<nums2[j]){
                    val=nums2[j];
                    map.put(ele,val);
                    break;
                }
            }
            if(val==-1){
                map.put(ele,val);
            }

        }
        map.put(nums2[n-1],-1);
        for(int i=0;i<nums1.length;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}
