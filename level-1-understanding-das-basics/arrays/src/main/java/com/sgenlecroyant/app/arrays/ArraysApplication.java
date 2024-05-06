package com.sgenlecroyant.app.arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArraysApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArraysApplication.class, args);

		AppArray<Integer> appArray = new AppArray<>(2);
		appArray.add(12);
		appArray.add(13);
		appArray.add(14);
		appArray.add(15);
		appArray.print();

		// appArray.addAt(0, 1000);
		int index = 0;
		appArray.removeAt(index);
		System.out.println("after removing at index " +index);
		appArray.print();
	}

}
