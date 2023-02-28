/*
Title: Account.java
Abstract:This class helps us to store the account details of the user which are account number,account type,balance.The
customer name,customer address and ssn is stored in the object Customer.
Author:Priyadarshini Sawant
Date:02/21/2023

 */
public class Account {
    private  int accNum;
    private int accType;
    private Customer accHolder;
    private double balance;

    public Account(String name,String addr, int ssn , int accNum, int accType, double balance ){
        this.accHolder = new Customer(name,addr,ssn);
        this.accNum = accNum;
        this.accType = accType;
        this.balance = balance;
    }
    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getAccType() {
        if (accType == 1){
            return "Checking account";
        }else {
            return "Savings account";
        }
    }

    public void setAccType(int accType) {
        this.accType = accType;
    }

    public Customer getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(Customer accHolder) {
        this.accHolder = accHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}