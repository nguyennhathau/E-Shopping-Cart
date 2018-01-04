package data;

import bussiness.Categories;
import bussiness.Kinds;
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
public class CategoryDB {

    public static List<Categories> getCategories() {
        List<Categories> categories = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sqlString = "select * from Categories";
        try {
            PreparedStatement ps = con.prepareStatement(sqlString);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt("categoryID");
                String categoryName = rs.getString("categoryName");
                int kindID=rs.getInt("kindID");
                Categories c = new Categories(categoryID, categoryName, kindID);
                categories.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return categories;
    }

    public static List<Kinds> getKinds() {
        List<Kinds> kinds = new ArrayList<>();
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();

        String sqlString = "select k.kindID as 'kindID',kindName,COUNT(kindName)as 'sumProductInKinds' from Kinds k,Categories c\n"
                + "where k.kindID=c.kindID \n"
                + "group by kindName,k.kindID";

        try {
            PreparedStatement ps = con.prepareStatement(sqlString);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int kindID = rs.getInt("kindID");
                String kindName = rs.getString("kindName");
                int sumProductInKinds = rs.getInt("sumProductInKinds");
                Kinds kind = new Kinds(kindID, kindName, sumProductInKinds);
                kinds.add(kind);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kinds;
    }

    public static boolean insertKind(Kinds k) {

        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sql = "INSERT INTO Kinds VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, k.getKindName());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean insertCategory(Categories c) {

        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sql = "INSERT INTO Categories VALUES(?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setInt(2, c.getKindID());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean updateCategory(Categories c){
        boolean t = false;

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sql = "UPDATE Categories SET categoryName = ?,kindID=? WHERE categoryID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, c.getCategoryName());
            ps.setInt(2, c.getKindID());
            ps.setInt(3, c.getCategoryID());
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }

    public static boolean deleteCategory(int categoryID){
        boolean t = false;
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection con = pool.getConnection();
        String sql = "delete Categories where categoryID=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, categoryID);
            ps.executeUpdate();
            t = true;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            pool.freeConnection(con);
        }
        return t;
    }
}
