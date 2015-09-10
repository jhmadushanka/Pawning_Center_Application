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
public class AccountTest {
    
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

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id1 = 0;
        Account instance = new Account();
        instance.setId(id1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCustomer_nic method, of class Account.
     */
    @Test
    public void testSetCustomer_nic() {
        System.out.println("setCustomer_nic");
        String cus_nic1 = "";
        Account instance = new Account();
        instance.setCustomer_nic(cus_nic1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPawnid method, of class Account.
     */
    @Test
    public void testSetPawnid() {
        System.out.println("setPawnid");
        int pawnid1 = 0;
        Account instance = new Account();
        instance.setPawnid(pawnid1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInit_date method, of class Account.
     */
    @Test
    public void testSetInit_date() {
        System.out.println("setInit_date");
        Date init_date1 = null;
        Account instance = new Account();
        instance.setInit_date(init_date1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInit_time method, of class Account.
     */
    @Test
    public void testSetInit_time() {
        System.out.println("setInit_time");
        Time init_time1 = null;
        Account instance = new Account();
        instance.setInit_time(init_time1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime_Period method, of class Account.
     */
    @Test
    public void testSetTime_Period() {
        System.out.println("setTime_Period");
        int time_period1 = 0;
        Account instance = new Account();
        instance.setTime_Period(time_period1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClosedate method, of class Account.
     */
    @Test
    public void testSetClosedate() {
        System.out.println("setClosedate");
        Date close_date1 = null;
        Account instance = new Account();
        instance.setClosedate(close_date1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class Account.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        boolean availability1 = false;
        Account instance = new Account();
        instance.setAvailability(availability1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAllowance method, of class Account.
     */
    @Test
    public void testSetAllowance() {
        System.out.println("setAllowance");
        double allowance1 = 0.0;
        Account instance = new Account();
        instance.setAllowance(allowance1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInstallment method, of class Account.
     */
    @Test
    public void testSetInstallment() {
        System.out.println("setInstallment");
        double installment1 = 0.0;
        Account instance = new Account();
        instance.setInstallment(installment1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInit_lack method, of class Account.
     */
    @Test
    public void testSetInit_lack() {
        System.out.println("setInit_lack");
        double init_lack1 = 0.0;
        Account instance = new Account();
        instance.setInit_lack(init_lack1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_lack method, of class Account.
     */
    @Test
    public void testSetCurrent_lack() {
        System.out.println("setCurrent_lack");
        double current_lack1 = 0.0;
        Account instance = new Account();
        instance.setCurrent_lack(current_lack1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer_nic method, of class Account.
     */
    @Test
    public void testGetCustomer_nic() {
        System.out.println("getCustomer_nic");
        Account instance = new Account();
        String expResult = "";
        String result = instance.getCustomer_nic();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPawnid method, of class Account.
     */
    @Test
    public void testGetPawnid() {
        System.out.println("getPawnid");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getPawnid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInit_date method, of class Account.
     */
    @Test
    public void testGetInit_date() {
        System.out.println("getInit_date");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getInit_date();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInit_time method, of class Account.
     */
    @Test
    public void testGetInit_time() {
        System.out.println("getInit_time");
        Account instance = new Account();
        Time expResult = null;
        Time result = instance.getInit_time();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTime_Period method, of class Account.
     */
    @Test
    public void testGetTime_Period() {
        System.out.println("getTime_Period");
        Account instance = new Account();
        int expResult = 0;
        int result = instance.getTime_Period();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClosedate method, of class Account.
     */
    @Test
    public void testGetClosedate() {
        System.out.println("getClosedate");
        Account instance = new Account();
        Date expResult = null;
        Date result = instance.getClosedate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailability method, of class Account.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        Account instance = new Account();
        boolean expResult = false;
        boolean result = instance.getAvailability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowance method, of class Account.
     */
    @Test
    public void testGetAllowance() {
        System.out.println("getAllowance");
        Account instance = new Account();
        double expResult = 0.0;
        double result = instance.getAllowance();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInstallment method, of class Account.
     */
    @Test
    public void testGetInstallment() {
        System.out.println("getInstallment");
        Account instance = new Account();
        double expResult = 0.0;
        double result = instance.getInstallment();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInit_lack method, of class Account.
     */
    @Test
    public void testGetInit_lack() {
        System.out.println("getInit_lack");
        Account instance = new Account();
        double expResult = 0.0;
        double result = instance.getInit_lack();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent_lack method, of class Account.
     */
    @Test
    public void testGetCurrent_lack() {
        System.out.println("getCurrent_lack");
        Account instance = new Account();
        double expResult = 0.0;
        double result = instance.getCurrent_lack();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccontDetail method, of class Account.
     */
    @Test
    public void testGetAccontDetail() {
        System.out.println("getAccontDetail");
        String searchcriteria = "";
        String searchvalue = "";
        Account instance = new Account();
        String[] expResult = null;
        String[] result = instance.getAccontDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
