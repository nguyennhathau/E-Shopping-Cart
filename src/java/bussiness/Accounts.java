package bussiness;

import java.io.Serializable;

public class Accounts implements Serializable{
    private String username;
    private String password;
    

    public Accounts() {
    }

    public Accounts(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
