package com.haibin.jvm;

import sun.security.smartcardio.SunPCSC;

public class Dispatch {

    static class QQ{}

    static class QiHu360{}

    static class Father{
        public void hardChoice(QQ qq){
            System.out.println("Father choice QQ");
        }
        public void hardChoice(QiHu360 qiHu360){
            System.out.println("Father choice 360!");
        }
    }

    static class Son extends Father{

        @Override
        public void hardChoice(QQ qq) {
            System.out.println("Son choice QQ!");
        }

        @Override
        public void hardChoice(QiHu360 qiHu360) {
            System.out.println("Son choice 360!");
        }
    }

    public static void main(String[] args){
        Father father = new Father();
        Father son = new Son();

        father.hardChoice(new QQ());
        son.hardChoice(new QiHu360());
    }

}
