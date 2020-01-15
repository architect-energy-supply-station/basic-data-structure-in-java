package array.crazy.handout;

/**
 * @author bill-smith liuwb
 * @Package array.crazy.handout
 * @Date 2020/1/7 15:23
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class PrintYangHuiTriangle {
    public static void main(String[] args) {
        for (int i = 1; i < 5 ; i++) {
            for (int m = 4-i; m > 0; m--) {
                System.out.printf(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
