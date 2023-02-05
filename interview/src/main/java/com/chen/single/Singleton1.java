package com.chen.single;

/**
 * @author CD
 * @since 2023/2/1 10:06
 * package: com.chen.single
 * class: Singleton1
 */
public class Singleton1 {

    /**
     * 单例设计模式
     * 构造器私有化
     * 自行创建，用静态变量保存
     * 向外提供实例
     */

    //饿汉式 直接创建对象向外暴露
    //无论是否需要均创建

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }
}
