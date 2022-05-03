package com.haibin.algorithm2.link;

import java.util.Stack;

public class LinkEqual {

    public void printCommonPart(Node head1,Node head2){
        System.out.println("Common Part: ");
        while(head1 != null && head2 != null){
            if (head1.value < head2.value){
                head1 = head1.next;
            }else if (head1.value > head2.value){
                head2 = head2.next;
            }else {
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public Node removeLastKthNode(Node head,int lastKth){
        if (head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0){
            head = head.next;
        }
        if (lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public Node removeMidNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        return head;
    }

    public Node removeByRatio(Node head,int a,int b){
        if (a < 1 || a > b){
            return head;
        }
        int n = 0;
        Node cur = head;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        n = (int)Math.ceil(((double)(a*n))/(double)b);
        if (n == 1){
            head = head.next;
        }
        if (n > 1){
            cur = head;
            while(--n != 1){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
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

    public static Node reversePart(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while(node1 != null){
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len){
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while(node2 != tPos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }

    /**
     * 反转单项列表
     */
    public static Node reserseList(Node head, int from , int to)
    {
        int len = 0;
        Node node1 = head;
        Node tPre = null;
        Node tPos = null;
// 找到第from-1个节点fPre和第to+1个节点tPos
        while (node1 != null)
        {
            len ++; //链表的索引
            tPre = len == from - 1 ? node1: tPre;
            tPos = len == to + 1 ? node1: tPos;
            node1 = node1.next;
        }

        if(from > to || from < 1 || to >len)
        {
            return null;
        }

        //node1为反转后的链表
        node1 = tPre == null ? head : tPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos)
        {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }

        if(tPre != null)
        {
            tPre.next = node1;
            return tPre;
        }

        return node1;
    }

    public Node josepusKill(Node head,int m){
        if (head == null || head.next == head || m < 1){
            return head;
        }
        Node last = head;
        while(last.next != head){
            last = last.next;
        }
        int count = 0;
        while(head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else{
                last  = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public boolean isPalindromel(Node head){
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head != null){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome2(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node right = head.next;
        Node cur = head;
        while(cur.next != null && cur.next.next != null){
            right  = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<Node>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if (head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1 = head;
        Node n2 = head;
        while(n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = n1.next;
        n1.next = null;
        Node n3 = null;
        while(n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1;
        n2 = head;
        boolean res = true;
        while(n1 != null && n2 != null){
            if (n1.value != n2.value){
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while(n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }

    public static Node listPartition1(Node head,int pivot){
        if (head == null){
            return head;
        }
        Node cur = head;
        int i = 0;
        while(cur != null){
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(i = 0; i != nodeArr.length; i++){
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr,pivot);
        for (i = 1; i != nodeArr.length;i++){
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    public static void arrPartition(Node[] nodeArr,int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while(index != big){
            if (nodeArr[index].value < pivot){
                swap(nodeArr,++small,index++);
            }else if(nodeArr[index].value == pivot){
                index++;
            }else{
                swap(nodeArr,--big,index);
            }


        }
    }

    public static void swap(Node[] nodeArr, int a, int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

    public static Node listPartition2(Node head,int pivot){
        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = null;
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }
            }else{
                if (bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        //小的和相等的重新连接
        if (sT != null){
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        //所有的重新连接
        if (eT != null){
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void main(String[] args){
        Node node1 = new Node(9);
        Node node2 = new Node(0);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node result = listPartition2(node1, 3);
        System.out.println("");
    }

}
