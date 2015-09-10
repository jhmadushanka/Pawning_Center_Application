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
public class CustomerHandler {
    Connection dbconnection=null;
    public String[] getCustomerDetail(String searchcriteria,String searchvalue){
        String[] customerInfo= new String[5];
        
                    customerInfo[0]= "null";   
                    customerInfo[1]= "null"; 
                    customerInfo[2]= "null"; 
                    customerInfo[3]= "null";  
                    customerInfo[4]= "null";  
                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from customer");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 //System.out.println(MyRS.getString(searchcriteria));
                 if(MyRS.getString(searchcriteria).equals(searchvalue)){
                
                    customerInfo[0]= MyRS.getString("nic");   
                    customerInfo[1]= MyRS.getString("name"); 
                    customerInfo[2]= MyRS.getString("address");
                    customerInfo[3]= MyRS.getString("tel_num"); 
                    customerInfo[4]= MyRS.getString("email"); 
                    
                    
                    return customerInfo;
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return customerInfo;
                }
            }
            return customerInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return customerInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
      
 }
    
    
    //function to insert records to the table customer
    
    public boolean InsertCustomerRecord(String nic,String name, String address, String tel_num, String email){
        
                     
         try {
             
             String customerInfo[]= getCustomerDetail("nic", nic);
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            //mystatement.executeQuery("INSERT INTO `customer`(`nic`, `name`, `address`, `tel_num`, `email`) VALUES ("+nic+","+name+","+address+","+tel_num+","+email+");");
             
            
            
            //customer details are not found before
            if(customerInfo[0].equals("null")){
            
                String query = "INSERT INTO `customer`(`nic`, `name`, `address`, `tel_num`, `email`)"+" VALUES (?,?,?,?,?);";
 
      // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = dbconnection.prepareStatement(query);
                preparedStmt.setString(1, nic);
                preparedStmt.setString (2, name);
                preparedStmt.setString(3, address);
                preparedStmt.setString(4, tel_num);
                preparedStmt.setString(5, email);
 
      // execute the preparedstatement
                preparedStmt.execute();
            
                return true;    
            
            }
      // if customer transact previously so it should update previous customer data
            else
            {
            
                PreparedStatement ps = dbconnection.prepareStatement("UPDATE customer SET name = ?, address = ? , tel_num = ? , email = ? WHERE nic = ? ");
 
    // set the preparedstatement parameters
                ps.setString(1,name);
                ps.setString(2,address);
                ps.setString(3,tel_num);
                ps.setString(4,email);
                ps.setString(5, nic);
 
    // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
                return true;
            
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
                    
            return false;
                
        }   
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
      
 }
    
}
