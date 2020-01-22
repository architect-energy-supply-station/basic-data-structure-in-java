package com.dynamic.bill4j.array.crazy.handout;

/**
 * Created by Administrator on 2020/1/11.
 * commpany:
 * version:
 */
public class PrintTheNinetyNineMultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            for (int j = 1; j <=i; j++) {
                if (i == j) {
                    System.out.printf("%d %s %d %s %d \t", i, "*", j, "=", i * j);
                } else {
                    System.out.printf("%d %s %d %s %d %s \t",i,"*",j,"=",i*j,",");
                }
            }
            System.out.println("");
        }
    }
}
