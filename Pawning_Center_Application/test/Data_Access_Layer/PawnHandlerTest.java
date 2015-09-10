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
public class PawnHandlerTest {
    
    public PawnHandlerTest() {
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
     * Test of getMaxPawnID method, of class PawnHandler.
     */
    @Test
    public void testGetMaxPawnID() {
        System.out.println("getMaxPawnID");
        PawnHandler instance = new PawnHandler();
        int expResult = 0;
        int result = instance.getMaxPawnID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertPawnRecord method, of class PawnHandler.
     */
    @Test
    public void testInsertPawnRecord() {
        System.out.println("InsertPawnRecord");
        int id = 0;
        String description = "";
        double weight = 0.0;
        double assess_value = 0.0;
        boolean availability = false;
        PawnHandler instance = new PawnHandler();
        boolean expResult = false;
        boolean result = instance.InsertPawnRecord(id, description, weight, assess_value, availability);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPawnAvailability method, of class PawnHandler.
     */
    @Test
    public void testSetPawnAvailability() {
        System.out.println("setPawnAvailability");
        String pawnid = "";
        boolean availability = false;
        PawnHandler instance = new PawnHandler();
        boolean expResult = false;
        boolean result = instance.setPawnAvailability(pawnid, availability);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
