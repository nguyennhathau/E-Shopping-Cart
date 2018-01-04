package bussiness;

import java.util.*;
import java.io.Serializable;
import java.text.NumberFormat;

public class Cart implements Serializable {

    private List<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<LineItem> lineItems) {
        items = lineItems;
    }

    public List<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();       
    }
    public int getTotalPrice(){
        int total=0;
         for (LineItem lineItem : items) {
           total+=lineItem.getTotal();
            }
        return total;
    }
    public int getTotalProduct(){
        int sumProduct=0;
         for (LineItem lineItem : items) {
           sumProduct+=lineItem.getQuantity();
            }
        return sumProduct;
    }
    
    public String getTotalPriceFormatted() {
        double total = this.getTotalPrice();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String totalPriceFormatted = currency.format(total);
        return totalPriceFormatted;
    }
    
    public void addItem(LineItem item) {
        //If the item already exists in the cart, only the quantity is changed.
        int productID = item.getProducts().getProductID();
        int quantity = item.getQuantity();
        for (LineItem lineItem : items) {
            if (lineItem.getProducts().getProductID()==productID) {
                lineItem.setQuantity(lineItem.getQuantity() + 1);
                return;
            }
        }
        items.add(item);
    }

    public void update(LineItem item) {
        int code = item.getProducts().getProductID();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProducts().getProductID()==code) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
    }

    public void removeItem(LineItem item) {
        int code = item.getProducts().getProductID();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProducts().getProductID()==code) {
                items.remove(i);
                return;
            }
        }
    }
}
