package com.stage1.part4.task1;

import java.io.IOException;

public class ExceptionPreventTest {

    public static void main(String[] args) {

        //算术异常
        int ia = 10;
        int ib = 0;
        if( 0 != ib) {
            System.out.println(ia / ib);
        }

        //下标越界异常
        int[] arr = new int[5];
        int pos = 5;
        if(pos>=0 && pos<=4) {
            System.out.println(arr[pos]);
        }

        //空指针异常
        String str = null;
        if(str != null) {
            System.out.println(str.length());
        }

        //类型转换异常
        Exception ex = new Exception();
        if(ex instanceof IOException) {
            IOException ie = (IOException) ex;
        }

        //数字格式异常
        String str2 = "123a";
        if(str2.matches("\\d+")) {
            System.out.println(Integer.parseInt(str2));
        }

        System.out.println("over!");
    }
}
