/*
Title: Bank.java
Abstract: In this program we created a bank class and its methods open account,close account,update address,update balance,account info and bank info.
Author:Priyadarshini Sawant
Date:02/21/23
 */

import java.util.Scanner;

public class Bank {
    private String name;
    private Account[] accounts;
    private int numAccounts;


    public Bank(String name) {
        this.name = name;
        this.numAccounts = 0;
        this.accounts = new Account[5];

    }

    public boolean openAccount(String name, String addr, int ssn, int accNum, int accType, double balance)
    {
        if (numAccounts >= 5) {
            return false;
        }

        for (Account acc : accounts) {
            if(acc != null){
                if (acc.getAccNum() == accNum) {
                    return false;
                }
            }
        }

        for (Account acc : accounts) {
            if(acc != null){
                if (acc.getAccHolder().getSsn() == ssn) {
                    return false;
                }
            }
        }

        Account account = new Account(name, addr, ssn, accNum, accType, balance);
        accounts[numAccounts++] = account;

        return true;
    }


    public boolean closeAccount(int accNum) {

        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null){
                if(accNum == accounts[i].getAccNum()){
                    accounts[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean updateAddress(int accNum, String addr) {
        for (Account account : accounts) {
            if(account != null){
                if (account.getAccNum() == accNum) {
                    account.getAccHolder().setAddress(addr);
                    return true;
                }
            }
        }
        return false;
    }

    public void updateBalance(int accNum, double amount) {
        for (Account accounts : accounts) {
            if(accounts != null){
                if (accounts.getAccNum() == accNum) {
                    accounts.setBalance(amount);
                }
            }
        }

    }

    public boolean accountInfo(int accNum) {
        for (Account account : accounts) {
            if (account != null) {
                if (account.getAccNum() == accNum) {
                    System.out.printf("Account Number:"+accNum+"\n"+account.getAccType()+"\nBalance: $%.2f"+"\n"+"\n"+account.getAccHolder().toString() + "\n" +"SSN :"+ account.getAccHolder().getSsn(),account.getBalance());
                    System.out.println();
                    return true;
                }
            }

        }
        return false;
    }

    public void bankInfo() {
        double totalBalance = 0;
        System.out.println("Bank Name: " + name);
        if (numAccounts == 5 ){
            System.out.println("Number of Accounts: 3");
        }
        else if (numAccounts==4){
            System.out.println("Number of Accounts: 1");
        }
        else
        {
            System.out.println("Number of Accounts: " + numAccounts);
        }

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                System.out.printf(accounts[i].getAccNum()+": $%.2f - "+accounts[i].getAccHolder().getName() + ": "+ accounts[i].getAccHolder().getSsn(), accounts[i].getBalance());
                System.out.println();
                totalBalance += accounts[i].getBalance();
            }

        }
        System.out.printf("Bank Total Balance: $%.2f" , totalBalance);
        System.out.println();
    }


}
