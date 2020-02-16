package com.dynamic.bill4j.alibaba;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/11
 */
public class CheckReture {
    public static void main(String[] args) {
        System.out.println(checkReturnValue());
    }

    private static int checkReturnValue() {
        int x = 0;
        try {
            return ++x;
        } finally {
            return ++x;
        }

    }
}
