package com.github.mrag.livechat.rest.interceptor;

import com.github.mrag.livechat.rest.HandlerInterceptorWithOrder;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 自动添加该包下所有拦截器
 *
 * @author Gmw
 */
public final class InterceptorRegister {

    public static List<HandlerInterceptorWithOrder> registryInterceptors() {
        String packageName = InterceptorRegister.class.getPackageName();
        URL resourceURL = Thread.currentThread().getContextClassLoader()
                .getResource(packageName.replaceAll("\\.", "/"));
        if (resourceURL == null) {
            throw new RuntimeException("resourceURL is null.");
        }
        return findClassInDir(new File(resourceURL.getFile()), packageName, HandlerInterceptorWithOrder.class);
    }

    private static List<HandlerInterceptorWithOrder> findClassInDir(File dir,
                                                                    String packageName,
                                                                    Class<?>... superInterfaces) {
        if (!dir.isDirectory()) {
            throw new RuntimeException("错误的文件夹格式");
        }

        List<Class<?>> superInterfaceList = superInterfaces != null ? Arrays.asList(superInterfaces) : Collections.emptyList();
        List<HandlerInterceptorWithOrder> interceptors = new ArrayList<>();
        for (File item : dir.listFiles()) {
            if (item.isDirectory()) {
                // 递归
                interceptors.addAll(findClassInDir(item, packageName + "." + item.getName()));
            } else {
                // 类文件
                String className = item.getName().replace(".class", "");
                className = packageName + "." + className;
                Class<?> targetClass;
                try {
                    targetClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

                // 当前类直接实现的所有接口
                List<Class<?>> classes = Arrays.asList(targetClass.getInterfaces());
                boolean eligible;

                if (superInterfaceList.size() == 0) {
                    // 不要求实现任何接口
                    eligible = true;
                } else if (classes.size() == 0) {
                    // 当前类未实现任何接口
                    eligible = false;
                } else {
                    // 当前类直接实现的所有接口中至少一个满足：存在于superInterfaces
                    eligible = classes.stream().anyMatch(superInterfaceList::contains);
                }

                if (eligible) {
                    Constructor<?> constructor = null;
                    try {
                        constructor = targetClass.getConstructor();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        System.exit(0);
                    }

                    HandlerInterceptorWithOrder interceptor = null;
                    try {
                        interceptor = (HandlerInterceptorWithOrder) constructor.newInstance();
                    } catch (InstantiationException | InvocationTargetException e) {
                        // InstantiationException - 指定的类对象无法被实例化时，可能原因：
                        // - 类对象表示一个抽象类、接口、数组类、基本类型、void
                        // - 类没有非 null 构造方法

                        // InvocationTargetException 是一种包装由调用方法或构造方法所抛出异常的经过检查的异常。

                        e.printStackTrace();
                        System.exit(0);
                    } catch (IllegalAccessException e) {
                        if (canControlMemberAccessible()) {
                            constructor.setAccessible(true);
                            try {
                                interceptor = (HandlerInterceptorWithOrder) constructor.newInstance();
                            } catch (Exception ignored) {
                            }
                        }
                    }

                    interceptors.add(interceptor);
                }

            }
        }

        return interceptors;
    }

    public static boolean canControlMemberAccessible() {
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (null != securityManager) {
                securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
            }
        } catch (SecurityException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<HandlerInterceptorWithOrder> interceptors = registryInterceptors();
        System.out.println(interceptors);
    }
}
