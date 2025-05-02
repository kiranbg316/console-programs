package com.herokiran.corejava.consoleprograms;

import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the original price : $");
        double originalPrice = scanner.nextDouble();

        System.out.println("enter the discount percentage :");
        double discountPercentage = scanner.nextDouble();

double finalPrice = calculateDiscount(originalPrice,discountPercentage);

        System.out.println("Original price: $" + originalPrice);
        System.out.println("dicount : " + discountPercentage + "%");
        System.out.println("Discounted Price : $" + finalPrice);


    }

    public static double calculateDiscount(double originalPrice, double discountPercentage) {
        double discountAmount = (originalPrice * discountPercentage) / 100;
        double finalPrice = originalPrice - discountAmount;

        return finalPrice;
    }

}
