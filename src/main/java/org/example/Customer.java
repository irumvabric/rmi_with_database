package org.example;

public class Customer implements java.io.Serializable{
    private int acc_no;
    private String firstname,lastname,email;
    private float amount;


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public Customer() {
    }

    public Customer(int acc_no, String firstname, String lastname, String email, float amount) {
        this.acc_no = acc_no;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.amount = amount;
    }
}
