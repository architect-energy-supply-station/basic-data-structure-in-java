package com.dynamic.bill4j.array.thinkinginjava.loop;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/21
 */
public class LoopTest {
    static int count = 0;
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {

        if (n == 0) {
            return 1;
        } else {
            System.out.printf("开始第 %d 次入栈", ++count);
            System.out.println("");
            int result = n * factorial(n - 1);
            System.out.printf("第 %d 次出栈：factorial函数，出栈返回的结果为: %d", n, result);
            System.out.println("");
            return result;
        }
    }
}
