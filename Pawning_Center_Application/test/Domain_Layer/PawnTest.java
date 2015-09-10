/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain_Layer;

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
public class PawnTest {
    
    public PawnTest() {
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
     * Test of setId method, of class Pawn.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id1 = 0;
        Pawn instance = null;
        instance.setId(id1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Pawn.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description1 = "";
        Pawn instance = null;
        instance.setDescription(description1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class Pawn.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        double weight1 = 0.0;
        Pawn instance = null;
        instance.setWeight(weight1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAssess_value method, of class Pawn.
     */
    @Test
    public void testSetAssess_value() {
        System.out.println("setAssess_value");
        double assess_value1 = 0.0;
        Pawn instance = null;
        instance.setAssess_value(assess_value1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailablity method, of class Pawn.
     */
    @Test
    public void testSetAvailablity() {
        System.out.println("setAvailablity");
        boolean availability1 = false;
        Pawn instance = null;
        instance.setAvailablity(availability1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Pawn.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Pawn instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Pawn.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Pawn instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class Pawn.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Pawn instance = null;
        double expResult = 0.0;
        double result = instance.getWeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAssess_value method, of class Pawn.
     */
    @Test
    public void testGetAssess_value() {
        System.out.println("getAssess_value");
        Pawn instance = null;
        double expResult = 0.0;
        double result = instance.getAssess_value();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailablity method, of class Pawn.
     */
    @Test
    public void testGetAvailablity() {
        System.out.println("getAvailablity");
        Pawn instance = null;
        boolean expResult = false;
        boolean result = instance.getAvailablity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
