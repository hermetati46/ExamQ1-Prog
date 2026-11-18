package com.examq1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Single-dimensional array TO store the top products
        String[] products = {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        };

        final int NUM_PRODUCTS = products.length;
        final int NUM_MONTHS = 3;

        // Two-dimensional array to store sales for each product in 3 months
        int[][] salesData = new int[NUM_PRODUCTS][NUM_MONTHS];

        try (Scanner scanner = new Scanner(System.in)) {
            // Populate the 2D array with validated user input
            for (int i = 0; i < NUM_PRODUCTS; i++) {
                for (int j = 0; j < NUM_MONTHS; j++) {
                    salesData[i][j] = getValidSalesInput(scanner, j + 1, products[i]);
                }
                System.out.println();
            }

            // Instantiate Product and PrintProduct classes to process and print the report
            Product productSales = new Product(products, salesData);
            PrintProduct reportPrinter = new PrintProduct(productSales);
            reportPrinter.generateReport();

        } catch (Exception e) {
            System.err.println("An unexpected error occurred while generating the sales report: " + e.getMessage());
        }
    }

     // Helper method to prompt and validate integer input from the user.
    private static int getValidSalesInput(Scanner scanner, int month, String productName) {
        int sales = -1;
        while (sales < 0) {
            System.out.print("Enter number of sales for month " + month + " for " + productName + " mattress: ");
            try {
                sales = scanner.nextInt();
                if (sales < 0) {
                    System.out.println("Invalid input. Sales cannot be negative. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid whole number.");
                scanner.next(); // Clear invalid token
            }
        }
        return sales;
    }
}
