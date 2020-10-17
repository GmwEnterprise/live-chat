package com.github.mrag.livechat.common;

import java.util.ArrayList;

/**
 * @author Gmw
 */
public class TestMain {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(TestMain.class.getClassLoader());
        System.out.println(TestMain.class.getClassLoader().getParent());
        System.out.println(TestMain.class.getClassLoader().getParent().getParent());

        // 返回null说明是bootstrap classloader
        System.out.println(ArrayList.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());

        // java9以后取消了ExtensionClassLoader，新增了PlatformClassLoader
        System.out.println(ClassLoader.getPlatformClassLoader());

        // 双亲委派机制。类加载器总是会优先让父加载器来加载目标Class
        Class<?> stringClass = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        System.out.println(stringClass);
        System.out.println(stringClass.getClassLoader()); // null ==> Bootstrap ClassLoader
    }

    // public static void main(String[] args) {
    //     Class<int[][]> type = int[][].class;
    //     System.out.println(type.getCanonicalName());
    //     System.out.println(type.getSimpleName());
    //     System.out.println(type.getName());
    //     System.out.println(type.getPackage());
    // }

    // public static void main(String[] args) {
    //     long num = 50203L;
    //     System.out.println(50203 == num);
    // }
}
