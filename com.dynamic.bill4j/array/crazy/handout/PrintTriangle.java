package array.crazy.handout;

/**
 * Created by Administrator on 2020/1/11.
 * commpany:
 * version:
 */
public class PrintTriangle {
    public static void main(String[] args) {
        for (int i = 1; i < 5; i++) {
            for (int m = 4-i; m >0; m--) {
                System.out.printf(" ");
            }
            for (int j = 1 ; j <=2*i-1 ; j++) {
                System.out.printf("*");
            }
            System.out.println("");
        }
    }
}
