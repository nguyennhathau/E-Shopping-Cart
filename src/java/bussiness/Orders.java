package bussiness;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Orders implements Serializable{
    private int orderID;
    private String hoten;
    private String address;
    private int phone;
    private String email;
    private LocalDate orderDate;
    private boolean statusOrder;
    private Cart cart;
    
    public Orders() {
    }

    public Orders(int orderID, String hoten, String address, int phone, String email, LocalDate orderDate, boolean statusOrder, Cart cart) {
        this.orderID = orderID;
        this.hoten = hoten;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.orderDate = orderDate;
        this.statusOrder=statusOrder;
        this.cart = cart;
    }

    public boolean isStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(boolean statusOrder) {
        this.statusOrder = statusOrder;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    
    
}
