/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import gui.GUI;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Ben
 */
public class AccountUser implements Runnable {

    private String name;
    private Account account;
    private GUI gui;

    public AccountUser(String name, Account account,GUI gui) {
        this.name = name;
        this.account = account;
        this.gui=gui;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int time = r.nextInt(1000 - 1 + 1) + 1;
            int amount = r.nextInt(50 - 10 + 1) + 10;
            int depOrWith = r.nextInt(2 - 1 + 1) + 1;

            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (depOrWith == 1) {
                synchronized (account) {
                    gui.putLine(name+": Trying to withdraw money...\n");
                    if (account.getAmount() >= amount) {
                        account.withdraw(amount);
                        gui.putLine(name+": Withdrawed "+amount+" €; Balance left: "+account.getAmount()+"\n");
                        gui.showBalance();
                    } else {
                        try {
                             gui.putLine(name+": Not enough money on account!\n");
                            account.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AccountUser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            } else {
                synchronized (account) {
                    account.deposit(amount);
                    gui.putLine(name+": Deposit "+amount+" € to account!\n");
                    gui.showBalance();
                    account.notifyAll();
                }
            }
        }

    }

}
