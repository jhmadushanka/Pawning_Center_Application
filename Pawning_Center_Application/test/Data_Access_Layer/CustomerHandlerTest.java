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
public class CustomerHandlerTest {
    
    public CustomerHandlerTest() {
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
     * Test of getCustomerDetail method, of class CustomerHandler.
     */
    @Test
    public void testGetCustomerDetail() {
        System.out.println("getCustomerDetail");
        String searchcriteria = "";
        String searchvalue = "";
        CustomerHandler instance = new CustomerHandler();
        String[] expResult = null;
        String[] result = instance.getCustomerDetail(searchcriteria, searchvalue);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InsertCustomerRecord method, of class CustomerHandler.
     */
    @Test
    public void testInsertCustomerRecord() {
        System.out.println("InsertCustomerRecord");
        String nic = "";
        String name = "";
        String address = "";
        String tel_num = "";
        String email = "";
        CustomerHandler instance = new CustomerHandler();
        boolean expResult = false;
        boolean result = instance.InsertCustomerRecord(nic, name, address, tel_num, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
