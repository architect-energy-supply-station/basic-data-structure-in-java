package com.dynamic.bill4j.array.sparse;

import java.io.*;

/**
 * @author bill-smith liuwb
 * @Package com.dynamic.bill4j.array.sparse
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

    public static void main(String[] args) throws IOException {
//        1、create_raw_array（11*11），used_to_represent_a_chessboard，use_1_for_black_pawns，_2-means-white-pawn
        int[][] checkerboard = new int[ROW][COL];
        checkerboard[2][2]= BLACK;
        checkerboard[2][3]= WHITE;

        System.out.println("print_the_contents_of_the_original_array");
        printArray(checkerboard);

//        2、create_a_sparse_array，initialize_the_first_line（Represents the size of the original two-dimensional com.dynamic.bill4j.array and the number of valid values，row=11,col=11,value=2)，convert_raw_array_to_sparse_array
        int[][] sparseArray = getInts(checkerboard);
        //endregion

        //region Turn a two-dimensional com.dynamic.bill4j.array into a sparse com.dynamic.bill4j.array
        sparseToArray(checkerboard, sparseArray);
        //endregion

        System.out.println("print sparse com.dynamic.bill4j.array");
        //region print sparse com.dynamic.bill4j.array
        printArray(sparseArray);
        //endregion

//        2.1 将稀疏数组的内容持久化到文件中
//        写入到文件中（创建输出流）
        persistToFile(sparseArray,"");


//        2.2 将文件中的内容，恢复到稀疏数组中
//            2.2.1 创建字符流读取对象，读取本文中的字符内容
        int[][] sparseArrayRecoveredFromFile = restoreFromFileToSparseArray();
        System.out.println("打印从文件中恢复的稀疏数组");
        printArray(sparseArrayRecoveredFromFile);




//        3.Restore the sparse com.dynamic.bill4j.array to a two-dimensional com.dynamic.bill4j.array
        //region Restore the sparse com.dynamic.bill4j.array to a two-dimensional com.dynamic.bill4j.array
        int row_of_sparse_array = sparseArrayRecoveredFromFile[0][0];
        int col_of_sparse_array = sparseArrayRecoveredFromFile[0][1];
        int[][] restoredFromSparseArray = new int[row_of_sparse_array][col_of_sparse_array];
        revertToATwoDimensionalArray(sparseArrayRecoveredFromFile, restoredFromSparseArray);

        System.out.println("Print the values ​​of the recovered com.dynamic.bill4j.array");
        //endregion
        printArray(restoredFromSparseArray);
    }

    /**
     * 将数组从文件中恢复
     * @return
     * @throws IOException
     */
    private static int[][] restoreFromFileToSparseArray() throws IOException {
        FileReader fileReader = new FileReader("rowData.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        一次读一行
        String line;
        int rowCount=0;
//      获取文件中的行数，去掉空行后的有效数据行（无法通过Files工具类直接做到）
//        int rowSize2= (int) Files.lines(Paths.get("E:\\team3.0-training\\basic-data-structure-in-java\\rowdata.txt")).count();
        int rowSize = getRowSizeByReadLine();
        //            2.2.3 创建数组，将int类型数据恢复成稀疏数组
        int[][] sparseArrayRecoveredFromFile = new int[rowSize][3];
        while ((line=bufferedReader.readLine())!=null){
//            2.2.2 将每一行读取出来的内容，通过制表符进行分割，得到数组的内容，并将字符串类型数据转为int类型数据
//        跳过文件中的空行只读取有效行的数据，即仅当不为空行时，才进行行数加一
            String[] temp = line.split("\t");
            if (!"".equals(line)) {
                for (int i = 0; i < temp.length; i++) {
                    sparseArrayRecoveredFromFile[rowCount][i] = Integer.parseInt(temp[i]);
                }
                rowCount++;
            }
        }
        return sparseArrayRecoveredFromFile;
    }


    /**
     * 获取全部行数（含空行）参考：https://www.cnblogs.com/hujunzheng/p/4072518.html
     * @return
     * @throws IOException
     */
    private static int getRowSize() throws IOException {
        File file=new File("rowData.txt");
        int rowSize=0;
        if(file.exists()) {
            long fileLength = file.length();
            LineNumberReader lineNumberReader =new LineNumberReader(new FileReader(file));
            lineNumberReader.skip(fileLength);
            rowSize=lineNumberReader.getLineNumber();
            lineNumberReader.close();
        }
        return rowSize;
    }

    /**
     * 获取文件中有效内容的行数（不含空行），参考文章：https://blog.csdn.net/qq_40298231/article/details/99680229
     * @return
     * @throws IOException
     */
    private static int getRowSizeByReadLine() throws IOException {
        File file=new File("rowData.txt");
        int rowSize=0;
        if(file.exists()) {
            FileReader fr=new FileReader(file);
            String lines;
                    LineNumberReader lnr = new LineNumberReader(fr);
            while((lines=lnr.readLine())!=null ) {
                if (!"".equals(lines)) {
                    rowSize+=1;
                }
            }

        }
        return rowSize;
    }


    /**
     * 将数组存储到文件的默认方法
     * @param sparseArray 需要存储的数组
     * @throws IOException
     */
    private static void persistToFile(int[][] sparseArray) throws IOException {
        FileWriter fw = null;
        fw = new FileWriter("rowData.txt");
        writeArrayContentsToFile(sparseArray, fw);
    }

    /**
     * 将数组内容写入到文件中
     * @param sparseArray 需要被写入的数组
     * @param fw 所使用的字符输出流
     * @throws IOException
     */
    private static void writeArrayContentsToFile(int[][] sparseArray, FileWriter fw) throws IOException {
        try {
            for (int[] rowData : sparseArray) {
                for (int data : rowData) {
                    fw.write(String.valueOf(data));
                    fw.write("\t");
                }
                fw.write("\n\r");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }
    /**
     * 持久化到文件中，可使用自定义的输出流
     * @param sparseArray 被存储的数组对象
     * @param path 文件的存放路径
     * @throws IOException
     */
    private static void persistToFile(int[][] sparseArray,String path) throws IOException {
        if ("".equals(path)) {
            persistToFile(sparseArray);
            return;
        }
        FileWriter fw = null;
        fw = new FileWriter(path);
        writeArrayContentsToFile(sparseArray, fw);
    }

    /**
     * 创建稀疏数组，并构造稀疏数组的第一列数据
     * @param checkerboard
     * @return
     */
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

    /**
     * 将稀疏数组转为二维数组
     * @param sparseArray 需要转换的稀疏数组
     * @param restoredFromSparseArray 目标对象，要恢复成的二维数组
     */
    private static void revertToATwoDimensionalArray(int[][] sparseArray, int[][] restoredFromSparseArray) {
        for (int i = 1; i < sparseArray.length; i++) {
            int row_of_orign_array = sparseArray[i][0];
            int col_of_orign_array = sparseArray[i][1];
            int value_of_orign_array = sparseArray[i][2];
            restoredFromSparseArray[row_of_orign_array][col_of_orign_array] = value_of_orign_array;
        }
    }

    /**
     * 将二维数组转为稀疏数组
     * @param checkerboard 源对象，用二维数组表示的棋盘
     * @param sparseArray 目标对象，一个稀疏数组
     */
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

    /**
     * 获取原数组的有效存储数据的个数
     * @param checkerboard 用二维数组表示的棋盘
     * @return 原数组的有效存储数据的个数
     */
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

    /**
     * 打印数组对象
     * @param checkerboard 传入的任意二维数组对象
     */
    private static void printArray(int[][] checkerboard) {
        for (int[] rowData : checkerboard) {
            for (int data : rowData) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
