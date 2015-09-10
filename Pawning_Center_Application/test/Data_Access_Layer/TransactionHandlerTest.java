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
public class TransactionHandlerTest {
    
    public TransactionHandlerTest() {
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
     * Test of convertJavaDateToSqlDate method, of class TransactionHandler.
     */
    @Test
    public void testConvertJavaDateToSqlDate() {
        System.out.println("convertJavaDateToSqlDate");
        Date date = null;
        TransactionHandler instance = new TransactionHandler();
        java.sql.Date expResult = null;
        java.sql.Date result = instance.convertJavaDateToSqlDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRecordsToTransactionTable method, of class TransactionHandler.
     */
    @Test
    public void testInsertRecordsToTransactionTable() {
        System.out.println("insertRecordsToTransactionTable");
        String ac_num = "";
        String description = "";
        Date date = null;
        String time = "";
        String userid = "";
        double credit = 0.0;
        double debit = 0.0;
        TransactionHandler instance = new TransactionHandler();
        boolean expResult = false;
        boolean result = instance.insertRecordsToTransactionTable(ac_num, description, date, time, userid, credit, debit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxTransactionID method, of class TransactionHandler.
     */
    @Test
    public void testGetMaxTransactionID() {
        System.out.println("getMaxTransactionID");
        TransactionHandler instance = new TransactionHandler();
        int expResult = 0;
        int result = instance.getMaxTransactionID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTellerTransactions method, of class TransactionHandler.
     */
    @Test
    public void testGetTellerTransactions() {
        System.out.println("getTellerTransactions");
        TransactionHandler instance = new TransactionHandler();
        String[][] expResult = null;
        String[][] result = instance.getTellerTransactions();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofCredits method, of class TransactionHandler.
     */
    @Test
    public void testGetSumofCredits() {
        System.out.println("getSumofCredits");
        String username = "";
        TransactionHandler instance = new TransactionHandler();
        double expResult = 0.0;
        double result = instance.getSumofCredits(username);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofDebits method, of class TransactionHandler.
     */
    @Test
    public void testGetSumofDebits() {
        System.out.println("getSumofDebits");
        String username = "";
        TransactionHandler instance = new TransactionHandler();
        double expResult = 0.0;
        double result = instance.getSumofDebits(username);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthTransactions method, of class TransactionHandler.
     */
    @Test
    public void testGetMonthTransactions() {
        System.out.println("getMonthTransactions");
        String subdate = "";
        TransactionHandler instance = new TransactionHandler();
        String[][] expResult = null;
        String[][] result = instance.getMonthTransactions(subdate);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofMonthlyCredits method, of class TransactionHandler.
     */
    @Test
    public void testGetSumofMonthlyCredits() {
        System.out.println("getSumofMonthlyCredits");
        String subdate = "";
        TransactionHandler instance = new TransactionHandler();
        double expResult = 0.0;
        double result = instance.getSumofMonthlyCredits(subdate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofMonthlyDebits method, of class TransactionHandler.
     */
    @Test
    public void testGetSumofMonthlyDebits() {
        System.out.println("getSumofMonthlyDebits");
        String subdate = "";
        TransactionHandler instance = new TransactionHandler();
        double expResult = 0.0;
        double result = instance.getSumofMonthlyDebits(subdate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountTransactions method, of class TransactionHandler.
     */
    @Test
    public void testGetAccountTransactions() {
        System.out.println("getAccountTransactions");
        int ac_num = 0;
        TransactionHandler instance = new TransactionHandler();
        String[][] expResult = null;
        String[][] result = instance.getAccountTransactions(ac_num);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
