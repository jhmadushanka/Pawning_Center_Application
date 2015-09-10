/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Access_Layer;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import sun.misc.BASE64Decoder;




/**
 *
 * @author Dell
 */
public class UserHandler {
    Connection dbconnection;
    
    public String createLogin(String username, String password){
        dbconnection = null;
        try {
             dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from user");
            
           
            
            char[] hashingpw=password.toCharArray();
           // System.out.println(hashingpw);
            char[] hashedpw= new char[64];
            String hashedpassword="";
            for(int i=0;i<hashingpw.length;i++){
               hashedpw[i]=(char) (hashingpw[i]+7);
               hashedpassword+=hashedpw[i];
            }
            password=hashedpassword;
            //System.out.println(password);
            while(MyRS.next()){
                    String uid = MyRS.getString("user_id");
                    String pw = MyRS.getString("password");
                    String authenticity=MyRS.getString("authenticity");
                    
                   
                    
                    if((pw.equals(password)) && (uid.equals(username)) && authenticity.equals("1")){
                       return MyRS.getString("position");
                    }
                    else if((uid.equals(username))){            //if password incorect or authenticity fails
                    
                        return "fail";
                    }
                }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return "fail";
        } catch (Exception ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
        return null;
        
    }
    
    
    
    //function to get tellers according to their authenticity
    
    public String[][] getTellersWithAuthenticity(String autheticity){

    String[][] tellerInfo= new String[25][4];
        
        for(int i=0; i<25; i++){
            for(int j=0;j<3;j++){
                tellerInfo[i][j]= "";   
               
            }
        }
                    
                    
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from user");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 
                    
                    
                 if(MyRS.getString("position").equals("Teller") && MyRS.getString("authenticity").equals(autheticity)){
                    //System.out.println(MyRS.getString("time_period"));
                
                    tellerInfo[i][0]= MyRS.getString("user_id");   
                    tellerInfo[i][1]= MyRS.getString("name"); 
                    tellerInfo[i][2]= MyRS.getString("nic");
                    
                     
                    
                    i++;
                   
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return tellerInfo;
                }
            }
            return tellerInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return tellerInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
            
        }
      
    }
    
    public void setTellerAuthentication(String user_id,String authenticity){
        
        
        
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE user SET authenticity = ? WHERE user_id = ? ");
 
    // set the preparedstatement parameters
                ps.setBoolean(1,Boolean.parseBoolean(authenticity));
                ps.setString(2,user_id);
 
    // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
                
            
            }
            
            catch(Exception e){
                e.printStackTrace();
                
            }
             
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            
        }
         
        finally{
            try{
              
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
    }
    
    
    
    
    
    public String ResetPassword(String user_id,String newpassword){
        
        
        
        try {
            
            
            char[] hashingpw=newpassword.toCharArray();
            //System.out.println(hashingpw);
            char[] hashedpw= new char[64];
            String hashedpassword="";
            for(int i=0;i<hashingpw.length;i++){
               hashedpw[i]=(char) (hashingpw[i]+7);
               hashedpassword+=hashedpw[i];
            }
            newpassword=hashedpassword;
            
            
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE user SET password = ? WHERE user_id = ? ");
 
    // set the preparedstatement parameters
                ps.setString(1,newpassword);
                ps.setString(2,user_id);
 
    // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
                return "Password Changed!";
                
            
            }
            
            catch(Exception e){
                e.printStackTrace();
                return "Failed to Change Password!";
                
            }
             
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return "Failed to Connect Database!";
            
        }
         
        finally{
            try{
              
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
    }
    
    
    
     public String[] getUserDetail(String searchcriteria,String searchvalue){
        String[] userInfo= new String[9];
        
                    userInfo[0]= "null";   
                    userInfo[1]= "null"; 
                    userInfo[2]= "null"; 
                    userInfo[3]= "null";  
                    userInfo[4]= "null";  
                    userInfo[5]= "null"; 
                    userInfo[6]= "null"; 
                    userInfo[7]= "null"; 
                    userInfo[8]= "null"; 
                        
                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from user");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 //System.out.println(MyRS.getString(searchcriteria));
                 if(MyRS.getString(searchcriteria).equals(searchvalue)){
                
                    userInfo[0]= MyRS.getString("nic");   
                    userInfo[1]= MyRS.getString("name"); 
                    userInfo[2]= MyRS.getString("address");
                    userInfo[3]= MyRS.getString("tel_num"); 
                    userInfo[4]= MyRS.getString("email"); 
                    userInfo[5]= MyRS.getString("user_id"); 
                    userInfo[6]= MyRS.getString("password"); 
                    userInfo[7]= MyRS.getString("position"); 
                    userInfo[8]= MyRS.getString("authenticity"); 
                    
                    return userInfo;
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return userInfo;
                }
            }
            return userInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return userInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
      
 }
    
    
    public boolean InsertUserRecord(String nic,String name, String address, String tel_num, String email,String user_id, String password, String position, boolean authenticity){
        
        
                     
         try {
             char[] hashingpw=password.toCharArray();
           // System.out.println(hashingpw);
            char[] hashedpw= new char[64];
            String hashedpassword="";
            for(int i=0;i<hashingpw.length;i++){
               hashedpw[i]=(char) (hashingpw[i]+7);
               hashedpassword+=hashedpw[i];
            }
            password=hashedpassword;
            
             
             String userInfo[]= getUserDetail("user_id", user_id);
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            //mystatement.executeQuery("INSERT INTO `customer`(`nic`, `name`, `address`, `tel_num`, `email`) VALUES ("+nic+","+name+","+address+","+tel_num+","+email+");");
             
            
            
            //customer details are not found before
            if(userInfo[0].equals("null")){
            
                String query = "INSERT INTO `user`(`nic`, `name`, `address`, `tel_num`, `email`,`user_id`,`password`,`position`,`authenticity`)"+" VALUES (?,?,?,?,?,?,?,?,?);";
 
      // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = dbconnection.prepareStatement(query);
                preparedStmt.setString(1, nic);
                preparedStmt.setString (2, name);
                preparedStmt.setString(3, address);
                preparedStmt.setString(4, tel_num);
                preparedStmt.setString(5, email);
                preparedStmt.setString(6, user_id);
                preparedStmt.setString(7, password);
                preparedStmt.setString(8, position);
                preparedStmt.setBoolean(9, authenticity);
 
      // execute the preparedstatement
                preparedStmt.execute();
            
                return true;    
            
            }
      // if customer transact previously so it should update previous customer data
            else
            {
            
                
                return false;
            
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
    
    // to update authenticity of teller, officer, manager
    public void setUserAuthentication(String user_id, String authenticity){
        
        
        
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE user SET authenticity = ? WHERE user_id = ? ");
 
    // set the preparedstatement parameters
                ps.setBoolean(1,Boolean.parseBoolean(authenticity));
                ps.setString(2,user_id);
 
    // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
                
            
            }
            
            catch(Exception e){
                e.printStackTrace();
                
            }
             
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            
        }
         
        finally{
            try{
              
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
    }
    
    
    
}
    
    
    
    


