package array.crazy.handout;

/**
 * @description：
 * @author：by Administrator
 * @version:v1.0
 * @date：2020/1/15
 */
public class YangHuiTriangle {
    public static void main(String[] args) {
    //    第一行和最后一行永远为1
        int[][] yang_hui_triangle = new int[10][10];
        for (int i = 1; i < yang_hui_triangle.length; i++) {
            // 第一行和第二行

            if (i <= 2) {
                yang_hui_triangle[i][1] = 1;
                yang_hui_triangle[i][i] = 1;
            } else {
                for (int j = 1 ; j <=i  ; j++) {
                    //    从第三行以后，除去每一行的第一个数和最后一个数，其余各数均为前一行同列数据及其前一行同列前一个数据的值的和
                    yang_hui_triangle[i][j] = yang_hui_triangle[i - 1][j] + yang_hui_triangle[i - 1][j - 1];
                }
            }
        }
        for (int[] row : yang_hui_triangle) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }
}
