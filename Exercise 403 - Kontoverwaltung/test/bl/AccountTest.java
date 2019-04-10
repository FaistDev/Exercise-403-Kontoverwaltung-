/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Ben
 */
@RunWith(value = Parameterized.class)
public class AccountTest {

    @Parameterized.Parameter(value = 0)
    public double amount;
    
    @Parameterized.Parameter(value = 1)
    public double result;

    public AccountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Parameterized.Parameters(name = "")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
            {20.0, 30.0},
            {15.0, 35.0},
            {10.0, 45.0}
        });
    }

    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        Account instance = new Account(50.0);
        instance.withdraw(amount);
        double res = instance.getAmount();
        assertEquals(result, res,0.0);
    }

    /**
     * Test of deposit method, of class Account.
     */
   

}
