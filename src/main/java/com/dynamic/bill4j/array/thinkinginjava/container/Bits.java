package com.dynamic.bill4j.array.thinkinginjava.container;

import java.util.BitSet;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/9
 */
public class Bits {
    public static void printBitSet(BitSet bitSet) {
        System.out.print(bitSet);
        StringBuilder bbits = new StringBuilder();
        for (int i = 0; i < bitSet.size(); i++) {
            bbits.append(bitSet.get(i) ? "1" : "0");
        }
        System.out.println();
        System.out.printf("bit pattern: %s",bbits);
    }

    public static void main(String[] args) {
        BitSet bb = new BitSet();
        bb.set(63);
        printBitSet(bb);
        System.out.println();
        // bb.clear();
        bb.set(64);
        bb.set(2);
        bb.set(3);
        printBitSet(bb);
        int values = bb.cardinality();
        System.out.println();
        System.out.println(values);
        System.out.println(bb.nextSetBit(0));
        System.out.println(bb.nextClearBit(3));
    }
}
