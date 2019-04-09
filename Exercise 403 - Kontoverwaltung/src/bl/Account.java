/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.ArrayList;

/**
 *
 * @author Ben
 */
public class Account {
    private double amount;

    public Account(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
        
    public void withdraw(double amount){
        this.amount-=amount;
    }
    
    public void deposit(double amount){
        this.amount+=amount;
    }
   
}
