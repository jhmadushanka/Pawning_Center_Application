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
public class UserHandlerTest {
    
    public UserHandlerTest() {
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
     * Test of createLogin method, of class UserHandler.
     */
    @Test
    public void testCreateLogin() {
        System.out.println("createLogin");
        String username = "";
        String password = "";
        UserHandler instance = new UserHandler();
        String expResult = "";
        String result = instance.createLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTellersWithAuthenticity method, of class UserHandler.
     */
    @Test
    public void testGetTellersWithAuthenticity() {
        System.out.println("getTellersWithAuthenticity");
        String autheticity = "";
        UserHandler instance = new UserHandler();
        String[][] expResult = null;
        String[][] result = instance.getTellersWithAuthenticity(autheticity);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTellerAuthentication method, of class UserHandler.
     */
    @Test
    public void testSetTellerAuthentication() {
        System.out.println("setTellerAuthentication");
        String user_id = "";
        String authenticity = "";
        UserHandler instance = new UserHandler();
        instance.setTellerAuthentication(user_id, authenticity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ResetPassword method, of class UserHandler.
     */
    @Test
    public void testResetPassword() {
        System.out.println("ResetPassword");
        String user_id = "";
        String newpassword = "";
        UserHandler instance = new UserHandler();
        String expResult = "";
        String result = instance.ResetPassword(user_id, newpassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserDetail method, of class UserHandler.
     */
    @Test
    public void testGetUserDetail() {
        System.out.println("getUserDetail");
        String searchcriteria = "";
        String searchvalue = "";
        UserHandler instance = new UserHandler();
        String[] expResult = null;
        String[] result = instance.getUserDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertUserRecord method, of class UserHandler.
     */
    @Test
    public void testInsertUserRecord() {
        System.out.println("InsertUserRecord");
        String nic = "";
        String name = "";
        String address = "";
        String tel_num = "";
        String email = "";
        String user_id = "";
        String password = "";
        String position = "";
        boolean authenticity = false;
        UserHandler instance = new UserHandler();
        boolean expResult = false;
        boolean result = instance.InsertUserRecord(nic, name, address, tel_num, email, user_id, password, position, authenticity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserAuthentication method, of class UserHandler.
     */
    @Test
    public void testSetUserAuthentication() {
        System.out.println("setUserAuthentication");
        String user_id = "";
        String authenticity = "";
        UserHandler instance = new UserHandler();
        instance.setUserAuthentication(user_id, authenticity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
