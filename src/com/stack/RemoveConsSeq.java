package com.stack;

import java.util.Stack;

public class RemoveConsSeq {
    public static void main(String[] args) {
        int[] arr1={4,1,2};//nums1 = [4,1,2], nums2 = [<1,3,4,2]>
        int[] arr2={1,3,4,2};
        int[] res=nextGreaterElement(arr1,arr2);
        for(int i:res)
        System.out.println(i);
    }


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    if(nums2[j]==nums2[nums2.length-1]){
                        res[i]=-1;
                    }
                    else{
                        int k;
                        for(k=j+1;k<nums2.length;k++){
                            if(nums2[j]<nums2[k]){
                                res[i]=nums2[k];
                                break;
                            }

                        }
                        if(k==nums2.length)
                            res[i]=-1;

                    }
                }
                //else continue;
            }

        }
        return res;
    }

    private static Stack removeSeq(int[] arr) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty() || st.peek()!=arr[i]){
                st.push(arr[i]);
            }
            else{
                if(st.peek()==arr[i]){
                    //if(i==arr.length-1)st.pop();
                     if(i== arr.length-1 || arr[i]!=arr[i+1])st.pop();
                }
            }
        }
        return st;
    }
}
