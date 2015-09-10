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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Dell
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Data_Access_Layer.PawnHandlerTest.class, Data_Access_Layer.UserHandlerTest.class, Data_Access_Layer.TransactionHandlerTest.class, Data_Access_Layer.AccountHandlerTest.class, Data_Access_Layer.CustomerHandlerTest.class, Data_Access_Layer.InterestHandlerTest.class})
public class Data_Access_LayerSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
