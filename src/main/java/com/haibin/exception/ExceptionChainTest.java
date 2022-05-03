package com.haibin.exception;

import sun.misc.Cache;

import java.io.IOException;

public class ExceptionChainTest{

    public static void main(String[] args){
        try{
            ioTest();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * ioTest方法
     * @throws ClassNotFoundException 该方法可能产生ClassNotFoundException异常
     */
    private static void ioTest() throws ClassNotFoundException{
        try{
            if (true){
                throw new IOException();
            }
        }catch(IOException e){
            //抛出新异常，构造异常链
            throw new ClassNotFoundException("IO流错误",e);
        }
    }

}
