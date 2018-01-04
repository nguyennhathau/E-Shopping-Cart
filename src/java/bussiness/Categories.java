package bussiness;

import java.io.Serializable;

public class Categories implements Serializable{
    private int categoryID;
    private String categoryName;
    private int kindID;
    
    public Categories(){
    }

    public Categories(int categoryID, String categoryName, int kindID) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.kindID = kindID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getKindID() {
        return kindID;
    }

    public void setKindID(int kindID) {
        this.kindID = kindID;
    }

}
