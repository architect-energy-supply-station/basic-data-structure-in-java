package com.dynamic.bill4j.operation;

/**
 * @author bill-smith liuwb
 * @Package com.dynamic.bill4j.operation
 * @Date 2019/12/20 10:53
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class OperationTest {
    public static void main(String[] args) {
        Integer i =0;
        int temp=0;
//        varplusplus(i);
//        plusplusvar(i);
        varpluspluswithInteger(i);
//        System.out.println("i=i++ 的值"+(temp=i++));
//        System.out.println("i=++i 的值"+(temp=++i));
//        System.out.println(i++);
        System.out.println(i);
//        System.out.println(++i);
    }

    private static void varplusplus(int i) {
        System.out.println("before i ++ i的值"+ i);
        System.out.println("i++的值"+ i++);
        System.out.println("after i++ 的值"+i);
        System.out.println("***********************");
    }
    private static void varpluspluswithInteger(Integer i) {
        System.out.println("before i ++ i的值"+ i);
        System.out.println("i++的值"+ i++);
        System.out.println("after i++ 的值"+i);
        System.out.println("***********************");
    }

    private static void plusplusvar(int i) {
        System.out.println("before ++ i 的值"+ i);
        System.out.println("++ i的值"+ (++i));
        System.out.println("after ++i 的值"+i);
        System.out.println("******************");
    } private static void plusplusvarInteger(Integer i) {
        System.out.println("before ++ i 的值"+ i);
        System.out.println("++ i的值"+ (++i));
        System.out.println("after ++i 的值"+i);
        System.out.println("******************");
    }
}
