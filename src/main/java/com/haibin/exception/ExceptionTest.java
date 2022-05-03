package com.haibin.exception;

import java.io.FileInputStream;

public class ExceptionTest {

    public static void main(String[] args){
        try{
            System.out.println(days());
        } catch (Exception e){
            System.out.println(e.getMessage());    //这里捕获到finally抛出的异常
        }
    }

    private static int days() throws Exception{
        try{
            int a = 90/0;
            return 1;
        }catch (ArithmeticException  e){
            throw  new Exception("我将被忽略，因为下面的finally中抛出了新的异常");
        }finally {
            throw new Exception("我是finaly中的Exception");
        }
    }

    private static int enterCount(){
        try{
            return 10;
        }finally {
            return 20;
        }
    }

}
