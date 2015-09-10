/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain_Layer;

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
public class Pawning_Center_ApplicationTest {
    
    public Pawning_Center_ApplicationTest() {
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
     * Test of main method, of class Pawning_Center_Application.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Pawning_Center_Application.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createLogin method, of class Pawning_Center_Application.
     */
    @Test
    public void testCreateLogin() {
        System.out.println("createLogin");
        String username = "";
        String password = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.createLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxPawnID method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetMaxPawnID() {
        System.out.println("getMaxPawnID");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        int expResult = 0;
        int result = instance.getMaxPawnID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxAccountID method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetMaxAccountID() {
        System.out.println("getMaxAccountID");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        int expResult = 0;
        int result = instance.getMaxAccountID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntersetRate method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetIntersetRate() {
        System.out.println("getIntersetRate");
        int period = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getIntersetRate(period);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccontDetail method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetAccontDetail() {
        System.out.println("getAccontDetail");
        String searchcriteria = "";
        String searchvalue = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[] expResult = null;
        String[] result = instance.getAccontDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCloseDate method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetCloseDate() {
        System.out.println("getCloseDate");
        Date date = null;
        int period = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        Date expResult = null;
        Date result = instance.getCloseDate(date, period);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCstomerDetail method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetCstomerDetail() {
        System.out.println("getCstomerDetail");
        String searchcriteria = "";
        String searchvalue = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[] expResult = null;
        String[] result = instance.getCstomerDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateInitLack method, of class Pawning_Center_Application.
     */
    @Test
    public void testCalculateInitLack() {
        System.out.println("calculateInitLack");
        double allowance = 0.0;
        double interest_rate = 0.0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.calculateInitLack(allowance, interest_rate);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateInstallment method, of class Pawning_Center_Application.
     */
    @Test
    public void testCalculateInstallment() {
        System.out.println("calculateInstallment");
        double allowance = 0.0;
        double interest_rate = 0.0;
        int period = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.calculateInstallment(allowance, interest_rate, period);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewAccount method, of class Pawning_Center_Application.
     */
    @Test
    public void testCreateNewAccount() {
        System.out.println("createNewAccount");
        String nic = "";
        String name = "";
        String address = "";
        String tel_num = "";
        String email = "";
        int pawn_id = 0;
        String description = "";
        double weight = 0.0;
        double assess_value = 0.0;
        int account_id = 0;
        Date init_date = null;
        String init_time = "";
        int time_period = 0;
        Date close_date = null;
        double allowance = 0.0;
        double installment = 0.0;
        double init_balance = 0.0;
        double current_balance = 0.0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        boolean expResult = false;
        boolean result = instance.createNewAccount(nic, name, address, tel_num, email, pawn_id, description, weight, assess_value, account_id, init_date, init_time, time_period, close_date, allowance, installment, init_balance, current_balance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountDetailstoActivate method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetAccountDetailstoActivate() {
        System.out.println("getAccountDetailstoActivate");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getAccountDetailstoActivate();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTellerTransactions method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetTellerTransactions() {
        System.out.println("getTellerTransactions");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getTellerTransactions();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creditAccount method, of class Pawning_Center_Application.
     */
    @Test
    public void testCreditAccount() {
        System.out.println("creditAccount");
        String ac_num = "";
        String description = "";
        double amount = 0.0;
        Date date = null;
        String time = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.creditAccount(ac_num, description, amount, date, time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DebitAccount method, of class Pawning_Center_Application.
     */
    @Test
    public void testDebitAccount() {
        System.out.println("DebitAccount");
        String ac_num = "";
        String description = "";
        double amount = 0.0;
        Date date = null;
        String time = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.DebitAccount(ac_num, description, amount, date, time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofCredits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofCredits_0args() {
        System.out.println("getSumofCredits");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofCredits();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofCredits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofCredits_String() {
        System.out.println("getSumofCredits");
        String username = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofCredits(username);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofDebits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofDebits_0args() {
        System.out.println("getSumofDebits");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofDebits();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofDebits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofDebits_String() {
        System.out.println("getSumofDebits");
        String username = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofDebits(username);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of activeAccount method, of class Pawning_Center_Application.
     */
    @Test
    public void testActiveAccount() {
        System.out.println("activeAccount");
        int ac_num = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        instance.activeAccount(ac_num);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeactiveAccount method, of class Pawning_Center_Application.
     */
    @Test
    public void testDeactiveAccount() {
        System.out.println("DeactiveAccount");
        String acNumber = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        boolean expResult = false;
        boolean result = instance.DeactiveAccount(acNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterestRate method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetInterestRate() {
        System.out.println("getInterestRate");
        int period = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getInterestRate(period);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewInterestRate method, of class Pawning_Center_Application.
     */
    @Test
    public void testSetNewInterestRate() {
        System.out.println("setNewInterestRate");
        int period = 0;
        double new_interest_rate = 0.0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        boolean expResult = false;
        boolean result = instance.setNewInterestRate(period, new_interest_rate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivatedTellers method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetActivatedTellers() {
        System.out.println("getActivatedTellers");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getActivatedTellers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeactivatedTellers method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetDeactivatedTellers() {
        System.out.println("getDeactivatedTellers");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getDeactivatedTellers();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTellerAuthenticationtoActivate method, of class Pawning_Center_Application.
     */
    @Test
    public void testSetTellerAuthenticationtoActivate() {
        System.out.println("setTellerAuthenticationtoActivate");
        String user_id = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        instance.setTellerAuthenticationtoActivate(user_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTellerAuthenticationtoDeactivate method, of class Pawning_Center_Application.
     */
    @Test
    public void testSetTellerAuthenticationtoDeactivate() {
        System.out.println("setTellerAuthenticationtoDeactivate");
        String user_id = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        instance.setTellerAuthenticationtoDeactivate(user_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMonthTransactions method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetMonthTransactions() {
        System.out.println("getMonthTransactions");
        String subdate = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getMonthTransactions(subdate);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofMonthlyCredits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofMonthlyCredits() {
        System.out.println("getSumofMonthlyCredits");
        String sub_date = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofMonthlyCredits(sub_date);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSumofMonthlyDebits method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetSumofMonthlyDebits() {
        System.out.println("getSumofMonthlyDebits");
        String sub_date = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        double expResult = 0.0;
        double result = instance.getSumofMonthlyDebits(sub_date);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccountTransactions method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetAccountTransactions() {
        System.out.println("getAccountTransactions");
        int ac_num = 0;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getAccountTransactions(ac_num);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCriticalAccounts method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetCriticalAccounts() {
        System.out.println("getCriticalAccounts");
        Date date = null;
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[][] expResult = null;
        String[][] result = instance.getCriticalAccounts(date);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of change_password method, of class Pawning_Center_Application.
     */
    @Test
    public void testChange_password() {
        System.out.println("change_password");
        String user_id = "";
        String oldpw = "";
        String newpw = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.change_password(user_id, oldpw, newpw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInfo method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetUserInfo() {
        System.out.println("getUserInfo");
        String searchcriteria = "";
        String searchvalue = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String[] expResult = null;
        String[] result = instance.getUserInfo(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUsers method, of class Pawning_Center_Application.
     */
    @Test
    public void testAddUsers() {
        System.out.println("addUsers");
        String nic = "";
        String name = "";
        String address = "";
        String tel_num = "";
        String email = "";
        String user_id = "";
        String position = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.addUsers(nic, name, address, tel_num, email, user_id, position);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveUser method, of class Pawning_Center_Application.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("RemoveUser");
        String userid = "";
        Pawning_Center_Application instance = new Pawning_Center_Application();
        instance.RemoveUser(userid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxTransactionID method, of class Pawning_Center_Application.
     */
    @Test
    public void testGetMaxTransactionID() {
        System.out.println("getMaxTransactionID");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        String expResult = "";
        String result = instance.getMaxTransactionID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendNotificationsofAccountDetails method, of class Pawning_Center_Application.
     */
    @Test
    public void testSendNotificationsofAccountDetails() throws Exception {
        System.out.println("sendNotificationsofAccountDetails");
        Pawning_Center_Application instance = new Pawning_Center_Application();
        instance.sendNotificationsofAccountDetails();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
