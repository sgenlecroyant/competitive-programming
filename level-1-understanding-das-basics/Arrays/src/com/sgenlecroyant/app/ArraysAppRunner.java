package com.sgenlecroyant.app;

import java.util.Arrays;

public class ArraysAppRunner {

    public static void main(String[] args) {
        System.out.println("The journey starts from here");

        AppArray<Integer> appArray = new AppArray<>();
        appArray.add(1);
        appArray.add(2);
        appArray.doPrint(); // this is normal size we have only added items equal to the array initial size
        // let's check the behavior if we try to add some more items
        appArray.add(3);
        appArray.doPrint();
    }
}
