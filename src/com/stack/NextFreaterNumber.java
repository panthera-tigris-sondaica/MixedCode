package com.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextFreaterNumber {
    public static void main(String[] args) {
        int[] arr1={3,1,5,7,9,2,6};//nums1 = [4,1,2], nums2 = [<1,3,4,2]>
        int[] arr2={1,2,3,5,6,7,9,11};
        int[] res=nextGreaterElements(arr1,arr2);
        for(int i:res)
        System.out.print(i+" "); //5,2,6,9,11,3,7

    }

    public static int[] nextGreaterElements(int[] nums1,int[] nums2) {
        int m=nums2[0];
        int[] out=new int[nums1.length];
        for(int i=1;i<nums2.length;i++){
            m=Math.max(m,nums2[i]);
        }
        int[] res=new int[m+1];
        Stack<Integer> st=new Stack<>();
        int n=nums2.length-1;
        res[nums2[n]]=-1;
        st.push(nums2[n]);
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && nums2[i]>=st.peek()){
                st.pop();
            }
            if(!st.empty() && st.peek()>nums2[i]){
                res[nums2[i]]=st.peek();
            }
            if(st.empty())
                res[nums2[i]]=-1;
            st.push(nums2[i]);
        }
        for(int j=0;j<nums1.length;j++)
            out[j]=res[nums1[j]];
        return out;
    }
}
