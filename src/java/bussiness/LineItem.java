package bussiness;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class LineItem implements Serializable {

    private int orderID;
    private Products products;
    private int quantity = 1;

    public LineItem() {
    }

    public LineItem(int orderID, Products products, int quantity) {
        this.orderID = orderID;
        this.products = products;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        int total = products.getPrice() * quantity;
        return total;
    }

    public String getTotalFormatted() {
        double total = this.getTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String totalFormatted = currency.format(total);
        return totalFormatted;
    }

}
