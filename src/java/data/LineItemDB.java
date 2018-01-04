/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import bussiness.LineItem;
import bussiness.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LineItemDB {
    public static boolean insertItems(int orderID, List<LineItem> items){
        boolean t=false;
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con=pool.getConnection();
        
        String sqlString ="Insert into LineItem values(?,?,?,?)";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            for(LineItem item: items){
            ps.setInt(1, orderID);
            ps.setInt(2, item.getProducts().getProductID());
            ps.setInt(3, item.getQuantity());
            ps.setInt(4, item.getTotal());
            ps.executeUpdate();
            }
            t=true;
        }catch(SQLException e){
            System.out.println(e);
        }finally{pool.freeConnection(con);}
        return t;
    }
    public static List<LineItem> getItem(int orderID) {
        List<LineItem> li = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = " select * from LineItem, Orders where LineItem.OrderID=Orders.OrderID and LineItem.OrderID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, orderID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                int productID = rs.getInt("productID");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                Products p= ProductDB.getProduct(productID);
                LineItem item=new LineItem(orderID, p, quantity);
                li.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return li;
    }
}
