package data;

import bussiness.Categories;
import bussiness.Products;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    
    public static List<Products> getProductBestSell(){
        List<Products> products= new ArrayList<>();
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString =" select top 4 OrderID, l.productID as 'pID', quantity, l.price as 'price', categoryID, productName, urlImage, timeUpdate, description\n" +
" from LineItem l,Products p where l.productID=p.productID order by quantity desc";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){   
                String orderID=rs.getString("orderID");
                int productID=rs.getInt("pID");
                int quantity=rs.getInt("quantity");
                int price=rs.getInt("price");
                int categoryID=rs.getInt("categoryID");
                String productName=rs.getString("productName");               
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                Products p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return products;
    }
    
     public static List<Products> getProductsNew(){
        List<Products> products= new ArrayList<>();
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString ="select top 6 * from Products order by productID desc";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){              
                int productID=rs.getInt("productID");
                int categoryID=rs.getInt("categoryID");
                String productName=rs.getString("productName");
                int price=rs.getInt("price");
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                Products p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return products;
    }
     
     public static List<Products> getPromotions(){
        List<Products> products= new ArrayList<>();
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString ="select * from Products,Promotions where Products.productID=Promotions.productID ";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){              
                int productID=rs.getInt("productID");
                int categoryID=rs.getInt("categoryID");
                String productName=rs.getString("productName");
                int price=rs.getInt("price");
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                Products p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return products;
    }
     
     public static List<Products> getProductsByCategory(int categoryID){
        List<Products> products= new ArrayList<>();
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString ="select * from Products p,Categories c where p.categoryID=c.categoryID and c.categoryID=?";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1, categoryID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){              
                int productID=rs.getInt("productID");
                String productName=rs.getString("productName");
                int price=rs.getInt("price");
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                Products p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return products;
    }
     
     public static Products getProduct(int productID){
        Products p= null;
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString ="select * from Products where productID=?";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ps.setInt(1, productID);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){              
                int categoryID=rs.getInt("categoryID");
                String productName=rs.getString("productName");
                int price=rs.getInt("price");
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return p;
    }
     
    public static List<Products> getProducts(){
        List<Products> products= new ArrayList<>();
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString ="select * from Products order by productID desc";
        try{
            PreparedStatement ps=con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){              
                int productID=rs.getInt("productID");
                int categoryID=rs.getInt("categoryID");
                String productName=rs.getString("productName");
                int price=rs.getInt("price");
                String urlImage=rs.getString("urlImage");
                Date timeformat=rs.getDate("timeUpdate");
                LocalDate timeUpdate = timeformat.toLocalDate();
                String description=rs.getString("description");
                Products p= new Products(productID, categoryID, productName, price, urlImage, timeUpdate, description);
                products.add(p);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return products;
    }
    
    public static boolean insertProduct(Products p){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into Products values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, p.getCategoryID());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getPrice());
            ps.setString(4, p.getUrlImage());
            ps.setDate(5, p.getDateUpdateFormatted());
            ps.setString(6, p.getDescription());
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static boolean deleteProduct(int productID){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "delete Products where productID=?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1,productID);
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static boolean updateProduct(Products p){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "UPDATE Products SET "
                + "categoryID = ?,"
                + "productName=?,"
                + "price=?,"
                + "urlImage=?,"
                + "timeUpdate=?,"
                + "description=? WHERE productID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, p.getCategoryID());
            ps.setString(2, p.getProductName());
            ps.setInt(3, p.getPrice());
            ps.setString(4, p.getUrlImage());
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String timeUpdate=dtf.format(p.getTimeUpdate());
            ps.setString(4, timeUpdate);
            ps.setString(5, p.getDescription());
            ps.setInt(6, p.getProductID());
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
}
