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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Dell
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Domain_Layer.PawnTest.class, Domain_Layer.AccountTest.class, Domain_Layer.TransactionTest.class, Domain_Layer.CustomerTest.class, Domain_Layer.Pawning_Center_ApplicationTest.class, Domain_Layer.UserTest.class})
public class Domain_LayerSuite {

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
