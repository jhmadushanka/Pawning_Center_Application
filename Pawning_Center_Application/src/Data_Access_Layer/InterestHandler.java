/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class InterestHandler {
    Connection dbconnection = null;
    public double getIntersetRate(int period){
        
        try {
             dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from interest_rate");
           
            while(MyRS.next()){
                    int month_period = Integer.parseInt(MyRS.getString("period"));
                    double int_rate = Double.parseDouble(MyRS.getString("interest_rate"));
                    if(month_period==period){
                        
                       return int_rate;
                    }
                   
                }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return 0;
        }
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
        return 0;
        
    }
    
    
    
    
   
    // method to change interest rate at the database table
    public boolean setNewInterestRate(int period,double new_interest_rate){
    
        
        
     
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE interest_rate SET interest_rate = ? WHERE period = ? ");
 
    // set the preparedstatement parameters
                ps.setDouble(1,new_interest_rate);
                ps.setInt(2,period);
 
    // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
                return true;
            
            }
            
            catch(Exception e){
                e.printStackTrace();
                return false;
            }
             
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return false;
        }
         
        finally{
            try{
              
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
     }
    
    
    
    
    
    
}
