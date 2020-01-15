package array.datastructure;

/**
 * @description：
 * @author：by Administrator
 * @date：2020/1/15
 */
public class HighArrayApp {
    public static void main(String[] args) {
        HighArray array = new HighArray(20);
        array.insert(2);
        array.insert(12);
        array.insert(22);
        array.insert(5);
        array.insert(8);
        array.insert(23);
        array.insert(25);
        array.insert(28);
        array.insert(21);
        array.insert(99);
        array.display();
        int searchKey = 22;
        if (array.find(searchKey) == -1) {
            System.out.printf("没有找到元素 %d ", searchKey);

        } else {
            System.out.printf("元素 %d 的位置为 %d  ", searchKey,array.find(searchKey));
        }

        array.delete(22);
        array.delete(8);
        array.display();
    }
}
