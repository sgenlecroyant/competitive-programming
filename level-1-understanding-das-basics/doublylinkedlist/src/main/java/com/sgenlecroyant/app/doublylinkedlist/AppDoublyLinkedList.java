package com.sgenlecroyant.app.doublylinkedlist;

public class AppDoublyLinkedList<T>{

    private int count;
    private DoublyNode head;
    private DoublyNode tail;

    public AppDoublyLinkedList(T value){
        DoublyNode newNode = new DoublyNode(value);
        this.head = this.tail = newNode;
        this.count++;
    }

    public boolean append(T value){
        DoublyNode newNode = new DoublyNode(value);
        if (this.head == null){
            this.head = newNode;
        }else {
            DoublyNode currentTailNode = this.tail;
            newNode.prev = currentTailNode;
            currentTailNode.next = newNode;
            this.tail = newNode;
        }
        this.count++;
        return true;
    }

    public boolean prepend(T value){

        DoublyNode newNode = new DoublyNode(value);

        if (this.head == null){
            this.head = this.tail = newNode;
        }else {
            DoublyNode currentHeadNode = this.head;
            this.head.prev = newNode;
            newNode.next = currentHeadNode;
            this.head = newNode;
        }

        this.count++;
        return true;
    }

    public boolean addAt(int index, T value){

        if (index < 0 || index > this.count){
            throw new RuntimeException("Invalid target index");
        }

        if (index == 0){
            this.prepend(value);
            return true;
        }
        if (index == this.count){
            this.append(value);
            return true;
        }

        DoublyNode newNode = new DoublyNode(value);
        DoublyNode leaderNode = this.grabLeaderNode(index - 1);

        DoublyNode followerNode = leaderNode.next;
        newNode.next = followerNode;
        newNode.prev = leaderNode;

        leaderNode.next = newNode;
        followerNode.prev = newNode;
        this.count++;
        return true;
    }

    public DoublyNode grabLeaderNode(int index){
        int i = 0;
        DoublyNode currentNode = this.head;

        while (i != index){
            currentNode = currentNode.next;
            i++;
        }
        return currentNode;
    }

    public void doPrint(){
        System.out.println(" printing forward: this.count = " + this.count);
        DoublyNode currentNode = this.head;
         while (currentNode != null){
             System.out.print(currentNode.value + " ");
             currentNode = currentNode.next;
         }
        System.out.println();
    }

    public void doPrintBackward(){
        System.out.println(" printing backward: this.count = " + this.count);

        DoublyNode currentTail = this.tail;
        while (currentTail != null){
            System.out.print(currentTail.value+ " ");
            currentTail = currentTail.prev;
        }
        System.out.println();
    }

    public int size() {
        return this.count;
    }

    public class DoublyNode{

        private T value;
        private DoublyNode next;
        private DoublyNode prev;

        public DoublyNode(T value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public T getValue() {
            return value;
        }

    }

    public DoublyNode getHead(){
        return this.head;
    }

    public DoublyNode getNext(){
        return this.head.next;
    }

    public DoublyNode getPrev(){
        return this.head.prev;
    }

    public DoublyNode getTail(){
        return this.tail;
    }

}
