package com.sgenlecroyant.app.stacks;

public class AppStack <T> {

    private int count;
    private StackNode top;
    private StackNode bottom;

    public AppStack(T value){
        this.top = this.bottom = new StackNode(value);
        this.count++;
    }

    public boolean push(T value){
        StackNode newNode = new StackNode(value);
        if (this.top == null){
            this.top = this.bottom = newNode;
        }else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.count++;
        return true;
    }

    public T pop(){
        StackNode currentHead = this.top;
        this.top = currentHead.next;
        this.count--;
        return currentHead.value;
    }
    public void doPrint(){
        System.out.println("this.count = " + this.count);
        StackNode currentHead = this.top;

        while (currentHead != null){
            System.out.print(currentHead.value+ " ");
            currentHead = currentHead.next;
        }
        System.out.println();
    }

    public T peek() {
        if (this.top != null) {
            return this.top.value;
        }
        return null;
    }

    public StackNode getBottom(){
        return this.bottom;
    }

    public class StackNode{

        private T value;
        private StackNode next;

        private StackNode(T value){
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public StackNode getNext() {
            return next;
        }
    }
}
