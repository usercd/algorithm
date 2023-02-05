package com.chen.single;

/**
 * @author CD
 * @since 2023/2/1 10:34
 * package: com.chen.single
 * class: Singleton4
 * 懒汉式 延迟创建实例对象
 * 存在线程安全问题 适用单线程
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4(){

    }

    public static Singleton4 getInstance(){
        if (instance == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            instance = new Singleton4();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton4 s1 = Singleton4.getInstance();
        Singleton4 s2 = Singleton4.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
