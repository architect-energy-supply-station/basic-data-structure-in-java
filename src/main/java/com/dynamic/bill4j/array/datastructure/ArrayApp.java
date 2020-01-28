package com.dynamic.bill4j.array.datastructure;

/**
 * @author bill-smith liuwb
 * @Package com.dynamic.bill4j.array
 * @Date 2019/12/19 17:36
 * @Version v1.0
 * @Copyright @ 2019-2020用友网络科技股份有限公司
 * @Email 18232480449@163.com
 * @Contract https://github.com/BillCindy
 * @Blog https://blog.csdn.net/t131452n?viewmode=contents
 */
public class ArrayApp {
    public static void main(String[] args) {

        //define a com.dynamic.bill4j.array with size 10 (sports man numbers)
        long[] arr = new long[100];
        long searchKey;
        int j;
        int lengthOfArray;
        arr[0]=00;
        arr[1]=11;
        arr[2]=22;
        arr[3]=33;
        arr[4]=44;
        arr[5]=55;
        arr[6]=66;
        arr[7]=77;
        arr[8]=88;
        arr[9]=99;
        lengthOfArray=10;
        //display items



        for (j = 0;  j< lengthOfArray; j++) {
            System.out.println("arr item [" + j + "] =" + arr[j]+",");
        }
        //search key 66 (no dumps)
        searchKey=10;
        System.out.println("start to search key with key "+searchKey+" ……");
        for ( j = 0; j < lengthOfArray; j++) {
            if (arr[j] == searchKey) {
                System.out.println("Found key ["+searchKey+"]" + " located in index ["+ j+ "] of the arr");
                break;
            }
        }
        if ( j == lengthOfArray) {
            System.out.println("key “"+ searchKey +"” was not found……");
        }
        //delete key 55
        searchKey=55;
        for (j = 0;  j< lengthOfArray; j++) {
            if (arr[j]==searchKey) {
                System.out.println("j is "+j);
                break;
            }
        }

        int testPlusPlus=5;
        for (int k = j; k <lengthOfArray; k++) {
            //move higher to lower
            arr[k]=arr[k+1];
        }
        lengthOfArray--;
        //display items
        for (j=0; j < lengthOfArray+1; j++) {
            System.out.println("after delete the arr length ="+ arr.length+", arr["+j+"] value is " + arr[j]);
        }
    }



}
