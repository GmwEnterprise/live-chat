package com.github.mrag.livechat.common;

import java.util.Date;

/**
 * @author Gmw
 */
public class TestMain {
    public static void main(String[] args) {
        Class<int[][]> type = int[][].class;
        System.out.println(type.getCanonicalName());
        System.out.println(type.getSimpleName());
        System.out.println(type.getName());
        System.out.println(type.getPackage());
    }
}
