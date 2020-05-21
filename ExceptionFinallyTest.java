package com.stage1.part4.task1;

public class ExceptionFinallyTest {

    /**
     *笔试考点
     */
    public static int test(){

        try{
            int[] arr = new int[5];
            System.out.println(arr[5]);
            return 0;
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            return 1;
        }finally{
            return 2;
        }
    }

    public static void main(String[] args) {

        try{
            int ia = 10;
            int ib = 0;
                System.out.println(ia / ib);
        } catch(ArithmeticException e){
            e.printStackTrace();
        } finally{  //无论有无exceptions都会打印
            System.out.println("end");
        }

        System.out.println("Over");

        System.out.println("------------------");

        int test = test();
        System.out.println("test result: " + test);
    }
}
