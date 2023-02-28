/*
Title:VendingMachine.java
Abstract:This program helps us to create a virtual vending machine using java for our college CSUMB.Vending machine have following
items ,water ($1.50), a coffee ($2.00), a bag of chips ($1.00), or a chocolate bar ($2.50). Whenever user wants something from vending machine he/she can
vend it if it is avaiable in our vending machine.
Author:Priyadarshini Sawant
Date:02/20/2023
 */

import java.util.Scanner;

public class VendingMachine {

    private String location;
    private int vend_num;
    private double continuous_cost =0;
    private double total_cost=0;
    private String[] content = {"Water","Coffee","Chips","Chocolate"};
    private int[] initial_receipt = {0,0,0,0};
    private double[] price ={1.50 , 2.00 , 1.00 , 2.50};
    private int[] quantity = {0,0,0,0};

    public VendingMachine(int location){
        this.vend_num = location;
        this.location = "UNKNOWN";

    }

    public void setName(int name) {
        this.vend_num =name;
    }
    public void setLocation(String location1) {
        this.location = location1;
    }

    public void reset(int i, int i1, int i2, int i3) {
        quantity[0] = i;
        quantity[1] = i1;
        quantity[2] = i2;
        quantity[3] = i3;
    }

    public void displayMenu() {
        System.out.println("===== Vending Machine Menu =====\n" +
                "\n" +
                " 1. Water............$1.50\n" +
                "\n" +
                " 2. Coffee...........$2.00\n" +
                "\n" +
                " 3. Chips............$1.00\n" +
                "\n" +
                " 4. Chocolate........$2.50");
    }


    public void addItems(int i, int i1, int i2, int i3) {
        quantity[0] += i;
        quantity[1] += i1;
        quantity[2] += i2;
        quantity[3] += i3;
    }
    public boolean buyItem(int itemNum , int items){
        System.out.println("Select an item number: " + itemNum);
        System.out.println("How many do you want to buy? " + items);
        System.out.println("You selected " + content[itemNum-1] + "." + "Quantity: " + items);
        if(quantity[itemNum - 1] >= items){
            quantity[itemNum - 1]-= items;
            initial_receipt[itemNum -1] += items;
            continuous_cost += price[itemNum-1]*items;
            return true;
        }
        else {
            System.out.println("Selection failed.We do not have enough chips" );
            return false;
        }
    }

    public void returned(int i, int i1) {
        System.out.println("You selected " + content[i-1] + "." + "Quantity: " + i1 );
        quantity[i-1] += i1;
        initial_receipt[i-1] -=i1;
        continuous_cost -= price[i-1]*i1;
    }

    public boolean payment() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter money amount: $");
        double money = kb.nextDouble();
        if (money >= continuous_cost){
            double change = continuous_cost+continuous_cost*0.1;
            System.out.printf("Sufficient money. $%.2f returned%n" , money-change);
            return true;
        }
        else {
            System.out.printf("Insufficient money. $%.2f returned%n" ,money);
            return false;
        }

    }

    public boolean buyItem() {
        Scanner kb =new Scanner(System.in);
        System.out.print("Select an item number:");
        int product = kb.nextInt();
        System.out.print("How many items do you want to buy?");
        int buy_product = kb.nextInt();
        System.out.println("You selected " + content[product-1] + ". " + "Quantity: " + buy_product);

        if (quantity[product-1] >= buy_product){
            quantity[product-1] -= buy_product;
            initial_receipt[product-1] += buy_product;
            continuous_cost += price[product-1] * buy_product;
            return true;
        }
        else {
            System.out.println("Selection failed.");
            return false;
        }
    }
    public VendingMachine(int number, String location){
        this.vend_num = number;
        this.location = location;
    }

    public void displayReceipt() {
        for (int i = 0; i < initial_receipt.length ; i++) {
            double before_tax = price[i] * initial_receipt[i];
            double after_tax =  before_tax * 0.1;
            double totalPrice = before_tax + after_tax;
            if (initial_receipt[i] > 0){
                total_cost = totalPrice;
                System.out.printf("%s : $%.2f X %d = $%.2f %nTax (10.0%%): $%.2f %nTotal: $%.2f %n",content[i],price[i],initial_receipt[i],before_tax,after_tax,totalPrice);
            }
        }
    }


    public boolean equals(VendingMachine machine){
        if (quantity[0] != machine.quantity[0]){
            return false;
        }
        else if (quantity[1] != machine.quantity[1]){
            return false;
        }
        else if (quantity[2] != machine.quantity[2]){
            return false;
        }
        else return quantity[3] == machine.quantity[3];


    }

    public void status() {
        System.out.println("Serial Number: " + vend_num);
        System.out.println("Location: " + location);
        System.out.println("Sold Items: ");
        System.out.println("water: " + initial_receipt[0]);
        System.out.println("Coffee: " + initial_receipt[1]);
        System.out.println("Chips: " + initial_receipt[2]);
        System.out.println("Chocolate: " + initial_receipt[3]);
        System.out.println("Current Contents: ");
        System.out.println("water: " + quantity[0]);
        System.out.println("Coffee: " + quantity[1]);
        System.out.println("Chips: " + quantity[2]);
        System.out.println("Chocolate: " + quantity[3]);
        System.out.printf("Total Earnings: $%.2f",total_cost);
        System.out.println("");
    }

    public String toString() {
        return "Serial Number: " + vend_num + "\n" + "Location: " + location + "\n" +"Contents:"+ "\n"+ "Water: " + quantity[0] + "\n"+ "Coffee: " + quantity[1] + "\n"+ "Chips: " + quantity[2] + "\n"+ "Chocolate: " + quantity[3];
    }



}
