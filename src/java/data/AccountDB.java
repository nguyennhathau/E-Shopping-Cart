package data;

import bussiness.Accounts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDB {
    
    public static Accounts getAccount(String username) {
        Accounts acc=null;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select * from Accounts where username=?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String password = rs.getString("password");
                acc=new Accounts(username, password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return acc;
    }
    
    public static boolean login(String username,String password) {
        boolean t=false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select * from Accounts where username=? and password=?";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                con.close();
		t=true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
    
    public static List<Accounts> getAccounts() {
        List<Accounts> accounts = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select * from Accounts";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username= rs.getString("username");
                String password = rs.getString("password");
                Accounts acc=new Accounts(username, password);
                accounts.add(acc);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return accounts;
    }

     public static boolean insertAcc(Accounts acc){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "Insert into Accounts values(?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
     
     public static boolean updateAcc(Accounts acc){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "update Accounts set password=? where username=?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.executeUpdate();
            t=true;
            
        } catch (SQLException e) {
            System.out.println(e);
        }finally{
            pool.freeConnection(con);
        }
        return t;
    }
     
      public static boolean deleteAcc(String username){
        boolean t=false;
        //List<Product> products=new ArrayList<>();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection con= pool.getConnection();
        String sqlString = "delete Accounts where username=?";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ps.setString(1, username);
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
