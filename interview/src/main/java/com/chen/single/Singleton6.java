package com.chen.single;

/**
 * @author CD
 * @since 2023/2/1 10:56
 * package: com.chen.single
 * class: Singleton6
 * 在内部类加载初始化 创建INSTANCE实例对象
 */
public class Singleton6 {

    private Singleton6(){

    }

    private static class Inner{
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return Inner.INSTANCE;
    }
}
