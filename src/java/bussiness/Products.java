package bussiness;

import java.io.Serializable;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Products implements Serializable{
    private int productID;
    private int categoryID;
    private String productName;
    private int price;
    private String urlImage;
    private LocalDate timeUpdate;
    private String description;
    
    public Products() {
    }

    public Products(int productID, int categoryID, String productName, int price, String urlImage, LocalDate timeUpdate, String description) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.price = price;
        this.urlImage = urlImage;
        this.timeUpdate = timeUpdate;
        this.description = description;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public LocalDate getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(LocalDate timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

     public String getFormattedPrice(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String FormattedPrice = currency.format(price);
        return FormattedPrice;
    } 
    
    public Date getDateUpdateFormatted(){
        timeUpdate= getTimeUpdate();
        return java.sql.Date.valueOf(timeUpdate);
    }
}
