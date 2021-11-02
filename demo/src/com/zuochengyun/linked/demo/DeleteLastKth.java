package com.zuochengyun.linked.demo;

import com.zuochengyun.linked.demo.DoubleNode;
public class DeleteLastKth {
    public static void main(String[] args) {
        Node node = new Node(0);
        //为什么在赋值的时候要使用一个cur变量呢？为什么对原来的node变量进行赋值不对呢？
        Node cur = node;
        for (int i = 1; i < 7; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        //System.out.println(node);
        DeleteLastKth deleteLastKth = new DeleteLastKth();
        //com.zuochengyun.linked.demo1.Node lastNode = deleteLastKth.removeLastKth(node, 2);
        //com.zuochengyun.linked.demo1.Node node1 = deleteLastKth.reverseList(node);
        //System.out.println(node1);
        //双向链表
        DoubleNode doubleNode = new DoubleNode(0);
        DoubleNode doublePre = doubleNode;
        DoubleNode doublelast = null;
        for (int i = 1; i < 6; i++) {
            doublePre.next = new DoubleNode(i);
            doublePre.last = doublelast;
            doublelast = doublePre;
            doublePre = doublePre.next;
        }

        /*while (doubleNode != null) {
            System.out.println(doubleNode.value);
            doubleNode = doubleNode.next;
        }*/
        //System.out.println("doubleNode-----" + doubleNode.toString());
        //com.zuochengyun.linked.demo1.DoubleNode doubleNode1 = deleteLastKth.renerseListDoubleList(doubleNode);
        Node doubleNode1 = deleteLastKth.reversePart(node, 1, 4);

        while (doubleNode1 != null) {
            System.out.println("doubleNode1----" + doubleNode1.value);
            doubleNode1 = doubleNode1.next;
        }
    }

    /**
     * 删除单链表的倒数第k个节点
     */
    public Node removeLastKth(Node head, int lastKth) {
        //如果链表为空或者k值小于0直接返回
        if (head == null || lastKth < 1) {
            return head;
        }
        //判断链表的临时节点
        Node cur = head;
        //遍历链表，让链表从头走向尾部，并且让k值减1，然后对k值做判断
        while (cur != null) {
            //每走过一个节点，让k值减1
            lastKth--;
            //链表节点向后移动
            cur = cur.next;
        }
        //判断k的值,如何k值为0，说明链表倒数k节点就是头节点，返回head.next。让head.next做头节点
        if (lastKth == 0) {
            head = head.next;
            return head;
        }
        //如果k小于0，重新从头节点开始走，然后让k值加1，当k等于0时候，停止，将该节点的上一个节点的next指向下一个节点
        //当k等于0时候，此时的节点就是k的上一个节点，让k的下一个节点链接上下下个节点就可以了。
        if (lastKth < 0) {
            cur = head;
            //需要找到要删除节点的前一个节点
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        //为什么返回的head不是cur呢？删除的不是cur吗？
        return head;
    }

    //删除链表的中间节点，如果是偶数，删除中间两个数字的前一个数。
    public Node removeMidNode(Node head) {
        /**
         * 先找到规律，比如每增加两个节点删除的节点需要
         */
        //如果链表为空或者只有一个节点那么不删除直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //如果链表有两个节点那么删除头节点
        if (head.next.next == null) {
            head = head.next;
            return head;
        }

        //如果链表的长度为3，那么删除第二个节点
        Node pre = head;
        Node cur = head.next.next;
        //如果链表的长度每增加2那么删除链表的节点向后移动一位。
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }



    //删除链表a/b处的节点，a/b是一个分数。（具体规则看下书P46）
    public Node removeByRatio(Node head, int a, int b) {
        //需要找到删除的节点，删除的节点是链表的长度n*a/b。然后向上取整的节点。

        //找到链表长度
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        //找到要删除的节点d
        double c = (double) a * n / (double) b;
        int d = (int) Math.ceil(c);

        if (d == 1) {
            //删除头节点
            head = head.next;
        }
        //删除头节点需要找到该节点的上一个节点。比如我要删除的是第2个节点。需要找到第一个节点，那我我应该先--，
        //就找到了要删除节点的上一个节点。
        if (d > 1) {
            cur = head;
            while (--d != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return cur;

    }


    //反转单链表
    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    //反转双向链表
    public DoubleNode renerseListDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    //反转部分单项链表
    public Node reversePart(Node head, int from, int to) {
        //找到需要反转的from节点的前一个节点，以及to节点的下一个节点
        int len = 0;
        Node fPre = null;
        Node tPos = null;
        Node node1 = head;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        //判断需要反转链表是否正确
        if (from > to || from < 1 || to > len) {
            return head;
        }
        //判断是否需要换头，如果fPre为null，则需要换头
        node1 = fPre == null ? head : fPre.next;
        //开始反转
        Node next = null;
        Node node2 = node1.next;
        node1.next = tPos;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        //判断fPre是否为null
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;

    }

    //


}

