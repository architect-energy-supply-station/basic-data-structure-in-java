package array.queue;

/**
 * @author bill-smith liuwb
 * @Package array.queue
 * @Date 2020/1/6 15:21
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(20);
//        type[] variableName = new type[value];
        ArrayQueue[] arrayQueues = new ArrayQueue[3];
        int[] arr = new int[3];

        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        arrayQueue.push(22);
        arrayQueue.push(11);
        arrayQueue.push(33);
        arrayQueue.show();
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        arrayQueue.show();
    }
}
