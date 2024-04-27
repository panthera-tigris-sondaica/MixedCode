package com.stack;

import java.util.Stack;

public class InfixExpression {
    public static void main(String[] args) {
        String str = "9-5+3*4/6";
        int ans=findValue(str);
        System.out.println(ans);
    }

    public static int findValue(String str) {
        Stack<Integer> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            int s = (int) ch;
            if (s >= 48 && s <= 57) st.push(s - 48);
            else if (op.empty()) op.push(ch);
            else {
                if (ch == '+' || ch == '-') {
                    int val1 = st.pop();
                    int val2 = st.pop();
                    if (op.peek() == '+') st.push(val2 + val1);
                    if (op.peek() == '-') st.push(val2 - val1);
                    if (op.peek() == '*') st.push(val2 * val1);
                    if (op.peek() == '/') st.push(val2 / val1);
                    op.pop();
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int val1 = st.pop();
                        int val2 = st.pop();
                        if (op.peek() == '*') st.push(val2 * val1);
                        if (op.peek() == '/') st.push(val2 / val1);
                        op.pop();
                        op.push(ch);
                    } else op.push(ch);
                }

            }
        }
        while(st.size() > 1) {
            int val1 = st.pop();
            int val2 = st.pop();
            if (op.peek() == '+') st.push(val2 + val1);
            if (op.peek() == '-') st.push(val2 - val1);
            if (op.peek() == '*') st.push(val2 * val1);
            if (op.peek() == '/') st.push(val2 / val1);
            op.pop();
        }
        return st.peek();
    }
}


