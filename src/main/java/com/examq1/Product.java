package com.examq1;

public class Product implements IProduct {

    // Single-dimensional array to store product names
    private final String[] productNames;

    // Two-dimensional array to store monthly sales
    private final int[][] monthlySales;


     // Constructor to initialize the product names and sales data arrays
    public Product(String[] productNames, int[][] monthlySales) {
        if (productNames == null || monthlySales == null || productNames.length != monthlySales.length) {
            throw new IllegalArgumentException("Product names and sales data arrays must be non-null and of matching length.");
        }
        this.productNames = productNames;
        this.monthlySales = monthlySales;
    }

    // Calculates the total number of products sold across all products and months.

    @Override
    public int GetTotalProductsSold() {
        int totalSales = 0;
        for (int[] productRow : monthlySales) {
            for (int sale : productRow) {
                totalSales += sale;
            }
        }
        return totalSales;
    }

    // Calculates the average number of products sold per monthly entry.

    @Override
    public double GetAverageProductSold() {
        int totalEntries = 0;
        for (int[] productRow : monthlySales) {
            totalEntries += productRow.length;
        }
        if (totalEntries == 0) {
            return 0.0;
        }
        return (double) GetTotalProductsSold() / totalEntries;
    }

    // Determines the most popular product based on the highest single-month sale

    @Override
    public String GetMostPopularProduct() {
        int highestSale = -1;
        String popularProduct = "";

        for (int i = 0; i < monthlySales.length; i++) {
            for (int j = 0; j < monthlySales[i].length; j++) {
                if (monthlySales[i][j] > highestSale) {
                    highestSale = monthlySales[i][j];
                    popularProduct = productNames[i];
                }
            }
        }
        return popularProduct + "(" + highestSale + ")";
    }
}