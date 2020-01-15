package array.crazy.handout;

/**
 * @author bill-smith liuwb
 * @Package array.crazy.handout
 * @Date 2020/1/7 15:15
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class NinetyNineMultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == j) {
                    System.out.printf("%d%s%d %s %d\t", i, "*", j, "=", i * j);
                } else {
                    System.out.printf("%d%s%d %s %d%s\t", i, "*", j, "=", i * j,",");
                }
            }
            System.out.println();
        }
    }
}
