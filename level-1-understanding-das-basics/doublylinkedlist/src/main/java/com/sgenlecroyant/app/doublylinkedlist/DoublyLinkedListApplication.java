package com.sgenlecroyant.app.doublylinkedlist;

public class DoublyLinkedListApplication {

	public static void main(String[] args) {

		AppDoublyLinkedList<Integer> appDoublyLinkedList = new AppDoublyLinkedList<>(10);

		appDoublyLinkedList.append(11);
		appDoublyLinkedList.append(12);

		appDoublyLinkedList.append(13);

		appDoublyLinkedList.prepend(2);
		appDoublyLinkedList.prepend(1);
		appDoublyLinkedList.prepend(0);
		appDoublyLinkedList.addAt(3, 100);
		appDoublyLinkedList.addAt(3, 99);
		appDoublyLinkedList.doPrint();
		appDoublyLinkedList.doPrintBackward();

	}

}
