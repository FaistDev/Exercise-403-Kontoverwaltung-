/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class AccountUser implements Runnable {
    private String name;
    private Account account;

    public AccountUser(String name,Account account) {
        this.name = name;
        this.account=account;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Random r = new Random();
        int amount = r.nextInt(50-10+1)+10;
        int depOrWith = r.nextInt(2-1+1)+1;
        
        if(depOrWith==1){
            synchronized(account){
                if(account.getAmount()>=amount){
                    account.withdraw(amount);
                }else{
                    try {
                        account.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
        }else{
            synchronized(account){
                account.deposit(amount);
                account.notifyAll();
            }           
        }
        
        
    }
    
}
