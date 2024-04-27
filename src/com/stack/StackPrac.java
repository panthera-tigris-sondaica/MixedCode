package com.stack;

import java.util.Stack;

public class StackPrac {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack();//stack // 1
        st.push(5);             // 2
        st.push(4);             // 3
        st.push(3);             // 4
        st.push(2);             // 5
        st.push(1);

        recursiveCall(st);
        display(st);



    }
    public static void display(Stack st){
        while(st.size()>0){
            System.out.println(st.pop());
        }
    }

    public static void recursiveCall(Stack st){
        if(st.size()==0){ st.push(6); return;}
        int top=(int) st.pop();
        recursiveCall(st);
        //System.out.println(top);
        st.push(top);


    }

}
