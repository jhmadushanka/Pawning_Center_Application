/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain_Layer;

import java.sql.Time;
import java.util.Date;
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
public class TransactionTest {
    
    public TransactionTest() {
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
     * Test of setId method, of class Transaction.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id1 = 0;
        Transaction instance = null;
        instance.setId(id1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccount_num method, of class Transaction.
     */
    @Test
    public void testSetAccount_num() {
        System.out.println("setAccount_num");
        int ac_num1 = 0;
        Transaction instance = null;
        instance.setAccount_num(ac_num1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Transaction.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date1 = null;
        Transaction instance = null;
        instance.setDate(date1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Transaction.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        Time time1 = null;
        Transaction instance = null;
        instance.setTime(time1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStaff_id method, of class Transaction.
     */
    @Test
    public void testSetStaff_id() {
        System.out.println("setStaff_id");
        String staff_id1 = "";
        Transaction instance = null;
        instance.setStaff_id(staff_id1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesciption method, of class Transaction.
     */
    @Test
    public void testSetDesciption() {
        System.out.println("setDesciption");
        String description1 = "";
        Transaction instance = null;
        instance.setDesciption(description1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCredit method, of class Transaction.
     */
    @Test
    public void testSetCredit() {
        System.out.println("setCredit");
        double credit1 = 0.0;
        Transaction instance = null;
        instance.setCredit(credit1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebit method, of class Transaction.
     */
    @Test
    public void testSetDebit() {
        System.out.println("setDebit");
        double debit1 = 0.0;
        Transaction instance = null;
        instance.setDebit(debit1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Transaction.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Transaction instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount_num method, of class Transaction.
     */
    @Test
    public void testGetAccount_num() {
        System.out.println("getAccount_num");
        Transaction instance = null;
        int expResult = 0;
        int result = instance.getAccount_num();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Transaction.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Transaction instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime method, of class Transaction.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        Transaction instance = null;
        Time expResult = null;
        Time result = instance.getTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStaff_id method, of class Transaction.
     */
    @Test
    public void testGetStaff_id() {
        System.out.println("getStaff_id");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getStaff_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesciption method, of class Transaction.
     */
    @Test
    public void testGetDesciption() {
        System.out.println("getDesciption");
        Transaction instance = null;
        String expResult = "";
        String result = instance.getDesciption();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCredit method, of class Transaction.
     */
    @Test
    public void testGetCredit() {
        System.out.println("getCredit");
        Transaction instance = null;
        double expResult = 0.0;
        double result = instance.getCredit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebit method, of class Transaction.
     */
    @Test
    public void testGetDebit() {
        System.out.println("getDebit");
        Transaction instance = null;
        double expResult = 0.0;
        double result = instance.getDebit();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
