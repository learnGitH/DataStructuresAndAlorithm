package com.haibin.algorithm2.stack;

import java.util.Stack;

public class StackSort {

    /**
     * 一个栈中元素的类型为整型，现在想将该栈从顶到低按大到小的顺序排序，只允许申请一个栈。除此之外，可以申请新的变量，
     * 但不能申请额外的数据结构。如何完成排序？
     * @param stack
     */
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }

}
