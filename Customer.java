/*
* Author: Priyadarshini Sawant
* Title: Customer.java
* Abstract : This programs hold all the customer information that is required in our bank which consist of the name of customer,
*  address of customer and ssn of customer.
* */

public class Customer {
    private String name;
    private int ssn;
    private String address;

    public Customer(String name,String address, int ssn ){
        this.name = name;
        this.ssn = ssn;
        this.address = address;
        this.name = getName();
        this.ssn = getSsn();
        this.address = getAddress();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getSsn() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public String toString(){
        return "Customer: " + name + "\n" + address;
    }
}
