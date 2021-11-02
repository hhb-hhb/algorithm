package com.zuochengyun.linked.demo;


/**
 * 删除双链表的倒数第k个节点
 */
public class DeleteLastKthTwoLinded {
    public static void main(String[] args) {
        Node1 node1 = new Node1(1);

    }


    public Node1 removeLastKth(Node1 head, int lastkth) {
        if (head == null || lastkth < 1) {
            return head;
        }
        Node1 cur = head;
        while (cur != null) {
            lastkth--;
            cur = cur.next;
        }
        if (lastkth == 0) {
            head = head.next;
            head.last = null;
        }
        if (lastkth < 0) {
            cur = head;
            lastkth++;
            while (lastkth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next.next != null) {
                cur.next.next.last = cur;
            }
            return cur;
        }
        return head;
    }


}

class Node1 {
    public int value;
    public Node1 last;
    public Node1 next;

    public Node1(int data) {
        this.value = data;
    }
}
