package com.dynamic.bill4j.link.bilibli.onewayloop;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/3/1
 */
public class OneWayCircularLinkedList {
    private BoyNode firstNode;

    public BoyNode getFirstNode() {
        return firstNode;
    }


    public void setFirstNode(BoyNode firstNode) {
        this.firstNode = firstNode;
    }

    private int count ;

    public int getCount() {
        return count;
    }

    /**
     *  构造指定节点个数的单向循环链表,使用尾插法
     * @param number 节点的个数
     * @return 构造好的整个单向循环链表
     */
    public void add(int number) {
        // 校验参数有效性
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Illegal parameter！number require >=1 , and must < 10, but now number is :  " + number);
        }
        //辅助节点，因为first节点保持不动
        BoyNode current = null;
        for (int i = 1; i <=number; i++) {
            BoyNode boy = new BoyNode(i);
            if (i == 1) {
                //todo 不明白这句话
                firstNode = boy;
                firstNode.setNext(firstNode);
                current = firstNode;
            } else {
                current.setNext(boy);
                boy.setNext(firstNode);
                current = boy;
            }
            count++;
        }

    }

    /**
     * 打印输出单向循环链表中的节点
     */
    public void display() {
    //   不为空时 遍历该链表，逐项输出打印
        if (firstNode== null) {
            System.out.println("链表为空");
            return;
        }
        BoyNode current = firstNode;
        while (current.getNext() != firstNode) {
            // System.out.println(current.getNext());
            System.out.printf("小孩的编号是：%d ", current.getNo());
            System.out.printf("");
            current = current.getNext();
        }
        System.out.printf("小孩的编号是：%d ", current.getNo());

        //同样的代码效果，可读性更强些
        // while (true) {
        //     System.out.printf("小孩的编号是：%d ", current.getNo());
        //     if (current.getNext()==firstNode) {
        //         break;
        //     }
        //     current = current.getNext();
        // }

    }

    public void josephProblem(int startNumber, int intervalSequence, int numbersOfCircular) {
    //    入参校验
        if (startNumber < 1 || startNumber > numbersOfCircular || intervalSequence < 1) {
            throw new IllegalArgumentException("Illegal parameters! required startNumber>=1 and startNumber< numbersOfCircular and intervalSequence>=1");
        }
    //      1、先设定辅助变量helper指针，并定位到最后一个节点
        BoyNode helper = firstNode;
        while (true) {
            if (helper.getNext()==firstNode) {
                break;
            }
            helper = helper.getNext();
        }
    //      2、在报数之前，将helper和first指针分别移动startNumber -1 个节点（开始报数的位置）
        for (int i = 0; i < startNumber - 1; i++) {
            firstNode = firstNode.getNext();
            helper = helper.getNext();
        }
    //      3、将helper和first指针分别移动intervalSequence-1个节点，模拟小孩报数过程（循环），到号的出圈
        while (true) {
            //剩下最后一个节点时，退出，不用再构成报数的过程
            if (helper == firstNode) {
                break;
            }
            for (int i = 0; i < intervalSequence-1; i++) {
                firstNode = firstNode.getNext();
                helper = helper.getNext();
            }
        //    此时的firstNode指向的是将要出圈的节点
            System.out.println("");
            System.out.printf("将要出圈的小孩编码是%d",firstNode.getNo());
            //      4、开始进行出圈操作
            firstNode = firstNode.getNext();
            helper.setNext(firstNode);

        }
        System.out.println("");
        System.out.printf("最后一个出圈的小孩编号是：%d", firstNode.getNo());
    }

}
