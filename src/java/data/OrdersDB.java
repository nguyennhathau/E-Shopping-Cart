package data;

import bussiness.Orders;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrdersDB {
    public static boolean insertOrders(Orders orders){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into Orders values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String orderDateString=dtf.format(orders.getOrderDate());
            ps.setString(1, orders.getHoten());
            ps.setString(2, orders.getAddress());
            ps.setInt(3, orders.getPhone());
            ps.setString(4, orders.getEmail());
            ps.setString(5, orderDateString);
            ps.setBoolean(6, orders.isStatusOrder());
            ps.executeUpdate();
            int orderID= getLastOrderID();
            
            if(!LineItemDB.insertItems(orderID, orders.getCart().getItems())){
                return false;
            }
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
    public static int getLastOrderID(){
        int i=0;
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con =pool.getConnection();
        
        String sqlString="select Max(OrderID) as 'LastOrder' from Orders";
        
        try{
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            i=rs.getInt("LastOrder");
        }catch(SQLException e){
            System.out.println(e);
        }
        return i;
    }
    
    public static List<Orders> getOrders() {
        List<Orders> orders = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select * from Orders";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int OrderID= rs.getInt("OrderID");
                String hoten= rs.getString("hoten");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                Date timeformat=rs.getDate("orderDate");
                LocalDate orderDate = timeformat.toLocalDate();
                Boolean statusOrder=rs.getBoolean("statusOrder");
                Orders order=new Orders(OrderID, hoten, address, phone, email, orderDate, statusOrder,null);
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return orders;
    }
    
    public static boolean updateOrder(int orderID,boolean status){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "update Orders set statusOrder=? where OrderID=?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setBoolean(1, status);
            ps.setInt(2, orderID);
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static boolean deleteOrder(int  orderID){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "delete Orders where orderID=?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setInt(1, orderID);
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
