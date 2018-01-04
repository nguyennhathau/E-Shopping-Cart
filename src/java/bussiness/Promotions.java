
package bussiness;

import java.io.Serializable;
import java.time.LocalDate;

public class Promotions implements Serializable{
    private int proID;
    private int productID;
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private int priPro;

    public Promotions() {
    }

    public Promotions(int proID, int productID, LocalDate dateStart, LocalDate dateEnd, int priPro) {
        this.proID = proID;
        this.productID = productID;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.priPro = priPro;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getPriPro() {
        return priPro;
    }

    public void setPriPro(int priPro) {
        this.priPro = priPro;
    }
    
    
}
