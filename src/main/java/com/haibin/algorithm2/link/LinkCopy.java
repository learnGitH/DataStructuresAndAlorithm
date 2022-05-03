package com.haibin.algorithm2.link;

import java.util.HashMap;
import java.util.Stack;

public class LinkCopy {
    public Node2 copyListWithRand1(Node2 head){
        HashMap<Node2,Node2> map = new HashMap<Node2,Node2>();
        Node2 cur = head;
        while(cur != null){
            map.put(cur,new Node2(cur.value));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node2 copyListRand2(Node2 head){
        if (head == null){
            return null;
        }
        Node2 cur = head;
        Node2 next = null;
        //复制并链接每一个节点
        while(cur != null){
            next = cur.next;
            cur.next = new Node2(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node2 curCopy = null;
        //设置复制节点的rand指针
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node2 res = head.next;
        cur = head;
        //拆分
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next: null;
            cur = next;
        }
        return res;
    }

    public Node addLists1(Node head1,Node head2){
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        while(head1 != null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while(head2 != null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }

    public Node addLists2(Node head1,Node head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while(c1 != null || c2 != null){
            n1 = c1 != null ? c1.value : 0;
            n2 = c2 != null ? c2.value : 0;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1  = c1 != null ? c1.next : null;
            c2 = c2 != null ? c2.next : null;
        }
        if (ca == 1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        reverseList(head1);
        reverseList(head2);
        return node;
    }

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
