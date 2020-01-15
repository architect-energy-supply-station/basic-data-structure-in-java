package array.crazy.handout;

import java.util.Arrays;

/**
 * @author bill-smith liuwb
 * @Package array.crazy.handout
 * @Date 2020/1/5 16:35
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class BasicTraining {
    public static void main(String[] args) {
//       申明三个数组
//        静态定义（初始化）
        int[] arr = {
                1, 2, 3, 68, 22, 21
        };
        int[] arr1 = {
                1, 2, 3, 68, 22, 21
        };
        int[] arrParallelSort = {
                1, 2, 3, 68, 22, 21,-1,33334,431,22,9,-0,0
        };
        int[] a = new int[3];
        int[] c = new int[3];
        Arrays.fill(c, 3);

        System.out.println(Arrays.toString(c));
        Arrays.setAll(c, operand -> operand * 5);
        System.out.println(Arrays.toString(c));
        Arrays.parallelSetAll(c, operand -> operand * 5);
        System.out.println(Arrays.toString(c));

        Arrays.parallelSort(arrParallelSort);
        System.out.println(Arrays.toString(arrParallelSort));
        Arrays.parallelPrefix(arr1, (left, right) -> left * right);
        System.out.println(Arrays.toString(arr1));

        System.out.println(Arrays.equals(arr, arr1));
//        assert  Arrays.equals(arr, arr1) == true;
        String[] stringsArr = {"bill", "cindy", "alice"};
//        动态定义（初始化）
        int[] b = new int[3];
        int[][] arr2 = new int[3][];
        arr2[0] = new int[4];
        arr2[0][0]=1;
        arr2[0][1]=2;
        arr2[0][3]=4;
        arr2[1] = new int[2];

//        操作：增、改、查看
        for (int data : arr) {
            System.out.printf("%d\t",data);
        }
        System.out.println();
        System.out.println("打印字符数组");
        for (int i = 0; i < stringsArr.length; i++) {
            System.out.printf("%s\t",stringsArr[i]);
        }
        System.out.println();
        System.out.println("打印二维数组");
/*
        for (int[] rowData : arr2) {
            for (int data : rowData) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
*/
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        for (int i = 0; i < arr2[0].length; i++) {
            System.out.println(arr2[0][i]);
        }
        for (int i = 0; i < arr2[1].length; i++) {
            System.out.println(arr2[1][i]);
        }
//        Arrays工具类的使用

//        对数组arr进行排序
        Arrays.sort(arr);
        for (int data : arr) {
            System.out.printf("%d\t",data);        }
        int searchResult = Arrays.binarySearch(arr, 33);
//        每个元素依次相等才会打印true
        System.out.println(Arrays.equals(arr1, arr));
//        如果不包含，则返回负数
        assert searchResult < 0;
        arr2[2] = new int[3];
        Arrays.fill(arr2[2], 3);
        for (int data : arr2[2]) {
            System.out.printf("%d\t",data);        }


        Arrays.fill(a, 1);
        Arrays.fill(b, 1);
        System.out.println();
        for (int data : a) {
            System.out.printf("%d\t",data);        }
        System.out.println();
        for (int data : b) {
            System.out.printf("%d\t",data);        }
        System.out.println(Arrays.equals(a, b));
        int[] copyOfb = Arrays.copyOf(b, 3);
        assert Arrays.equals(b, copyOfb) == true;
        System.out.println();
        for (int data : copyOfb) {
            System.out.printf("%d\t", data);        }
        System.out.println(Arrays.toString(b));

    }


}
