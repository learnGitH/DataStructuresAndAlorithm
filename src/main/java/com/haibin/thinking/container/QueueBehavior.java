package com.haibin.thinking.container;

import com.haibin.thinking.generic.Generator;
import com.haibin.thinking.util.Print;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueBehavior {
    private static int count = 10;
    static <T> void test(Queue<T>queue, Generator<T> gen){
        for (int i = 0; i < count; i++){
            queue.offer(gen.next());
        }
        while(queue.peek() != null){
            Print.printnb(queue.remove() + " ");
        }
        Print.print();
    }
    static class  Gen implements Generator<String>{
        String[] s = ("one two three four five six seven eight nine ten").split(" ");
        int i;
        public String next(){
            return s[i++];
        }
    }

    public static void main(String[] args){
        test(new LinkedList<String>(),new Gen());
        test(new PriorityQueue<String>(),new Gen());
        test(new ArrayBlockingQueue<String>(count),new Gen());
        test(new ConcurrentLinkedDeque<String>(),new Gen());
        test(new LinkedBlockingQueue<String>(),new Gen());
        test(new PriorityBlockingQueue<String>(),new Gen());
    }
}
