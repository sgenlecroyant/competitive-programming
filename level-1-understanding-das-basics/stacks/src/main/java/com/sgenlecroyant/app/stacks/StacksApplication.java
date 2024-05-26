package com.sgenlecroyant.app.stacks;

import java.io.IOException;

public class StacksApplication {

	public static void main(String[] args) throws IOException {

		AppStack<String> appStack = new AppStack<>("google");
		appStack.push("udemy");
		appStack.push("discord");

		System.out.println(appStack.peek());

	}

}
