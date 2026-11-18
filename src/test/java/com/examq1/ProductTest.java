package com.examq1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    private Product product;

    @BeforeEach
    public void setUp() {
        // Tests data
        String[] productNames = {
                "Cozy Nights Monarch",
                "Restonic Barbados",
                "Sealy Phuket"
        };

        int[][] salesData = {
                {25, 18, 20}, // Cozy Nights Monarch
                {15, 10, 12}, // Restonic Barbados
                {18, 15, 20}  // Sealy Phuket
        };

        product = new Product(productNames, salesData);
    }

     // Verifies if this test returns an accurate sum
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int expectedTotal = 153;
        int actualTotal = product.GetTotalProductsSold();
        assertEquals(expectedTotal, actualTotal, "Total product sales should equal 153.");
    }

     // Verifies if the test returns the accurate average
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        double expectedAverage = 17.0;
        double actualAverage = product.GetAverageProductSold();
        assertEquals(expectedAverage, actualAverage, 0.01, "Average product sales should equal 17.0.");
    }
}