package array.sparse;
import java.nio.CharBuffer;
import	java.nio.charset.Charset;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;

/**
 * @author bill-smith liuwb
 * @Package array.sparse
 * @Date 2020/1/2 22:03
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class InterchangeBetween2DArrayAndSparseArray {

    public static final int ROW = 11;
    public static final int COL = 11;
    /**
     * 1 for black pawns
     */
    public static final int BLACK = 1;
    /**
     * 2 means white pawn
     */
    public static final int WHITE = 2;

    public static void main(String[] args) {
//        1、create_raw_array（11*11），used_to_represent_a_chessboard，use_1_for_black_pawns，_2-means-white-pawn
        int[][] checkerboard = new int[ROW][COL];
        checkerboard[2][2]= BLACK;
        checkerboard[2][3]= WHITE;

        System.out.println("print_the_contents_of_the_original_array");
        printArray(checkerboard);

//        2、create_a_sparse_array，initialize_the_first_line（Represents the size of the original two-dimensional array and the number of valid values，row=11,col=11,value=2)，convert_raw_array_to_sparse_array
        int[][] sparseArray = getInts(checkerboard);
        //endregion

        //region Turn a two-dimensional array into a sparse array
        sparseToArray(checkerboard, sparseArray);
        //endregion

        System.out.println("print sparse array");
        //region print sparse array
        printArray(sparseArray);
        //endregion

//        2.1 将稀疏数组的内容持久化到文件中
//        写入到文件中（创建输出流）
        for (int[] rowData : sparseArray) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
                Charset charsetCN = Charset.forName("UTF-8");
                CharsetEncoder charsetEncoder = charsetCN.newEncoder();
                for (int data : rowData) {
                    charsetEncoder.encode(CharBuffer.allocate(data));
                    fileOutputStream.write(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        2.2 将文件中的内容，恢复到稀疏数组中

//        3.Restore the sparse array to a two-dimensional array
        //region Restore the sparse array to a two-dimensional array
        int row_of_sparse_array = sparseArray[0][0];
        int col_of_sparse_array = sparseArray[0][1];
        int[][] restoredFromSparseArray = new int[row_of_sparse_array][col_of_sparse_array];
        revertToATwoDimensionalArray(sparseArray, restoredFromSparseArray);

        System.out.println("Print the values ​​of the recovered array");
        //endregion
        printArray(restoredFromSparseArray);
    }

    private static int[][] getInts(int[][] checkerboard) {
        int theOriginalTwoSetsOfNonZeroValues = getSum(checkerboard);
        System.out.println(theOriginalTwoSetsOfNonZeroValues);
        //region  initialize_the_first_line
        int[][] sparseArray = new int[theOriginalTwoSetsOfNonZeroValues + 1][3];
        int theValueOfTheFirstRowOfTheSparseArray = checkerboard.length;
        sparseArray[0][0]= theValueOfTheFirstRowOfTheSparseArray;
        int sparseArrayFirstRowAndColumnValues = checkerboard[0].length;
        sparseArray[0][1]= sparseArrayFirstRowAndColumnValues;
        sparseArray[0][2]=theOriginalTwoSetsOfNonZeroValues;
        return sparseArray;
    }

    private static void revertToATwoDimensionalArray(int[][] sparseArray, int[][] restoredFromSparseArray) {
        for (int i = 1; i < sparseArray.length; i++) {
            int row_of_orign_array = sparseArray[i][0];
            int col_of_orign_array = sparseArray[i][1];
            int value_of_orign_array = sparseArray[i][2];
            restoredFromSparseArray[row_of_orign_array][col_of_orign_array] = value_of_orign_array;
        }
    }

    private static void sparseToArray(int[][] checkerboard, int[][] sparseArray) {
        int count=0;
        for (int i = 0; i < checkerboard.length; i++) {
            for (int j = 0; j < checkerboard[i].length; j++) {
                if (checkerboard[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = checkerboard[i][j];
                }
            }
        }
    }

    private static int getSum(int[][] checkerboard) {
        int sum =0;
        for (int i = 0; i < checkerboard.length; i++) {
            for (int j = 0; j < checkerboard[i].length; j++) {
                if (checkerboard[i][j] != 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void printArray(int[][] checkerboard) {
        for (int[] rowData : checkerboard) {
            for (int data : rowData) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
