package com.dynamic.bill4j.array.crazy.handout;
import java.util.Arrays;

/**
 * @author bill-smith liuwb
 * @Package com.dynamic.bill4j.array.crazy.handout
 * @Date 2020/1/5 20:39
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */

public class ForLoopTraining {
    public static void main(String[] args) {
//        ninetyNineMultiplicationTable();
//        printTriangle();
        printFibonacci(10);
    }

    private static void printFibonacci(int number) {
        int[] array = new int [number];
        for (int i = 0; i < number; i++) {
            //region linda you are beautiful
            if (i >= 2) {
                array[i] = array[i - 1] + array[i - 2];
            }else {
                array[i]=1;
            }
        }
        //endregion
        System.out.println(Arrays.toString(array));
    }

    private static void printTriangle() {
        for (int i = 1; i < 5; i++) {
            for (int m = 4-i; m >0; m--) {
                System.out.printf(" ");
            }
            for (int j = 1; j <=2*i-1 ; j++) {
                System.out.printf("*");
            }
        }
    }


    private static void ninetyNineMultiplicationTable() {
        for (int i = 1; i < 10; i++) {
            for (int j =1; j <=i; j++) {
                if(j != i){
                    System.out.printf("%d %s %d %s %d %s ", i, "x", j, "=", i * j ,",");
                }else {
                    System.out.printf("%d %s %d %s %d", i, "x", j, "=", i * j);
                }
            }
            System.out.println();
        }
    }
}
