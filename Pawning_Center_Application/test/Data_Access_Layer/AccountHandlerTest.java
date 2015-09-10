/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

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
public class AccountHandlerTest {
    
    public AccountHandlerTest() {
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
     * Test of getAccountDetail method, of class AccountHandler.
     */
    @Test
    public void testGetAccountDetail() {
        System.out.println("getAccountDetail");
        String searchcriteria = "";
        String searchvalue = "";
        AccountHandler instance = new AccountHandler();
        String[] expResult = null;
        String[] result = instance.getAccountDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getMaxAccountID method, of class AccountHandler.
     */
    @Test
    public void testGetMaxAccountID() {
        System.out.println("getMaxAccountID");
        AccountHandler instance = new AccountHandler();
        int expResult = 1001005;
        int result = instance.getMaxAccountID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
    }

    /**
     * Test of InsertAccountRecord method, of class AccountHandler.
     */
    @Test
    public void testInsertAccountRecord() {
        System.out.println("InsertAccountRecord");
        int id = 1001006;
        String cus_nic = "912601218V";
        int pawn_id = 1006;
        Date init_date = new Date();
        String init_time = "";
        int time_period = 12;
        Date close_date = new Date();
        boolean availability = false;
        double allowance = 60000;
        double installment = 5500;
        double init_balance = -66000;
        double current_balance = -66000;
        AccountHandler instance = new AccountHandler();
        boolean expResult = false;
        boolean result = instance.InsertAccountRecord(id, cus_nic, pawn_id, init_date, init_time, time_period, close_date, availability, allowance, installment, init_balance, current_balance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of convertJavaDateToSqlDate method, of class AccountHandler.
     */
    @Test
    public void testConvertJavaDateToSqlDate() {
        System.out.println("convertJavaDateToSqlDate");
        Date date = null;
        AccountHandler instance = new AccountHandler();
        java.sql.Date expResult = null;
        java.sql.Date result = instance.convertJavaDateToSqlDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
        
    }

    /**
     * Test of getAccountDetailstoActivate method, of class AccountHandler.
     */
    @Test
    public void testGetAccountDetailstoActivate() {
        System.out.println("getAccountDetailstoActivate");
        AccountHandler instance = new AccountHandler();
        String[][] expResult = null;
        String[][] result = instance.getAccountDetailstoActivate();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
    }

    /**
     * Test of updateAccountBalance method, of class AccountHandler.
     */
    @Test
    public void testUpdateAccountBalance() {
        System.out.println("updateAccountBalance");
        int ac_num = 0;
        double new_balance = 0.0;
        AccountHandler instance = new AccountHandler();
        boolean expResult = false;
        boolean result = instance.updateAccountBalance(ac_num, new_balance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
        
    }

    /**
     * Test of activeAccount method, of class AccountHandler.
     */
    @Test
    public void testActiveAccount() {
        System.out.println("activeAccount");
        int ac_num = 0;
        AccountHandler instance = new AccountHandler();
        instance.activeAccount(ac_num);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setAccountAvailability method, of class AccountHandler.
     */
    @Test
    public void testSetAccountAvailability() {
        System.out.println("setAccountAvailability");
        String ac_num = "";
        boolean availability = false;
        AccountHandler instance = new AccountHandler();
        boolean expResult = false;
        boolean result = instance.setAccountAvailability(ac_num, availability);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getCriticalAccount method, of class AccountHandler.
     */
    @Test
    public void testGetCriticalAccount() {
        System.out.println("getCriticalAccount");
        Date date = null;
        AccountHandler instance = new AccountHandler();
        String[][] expResult = null;
        String[][] result = instance.getCriticalAccount(date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllActivatedAccountDetails method, of class AccountHandler.
     */
    @Test
    public void testGetAllActivatedAccountDetails() {
        System.out.println("getAllActivatedAccountDetails");
        AccountHandler instance = new AccountHandler();
        String[][] expResult = null;
        String[][] result = instance.getAllActivatedAccountDetails();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
        
    }

    /**
     * Test of updateLastNotificationDate method, of class AccountHandler.
     */
    @Test
    public void testUpdateLastNotificationDate() {
        System.out.println("updateLastNotificationDate");
        int ac_id = 0;
        Date date = null;
        AccountHandler instance = new AccountHandler();
        instance.updateLastNotificationDate(ac_id, date);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
