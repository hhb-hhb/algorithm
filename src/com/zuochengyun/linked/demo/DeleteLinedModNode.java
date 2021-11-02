package com.zuochengyun.linked.demo;

/**
 * 删除链表的中间节点，如果是偶数，删除中间两个数字的前一个数。
 */
public class DeleteLinedModNode {

    public Node3 removeMidNode(Node3 head) {
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
        Node3 pre = head;
        Node3 cur = head.next.next;
        //如果链表的长度每增加2那么删除链表的节点向后移动一位。
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    //删除链表a/b处的节点，a/b是一个分数。（具体规则看下书P46）
    public Node3 removeByRatio(Node3 head, int a, int b) {
        //需要找到删除的节点，删除的节点是链表的长度n*a/b。然后向上取整的节点。

        //找到链表长度
        int n = 0;
        Node3 cur = head;
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

}

class Node3 {
    public Node3 next;
    public int value;

    public Node3(int data) {
        this.value = data;
    }
}
