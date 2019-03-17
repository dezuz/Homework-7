package com.mateacademy.singleton;

import java.lang.reflect.Constructor;

public class SingletonTest {

    public static void main(String[] args) {
        System.out.println("First Singleton object hashcode is: " + Singleton.getInstance().hashCode());
        try {
            Constructor constructors = Singleton.class.getDeclaredConstructor();
            constructors.setAccessible(true);
            Singleton newInstance = (Singleton) constructors.newInstance();
            System.out.println("Second Singleton object hashcode is: " + newInstance.hashCode());
        } catch (Throwable e){
            e.printStackTrace();
        }
    }
}
