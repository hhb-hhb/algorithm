package com.zuochengyun.linked.demo;

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
        return "com.zuochengyun.linked.demo1.Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}

