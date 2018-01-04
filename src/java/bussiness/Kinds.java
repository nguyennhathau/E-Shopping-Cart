package bussiness;
public class Kinds {
    private int kindID;
    private String kindName;
    private int sumProductInKinds;
    public Kinds() {
    }

    public Kinds(int kindID, String kindName,int sumProductInKinds) {
        this.kindID = kindID;
        this.kindName = kindName;
        this.sumProductInKinds = sumProductInKinds;
    }

    public int getSumProductInKinds() {
        return sumProductInKinds;
    }

    public void setSumProductInKinds(int sumProductInKinds) {
        this.sumProductInKinds = sumProductInKinds;
    }

    public int getKindID() {
        return kindID;
    }

    public void setKindID(int kindID) {
        this.kindID = kindID;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }
    
    
}
