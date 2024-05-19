package com.sgenlecroyant.app.linkedlists;

public class AppLinkedList<T> {

    private LinkedListNode head;
    private LinkedListNode tail;
    private int count;

    public AppLinkedList(){

    }
    public AppLinkedList(T nodeValue) {
        this.head = this.tail = new LinkedListNode(nodeValue);
        this.count++;
    }

    public T getHead() {
        return head != null ? head.nodeValue : null;
    }

    public T getTail() {
        return tail != null ? tail.nodeValue : null;
    }

    public boolean append(T nodeValue){
        LinkedListNode newNode = new LinkedListNode(nodeValue);
        if (this.head == null){
            this.head = this.tail = newNode;
            return true;
        }

        this.tail.next = newNode;
        this.tail = newNode;
        this.count++;
        return true;
    }

    public boolean prepend(T nodeValue){
        LinkedListNode newNode = new LinkedListNode(nodeValue);
        if (this.head == null && this.tail == null){
            this.head = this.tail = newNode;
            return true;
        }

        newNode.next = this.head;
        this.head = newNode;
        this.count++;
        return true;
    }

    public void print(){

        LinkedListNode currentNode = this.head;

        while (currentNode != null){
            System.out.print(" " +currentNode.nodeValue+" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public boolean addAt(int index, T value){
        if (index < 0 || index > this.count){
            throw new UnsupportedOperationException("invalid target index");
        }
        if (index == 0){
            this.prepend(value);
            return true;
        }

        if (index == this.count){
            this.append(value);
            return true;
        }
        LinkedListNode newNode = new LinkedListNode(value);
        LinkedListNode leaderNode = this.grabLeaderNode(index - 1);
        newNode.next = leaderNode.next;
        leaderNode.next = newNode;
        this.count++;
        return true;
    }

    private LinkedListNode grabLeaderNode(int index){
        int count = 0;

        LinkedListNode currentNode = this.head;
        while (count != index){
            currentNode = currentNode.next;
            count++;
        }
        return currentNode;
    }

    public boolean removeFirst(){

        if (this.head == null){
            throw new UnsupportedOperationException("no item to remove");
        }

        if (this.head.next == null){
            this.head = this.tail = null;
            return true;
        }

        this.head = this.head.next;
        this.count--;
        return true;
    }

    public boolean removeLast(){
        if (this.head == null){
            throw new UnsupportedOperationException("no item to remove");
        }

        if (this.head.next == null){
            this.head = this.tail = null;
            return true;
        }

        LinkedListNode leaderNode = this.grabLeaderNode(this.count-1);
        leaderNode.next = null;
        this.tail = leaderNode;
        return true;
    }
    public boolean removeAt(int index){
        if (index < 0 || index > this.count){
            throw new UnsupportedOperationException("Invalid target index");
        }
        if (this.head == null){
            throw new UnsupportedOperationException("No item to remove");
        }

        if (index == 0){
            this.removeFirst();
            return true;
        }
        if (this.head.next == null){
            this.removeFirst();
            return true;
        }

        if (index == this.count){
            this.removeLast();
            return true;
        }
        LinkedListNode leaderNode = this.grabLeaderNode(index - 1);
        LinkedListNode target = leaderNode.next;
        leaderNode.next = target.next;
        this.count--;
        return true;
    }
    public int size(){
        return this.count;
    }

    private class LinkedListNode {

        private final T nodeValue;
        private LinkedListNode next;

        public LinkedListNode(T nodeValue) {
            this.nodeValue = nodeValue;
        }

        public T getNodeValue() {
            return nodeValue;
        }

        public LinkedListNode getNext() {
            return next;
        }
    }
}
