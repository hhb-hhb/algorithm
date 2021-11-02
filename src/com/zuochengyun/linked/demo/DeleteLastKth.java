package com.zuochengyun.linked.demo;


import java.util.LinkedList;

public class DeleteLastKth {
    public static void main(String[] args) {
        Node node = new Node(0);
        //为什么在赋值的时候要使用一个cur变量呢？为什么对原来的node变量进行赋值不对呢？
        Node cur = node;
        for (int i = 1; i < 3; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        //System.out.println(node);
        DeleteLastKth deleteLastKth = new DeleteLastKth();
        //Node lastNode = deleteLastKth.removeLastKth(node, 2);
        //Node node1 = deleteLastKth.reverseList(node);
        //System.out.println(node1);
        //双向链表
        DoubleNode doubleNode = new DoubleNode(0);
        DoubleNode doublePre = doubleNode;
        DoubleNode doublelast = null;
        for (int i = 1; i < 4; i++) {
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
        DoubleNode doubleNode1 = deleteLastKth.renerseListDoubleList(doubleNode);

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
    /*public Double reversePart(Node head, int from, int to) {
        //需要找到from前一个节点和to的后一个节点再进行链接
        Node fPre = null;
        Node tPos = null;
        int len = 0;
        Node node1 = head;
        while (head != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        //需要判断fPre是否为空，如果为空则反转包含头节点，如果不为空就正常反转中间的部分节点
        node1 = fPre == null ? head : node1.next;

    }*/


}

class Node {
    public Node next;
    public int value;

    public Node() {
    }

    public Node(int data) {
        this.value = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}

class DoubleNode {
    public int value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(int data) {
        this.value = data;
    }

    /*@Override
    public String toString() {
        return "DoubleNode{" +
                "value=" + value +
                ", last=" + last +
                ", next=" + next +
                '}';
    }*/
}
