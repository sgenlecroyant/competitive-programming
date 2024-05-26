package com.sgenlecroyant.app.queues;

public class AppQueue <T>{

    private int count;
    private QueueNode head;
    private QueueNode tail;

    public AppQueue(T value){
        this.head = this.tail = new QueueNode(value);
        this.count++;
    }

    public boolean enqueue(T value){
        QueueNode newNode = new QueueNode(value);
        if (this.head == null){
            this.head = this.tail = newNode;
        }else {
            QueueNode currentTail = this.tail;
            currentTail.next = newNode;
            this.tail = newNode;
        }
        this.count++;
        return true;
    }

    public T dequeue(){
        if (this.head != null){
            QueueNode currentHead = this.head;
            this.head = currentHead.next;
            return currentHead.value;
        }
        return null;
    }
    public T peek(){
        if (this.head != null){
            return this.head.value;
        }
        return null;
    }

    public void doPrint(){
        System.out.println("=== printing ===");
        QueueNode currentNode = this.head;
        while (currentNode != null){
            System.out.print(currentNode.value+ " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public class QueueNode {

        private final T value;
        private QueueNode next;

        public QueueNode(T value){
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public QueueNode getNext() {
            return next;
        }
    }

    public int size(){
        return this.count;
    }
}
