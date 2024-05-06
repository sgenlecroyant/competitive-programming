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
		appArray.print();

		appArray.addFirst(1000);

		appArray.addAt(0);
	}

}
