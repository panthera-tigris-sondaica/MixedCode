package com.priya;

import java.lang.reflect.Field;

public class NormalCode {

    public static void main(String[] args) {
        System.out.println("Priya");
    }

    static {
        try {
            Field value = String.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set("Priya", value.get("Ritvik"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
