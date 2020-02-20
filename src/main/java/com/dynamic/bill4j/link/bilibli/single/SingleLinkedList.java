package com.dynamic.bill4j.link.bilibli.single;

import com.sun.istack.internal.NotNull;

import java.util.concurrent.atomic.LongAdder;

/**
 * @description：
 * @author：by Bill-liu
 * @date：2020/2/15
 */
public class SingleLinkedList {
    public HeroNode getHead() {
        return head;
    }

    private HeroNode head;
    private int count;

    public int getCount() {
        return count;
    }

    public SingleLinkedList() {
        this.head = new HeroNode(0, "", "");
        this.count = 0;
    }
    //不考虑链表序号的顺序
    //思路二：每次添加都往链表的头部进行插入
    //思路三：每次添加都往链表的任意位置进行插入

    //思路一：每次添加都往链表的最后进行插入
    public void add(HeroNode heroNode) {
        //    先找到链表的最后：遍历链表，直到next的值为null，进行插入（将最后节点next的值指向新的node）
        //     加入辅助变量
        HeroNode temp = head;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            }
            temp = temp.getNextNode();
        }
        //next 节点指向新的Node
        temp.setNextNode(heroNode);
        count++;
    }

    public void addToFirstNodeAlways(HeroNode heroNode)  {
        HeroNode newHeroNode = heroNode;
        HeroNode cur = this.head;
        //头节点的下一个永远作为第一个节点
        if (cur.getNextNode() == null) {
            cur.setNextNode(newHeroNode);
        } else {
            newHeroNode.setNextNode(cur.getNextNode());
            cur.setNextNode(newHeroNode);
        }
        count++;
    }
    public static void addToFirstNodeAlways(SingleLinkedList originalLinkedList,HeroNode heroNode)  {
        HeroNode newHeroNode = heroNode;
        HeroNode cur = originalLinkedList.getHead();
        //头节点的下一个永远作为第一个节点
        if (cur.getNextNode() == null) {
            cur.setNextNode(newHeroNode);
        } else {
            newHeroNode.setNextNode(cur.getNextNode());
            cur.setNextNode(newHeroNode);
        }
        originalLinkedList.count++;
    }


    //考虑链表的有序性，每次插入保证链表是有序的
    public void addInOrder(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean enableInsertion = false;
        while (true) {
            if (temp.getNextNode() == null) {
                System.out.println("已到链表尾部~");
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNumber() > heroNode.getNumber()) {
                enableInsertion = true;
                break;
            } else if (temp.getNextNode().getNumber() == heroNode.getNumber()) {
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableInsertion) {
            heroNode.setNextNode(temp.getNextNode());
            temp.setNextNode(heroNode);
            count++;
        } else {
            System.out.println("no已存在,不允许重复插入！");
        }
    }

    public void remove(int no) {
    //    先找到要删除的节点的前一个结点，利用temp节点
        HeroNode temp = this.head;
        boolean enableRemove = false;
        while (true) {
            if (temp.getNextNode() == null) {
                System.out.println("已经到达链表尾部！");
                break;
            } else if (temp.getNextNode().getNumber() == no) {
                enableRemove = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableRemove) {
            //    将要删除的节点从temp节点移除，将temp的next指向，temp的下下个节点
            temp.setNextNode(temp.getNextNode().getNextNode());
            count--;
            System.out.printf("成功移除节点 %d ", no);
            System.out.println("");
        } else {
            System.out.println("没有找到要移除的no对应的人物");
        }
    }

    public void update(HeroNode heroNode) {
        HeroNode temp = this.head;
        boolean enableUpdate = false;
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            } else if (temp.getNumber() == heroNode.getNumber()) {
                enableUpdate = true;
                break;
            }
            temp = temp.getNextNode();
        }
        if (enableUpdate) {
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
            System.out.printf("没有找到节点 %d ", heroNode.getNumber());
            System.out.println("");
        }
    }

    /**
     * 查找该链表中倒数第index个结点
     * @param head 要查找的链表的头结点
     * @param index 倒数第 {@code index } 个结点
     * @return 返回倒数第 index 个{@code HeroNode}
     * @throws NullPointerException if LinkedList node is empty
     */
    public HeroNode nodeOfLastIndex(HeroNode head, int index) {
        HeroNode temp = head;
        if (temp.getNextNode() == null) {
            return null;
        }
        int length = getLength(head);
        verifyIndexValidity(index, length);
        LongAdder count = new LongAdder();
        while (true) {
            if (temp.getNextNode() == null) {
                break;
            } else if (length-index == count.intValue()) {
                break;
            }
            temp = temp.getNextNode();
            count.increment();
        }
        return temp;
    }

    public HeroNode nodeOfLastIndexOf2(HeroNode head, int index) {
        HeroNode cur = head;
        if (cur.getNextNode() == null) {
            return null;
        }
        int length = getLength(head);
        verifyIndexValidity(index, length);

        for (int i = 0; i < length-index; i++) {
            cur = cur.getNextNode();
        }
        return cur;
    }

    @Deprecated
    public static void  revertSingleLinkedList(@NotNull SingleLinkedList originalLinkedList) {
    //    入参校验
    verifyThatTheLinkedListIsEmpty(originalLinkedList);
    //    辅助变量
    //    遍历原链表，取出原链表的节点，总是放入新链表的第一个节点
        int length = getLength(originalLinkedList.getHead());
        //取得当前节点，头节点后的第一个节点
        HeroNode cur = originalLinkedList.getHead().getNextNode();
        HeroNode reverseHead = new HeroNode(0,"","");
        for (int i = 0; i < length; i++) {
            //当前节点的下一个，取出备用
            HeroNode next = cur.getNextNode();
            //将当前节点的下一个节点，插入到新链表的第一个位置
            cur.setNextNode(reverseHead.getNextNode());
            //将当前节点，和新链表链接起来
            reverseHead.setNextNode(cur);
            // result.addToFirstNodeAlways(newHeroNode);
            // System.out.println("装到新链表中的节点newNode="+result.getHead().getNextNode());
            //将节点往后移动
            cur = next;
        }
        //将旧链表的头节点，指向新链表的第一个节点，完成转置
        originalLinkedList.getHead().setNextNode(reverseHead.getNextNode());
    }

    public static HeroNode recursiveReversion(@NotNull HeroNode head) {
        verifyThatTheLinkedListIsEmpty(head);
        HeroNode result = recursiveReversion(head.getNextNode());
        //reverse
        head.getNextNode().setNextNode(head);
        head.setNextNode(null);
        return result;
    }
    public static void  revertSingleLinkedList(@NotNull HeroNode head) {
    //    入参校验
    verifyThatTheLinkedListIsEmpty(head);
    //    辅助变量
    //    遍历原链表，取出原链表的节点，总是放入新链表的第一个节点
        int length = getLength(head);
        //取得当前节点，头节点后的第一个节点
        HeroNode cur = head.getNextNode();
        HeroNode reverseHead = new HeroNode(0,"","");
        for (int i = 0; i < length; i++) {
            //当前节点的下一个，取出备用
            HeroNode next = cur.getNextNode();
            //将当前节点的下一个节点，插入到新链表的第一个位置
            cur.setNextNode(reverseHead.getNextNode());
            //将当前节点，和新链表链接起来
            reverseHead.setNextNode(cur);
            //将节点往后移动
            cur = next;
        }
        //将旧链表的头节点，指向新链表的第一个节点，完成转置
        head.setNextNode(reverseHead.getNextNode());
    }

    @Deprecated
    public static HeroNode reverse(@NotNull SingleLinkedList singleLinkedList) {
        if (singleLinkedList == null || singleLinkedList.getHead() == null) {
            System.out.println("链表为空！");
        }
        HeroNode temp = singleLinkedList.getHead().getNextNode();
        //fixme:使用递归产生，压栈和出栈的效果，从而达到反转的目的  -- Bill-liu BuiltIn 2020/2/19 2:29
        HeroNode reverseHead = reverse(singleLinkedList);
        temp.setNextNode(reverseHead.getNextNode());
        singleLinkedList.getHead().setNextNode(null);
        return reverseHead;
    }




    private void verifyIndexValidity(int index, int length) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("length = " + length + ", index = " + index);
        }
    }


    public static int getLength(HeroNode head) {
        HeroNode temp = head;
        int length = 0;
        if (temp.getNextNode() == null) {
            return length;
        }
        while (temp.getNextNode() != null) {
            temp = temp.getNextNode();
            length++;
        }
        return length;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("链表为空!");
        }
        //输出所有除头节点之外的节点信息，需要遍历链表
        HeroNode temp = head.getNextNode();
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.getNextNode();
        }

    }
    private void verifyThatTheLinkedListIsEmpty() {
        if (isEmpty()) {
            System.out.println("链表为空！");
        }
    }
    private static void verifyThatTheLinkedListIsEmpty(HeroNode heroNode) {
        if (isEmpty(heroNode)) {
            System.out.println("链表为空！");
        }
    }
    @Deprecated
    private static void verifyThatTheLinkedListIsEmpty(SingleLinkedList singleLinkedList) {
        if (isEmpty(singleLinkedList)) {
            System.out.println("链表为空！");
        }
    }
    private boolean isEmpty() {
        return this.head.getNextNode() == null;
    }

    @Deprecated
    private static boolean isEmpty(SingleLinkedList singleLinkedList) {

        return singleLinkedList.getHead().getNextNode() == null;
    }

    private static boolean isEmpty(HeroNode heroNode) {

        return heroNode.getNextNode() == null;
    }
}
