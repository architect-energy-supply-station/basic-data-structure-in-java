package array.sparse;

/**
 * @author bill-smith liuwb
 * @Package array.sparse
 * @Date 2020/1/2 18:42
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class TwoDimensionalArraySparseArrayConversion {

    /**
     * 标识黑色棋子儿
     */
    public static final int BLACK = 1;
    /**
     * 表示蓝色棋子儿
     */
    public static final int BLUE = 2;
    public static final int ROW = 6;
    public static final int COL = 8;
    public static final int ROW_OF_SPARSE_ARRAY = 0;
    public static final int COL_OF_SPARSE_ARRAY = 1;
    public static final int VALUE_OF_SPARE_ARRAY = 2;

    public static void main(String[] args) {
//        1、创建原始二维数组(6*8)，用来标识棋盘
        int[] [] twoDimensionalArr= new int[ROW][COL];
//        2、初始化二维数组，用1标识黑色子儿，2标识蓝色子儿
        twoDimensionalArr[1][2] = BLACK;
        twoDimensionalArr[3][3] = BLUE;

//        3、格式化打印数组（用制表符分隔每个数组元素，并换行打印
        System.out.println("output_raw_array");
        printArrary(twoDimensionalArr);

        /**
         * 转稀疏数组
         */
//        1、创建一个新的数组，并初始化第一行的数据
//        sum的值，来自于原始数组的遍历(如果，二维数组的值不为零，则加一）
        int sum = getSum(twoDimensionalArr);
        int[][] sparseArray = getInts(twoDimensionalArr, sum);


//        2、遍历原始数组，获取数据，并赋值给稀疏数组进行存储
        _2dArrayToSparseArray(twoDimensionalArr, sparseArray);
//        3、打印稀疏数组的内容
        System.out.println("contents_of_a_sparse_array");
        printArrary(sparseArray);

        /**
         * convert_from_sparse_array_to_raw_2d_array
         */
//        1、创建新的数组，并初始化
        int rowOfConvertedFromSparseArray = sparseArray[0][0];
        int colOfConvertedFromSparseArray = sparseArray[0][1];
        int[][] convertedFromSparseArray=new int[rowOfConvertedFromSparseArray][colOfConvertedFromSparseArray];
//        2、遍历稀疏数组的内容，并对原始二维数组进行赋值
        restoreArrayFromSpareArray(sparseArray, convertedFromSparseArray);
//        3、打印复原的二维数组
        System.out.println("print_the_restored_two_dimensional_array");
        printArrary(convertedFromSparseArray);
    }

    private static int getSum(int[][] twoDimensionalArr) {
        int sum = 0;
        for (int i = 0; i < twoDimensionalArr.length; i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {
                if (twoDimensionalArr[i][j] != 0) {
                    sum++;

                }
            }
        }
        return sum;
    }

    private static void restoreArrayFromSpareArray(int[][] sparseArray, int[][] convertedFromSparseArray) {
        for (int i = 1; i < sparseArray.length; i++) {
            convertedFromSparseArray[sparseArray[i][ROW_OF_SPARSE_ARRAY]][sparseArray[i][COL_OF_SPARSE_ARRAY]] = sparseArray[i][VALUE_OF_SPARE_ARRAY];
        }
    }

    private static void _2dArrayToSparseArray(int[][] twoDimensionalArr, int[][] sparseArray) {
        int count=0;
        for (int i = 0; i < twoDimensionalArr.length; i++) {
            for (int j = 0; j < twoDimensionalArr[i].length; j++) {

                if (twoDimensionalArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = twoDimensionalArr[i][j];
                }
            }
        }
    }

    private static int[][] getInts(int[][] twoDimensionalArr, int sum) {
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = twoDimensionalArr.length;
        sparseArray[0][1] = twoDimensionalArr[0].length;
        sparseArray[0][2] = sum;
        return sparseArray;
    }

    private static void printArrary(int[][] convertedFromSparseArray) {
        for (int[] dataRow : convertedFromSparseArray) {
            for (int data : dataRow) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
