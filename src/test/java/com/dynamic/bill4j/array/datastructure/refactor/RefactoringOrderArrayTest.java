package com.dynamic.bill4j.array.datastructure.refactor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefactoringOrderArrayTest {
    RefactoringOrderArray array;

    @AfterEach
    void tearDown() {
        array = null;
    }

    @Test
    void indexOfInt() {
        array = new RefactoringOrderArray(5);
        assertEquals(-1,array.indexOf(2));

        array.insert(2);
        array.insert(21);
        array.insert(99);
        System.out.println("打印初始化数组内容");
        array.display();

        assertEquals(-1, array.indexOf(22));
        assertEquals(0, array.indexOf(2));
        assertEquals(1, array.indexOf(21));
        assertEquals(2, array.indexOf(99));

    }

    @Test
    void getMax() {
        array = new RefactoringOrderArray(5);
        assertEquals(-1, array.getMax());
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.display();
        assertEquals(99, array.getMax());
    }

    @Test
    void removeMax() {
        array = new RefactoringOrderArray(5);
        assertEquals(0, array.removeMaxAndGet());
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.display();
        assertEquals(99, array.removeMaxAndGet());

    }

    @Test
    void removeElement() {
        array = new RefactoringOrderArray(5);
        array.display();
        assertEquals(false, array.removeElement(0) );
        array.insert(2);
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.insert(98);

        array.display();
        assertEquals(true, array.removeElement(98));
        assertEquals(4,array.geteElement());
        assertEquals(false, array.removeElement(1));
        assertEquals(4,array.geteElement());
        assertEquals(true, array.removeElement(2));
        assertEquals(3,array.geteElement());
        array.display();
    }

    @Test
    void removeByIndex() {
        array = new RefactoringOrderArray(5);
        array.display();
        // assertEquals(true, array.remove(0) );
        array.insert(2);
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.insert(98);
        assertEquals(5, array.geteElement());
        array.display();
        assertEquals(true, array.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> array.remove(5));

        assertEquals(4,array.geteElement());
        array.display();
    }

    @Test
    void removeElements() {
        array = new RefactoringOrderArray(5);
        array.display();
        // assertEquals(true, array.remove(0) );
        array.insert(2);
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.insert(98);
        array.display();
        assertEquals(true, array.removeElements(2, 2));
        array.display();
        assertEquals(3, array.geteElement());

    }

    @Test
    void removeElementsLongArray() {
        array = new RefactoringOrderArray(5);
    //case1 为null的时候（特殊值），因为该数组，在使用前必须要初始化，所以不会出现为null的情况
        //case 2为空的时候（特殊值），数组里面什么都没有，即没有进行初始化
        assertArrayEquals(new long[5], array.getArray());
        assertEquals(Long.TYPE, array.getArray().getClass().getComponentType());
        //初始化内部数组
        array.insert(2);
        array.insert(99);
        array.insert(2);
        array.insert(98);
        //    边界值测试
        long[] result;
        //元素不存在
        result = array.removeElements(array.getArray(), 1);
        assertArrayEquals(array.getArray(),result );
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        array.display();

    //被删除元素存在
    //    case3 单个
        array = new RefactoringOrderArray(5);
        //初始化内部数组
        array.insert(2);
        array.insert(99);
        array.insert(2);
        array.insert(98);
        result = array.removeElements(array.getArray(), 2);
        assertArrayEquals(array.getArray(),result );
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        array.display();

        //初始化内部数组
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(99);
        array.insert(2);
        array.insert(98);
        result = array.removeElements(array.getArray(), 98);
        assertArrayEquals(array.getArray(),result );
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        array.display();
    //    多个
        //    case4 被删除元素均存在于原数组中（刚好等于原数组，大于、小于原数组、）
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(99);
        array.insert(2);
        array.insert(98);
        result = array.removeElements(array.getArray(), 2,99,2,98);
        assertArrayEquals(array.getArray(),result );
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        array.display();

        // case5 被删除元素，原数组中：个别存在，个别不存
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(99);
        array.insert(2);
        array.insert(98);
        result = array.removeElements(array.getArray(), 2,1,2);
        assertArrayEquals(array.getArray(),result );
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        array.display();
    //    case6 异常情况

    }
    @Test
    void removeAll() {
        //特殊值处理：null，空值
        array = new RefactoringOrderArray(5);
        long[] result = array.removeAllAndGet();
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        //正常情况
        //1.移除单个元素
        //1.1 移除后，还剩余元素
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.insert(98);
        System.out.println("移除前");
        array.display();
         result = array.removeAllAndGet(1);
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        assertEquals(4,array.geteElement());
        System.out.println("移除后");
        array.display();

        //1.2 移除后，没有元素
        array = new RefactoringOrderArray(5);
        array.insert(2);
        System.out.println("移除前");
        array.display();
        result = array.removeAllAndGet(0);
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        assertEquals(0,array.geteElement());
        System.out.println("移除后");
        array.display();
        //2.移除多个
        //2.1 全部移除
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        array.insert(77);
        array.insert(88);
        System.out.println("移除前");
        array.display();
        result = array.removeAllAndGet(0,1,2,3);
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        assertEquals(0,array.geteElement());
        System.out.println("移除后");
        array.display();
        //2.2 移除部分
        //2.21 间隔移除
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        array.insert(77);
        array.insert(88);
        System.out.println("移除前");
        array.display();
        result = array.removeAllAndGet(0,2);
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        assertEquals(2,array.geteElement());
        System.out.println("移除后");
        array.display();
        //2.22 连续移除
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        array.insert(77);
        array.insert(88);
        System.out.println("移除前");
        array.display();
        result = array.removeAllAndGet(2,3);
        assertArrayEquals(array.getArray(), result);
        assertEquals(Long.TYPE,result.getClass().getComponentType());
        assertEquals(2,array.geteElement());
        System.out.println("移除后");
        array.display();
        // 3异常情况
        // 3.1 索引值超出界限
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        array.insert(77);
        array.insert(88);
        System.out.println("移除前");
        array.display();
        // 3.1.1 上界
        assertThrows(IndexOutOfBoundsException.class, ()->array.removeAllAndGet(1,5));
        System.out.println("移除后");
        array.display();
        // 3.1.2  下界
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        array.insert(77);
        array.insert(88);
        System.out.println("移除前");
        array.display();
        assertThrows(IndexOutOfBoundsException.class, ()->array.removeAllAndGet(-1,1));
        System.out.println("移除后");
        array.display();
        // 3.2 索引值重复
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        System.out.println("移除前");
        array.display();
        result=array.removeAllAndGet(1,1);
        assertEquals(array.getArray(), result);
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        System.out.println("移除后");
        array.display();
        //4 边界值
        //4.1 第一个元素
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        System.out.println("移除前");
        array.display();
        result=array.removeAllAndGet(0);
        assertEquals(array.getArray(), result);
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        assertEquals(1, array.geteElement());
        System.out.println("移除后");
        array.display();
        //4.2 最后一个元素
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(98);
        System.out.println("移除前");
        array.display();
        result=array.removeAllAndGet(1);
        assertEquals(array.getArray(), result);
        assertEquals(Long.TYPE, result.getClass().getComponentType());
        assertEquals(1, array.geteElement());
        System.out.println("移除后");
        array.display();
        // assertEquals(true, array.remove(0) );
        array = new RefactoringOrderArray(5);
        array.insert(2);
        array.insert(2);
        array.insert(21);
        array.insert(99);
        array.insert(98);
        array.display();
        assertEquals(5, array.geteElement());
    }

    @Test
    void removeAllOccurrences() {
        array = new RefactoringOrderArray(5);
        array.insertWithDuplicate(2);
        array.insertWithDuplicate(2);
        array.insertWithDuplicate(1);
        array.insertWithDuplicate(1);
        array.insertWithDuplicate(2);
        System.out.println("移除前");
        array.display();
        array.removeAllOccurrences(1);
        assertEquals(4,array.geteElement());
        System.out.println("移除后");
        array.display();
    }
@Test
    void DeDuplication() {
    array = new RefactoringOrderArray(5);
    array.insertWithDuplicate(2);
    array.insertWithDuplicate(3);
    array.insertWithDuplicate(1);
    array.insertWithDuplicate(1);
    array.insertWithDuplicate(2);
    System.out.println("移除前");
    array.display();
    array.Deduplication();
    assertEquals(3,array.geteElement());
    System.out.println("移除后");
    array.display();
    }
}