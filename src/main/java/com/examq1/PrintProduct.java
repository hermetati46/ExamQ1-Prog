package com.examq1;

public class PrintProduct {

    private final Product product;

    // Constructor accepts a Product instance containing the calculated report data.
    public PrintProduct(Product product) {
        this.product = product;
    }

    // Prints the total number of products sold
    public void printTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    //Prints the average product sales
    public void printAverageProductSales() {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
    }

     // Prints the most popular product and its corresponding peak sales figure
    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

     // Displays the formatted Product Sales Report
    public void generateReport() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}