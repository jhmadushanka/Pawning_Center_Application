/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class InterestHandlerTest {
    
    public InterestHandlerTest() {
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

    /**
     * Test of getIntersetRate method, of class InterestHandler.
     */
    @Test
    public void testGetIntersetRate() {
        System.out.println("getIntersetRate");
        int period = 0;
        InterestHandler instance = new InterestHandler();
        double expResult = 0.0;
        double result = instance.getIntersetRate(period);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewInterestRate method, of class InterestHandler.
     */
    @Test
    public void testSetNewInterestRate() {
        System.out.println("setNewInterestRate");
        int period = 0;
        double new_interest_rate = 0.0;
        InterestHandler instance = new InterestHandler();
        boolean expResult = false;
        boolean result = instance.setNewInterestRate(period, new_interest_rate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
