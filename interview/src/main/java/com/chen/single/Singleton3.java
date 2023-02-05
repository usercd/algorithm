package com.chen.single;

/**
 * @author CD
 * @since 2023/2/1 10:25
 * package: com.chen.single
 * class: Singleton3
 * 饿汉式静态代码块
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    static {
        INSTANCE = new Singleton3();
    }
    private Singleton3(){

    }
}
