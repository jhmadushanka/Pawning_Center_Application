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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class AccountHandler {
    
    //method to access table account in database
    Connection dbconnection=null;
    public String[] getAccountDetail(String searchcriteria,String searchvalue){
        String[] accountInfo= new String[13];
        
                    accountInfo[0]= "null";   
                    accountInfo[1]= "null"; 
                    accountInfo[2]= "null"; 
                    accountInfo[3]= "null";  
                    accountInfo[4]= "null";  
                    accountInfo[5]= "null";  
                    accountInfo[6]= "null";  
                    accountInfo[7]= "null";  
                    accountInfo[8]= "null";  
                    accountInfo[9]= "null"; 
                    accountInfo[10]= "null"; 
                    accountInfo[11]= "null"; 
                    accountInfo[12]= "null"; 
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from account");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 //System.out.println(MyRS.getString(searchcriteria));
                 if(MyRS.getString(searchcriteria).equals(searchvalue)){
                    //System.out.println(MyRS.getString("time_period"));
                
                    accountInfo[0]= MyRS.getString("id");   
                    accountInfo[1]= MyRS.getString("cus_nic"); 
                    accountInfo[2]= MyRS.getString("pawn_id");
                    accountInfo[3]= MyRS.getString("init_date"); 
                    accountInfo[4]= MyRS.getString("init_time"); 
                    accountInfo[5]= MyRS.getString("time_period"); 
                    accountInfo[6]= MyRS.getString("close_date"); 
                    accountInfo[7]= MyRS.getString("availability"); 
                    accountInfo[8]= MyRS.getString("allowance"); 
                    accountInfo[9]= MyRS.getString("installment");
                    accountInfo[10]= MyRS.getString("init_balance");
                    accountInfo[11]= MyRS.getString("current_balance");
                    accountInfo[12]= MyRS.getString("last_notification");
                    
                    return accountInfo;
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return accountInfo;
                }
            }
            return accountInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return accountInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
        }
      
        
    }
    
    
    
    
    //fuction to get or predict next account number
    
    public int getMaxAccountID(){
        
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select max(id) as ID from account");
       
            while(MyRS.next()){
                try{
                    int maxid = Integer.parseInt(MyRS.getString("ID")); 
                    return maxid;
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return 0;
                }
            }
            return 0;
             
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
      
        
    }
    
    
    
    
    
    //function to insert records to the table account in the database
    
     public boolean InsertAccountRecord(int id,String cus_nic, int pawn_id, Date init_date, String init_time,int time_period, Date close_date,boolean availability,double allowance,double installment, double init_balance, double current_balance){
        
                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // mystatement.executeQuery("INSERT INTO `account`(`id`, `cus_nic`, `pawn_id`, `init_date`, `init_time`, `time_period`, `close_date`, `availability`, `allowance`, `installment`, `init_lack`, `current_lack`) VALUES (`"+id+"`, `"+cus_nic+"`, `"+pawn_id+"`, `"+init_date+"`, `"+init_time+"`, `"+time_period+"`, `"+close_date+"`, `"+availability+"`, `"+allowance+"`, `"+installment+"`, `"+init_lack+"`, `"+current_lack+"`);");
             
            
             String query = "INSERT INTO `account` (`id`, `cus_nic`, `pawn_id`, `init_date`, `init_time`, `time_period`, `close_date`, `availability`, `allowance`, `installment`, `init_balance`, `current_balance`,`last_notification`)"+" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
 
      // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = dbconnection.prepareStatement(query);
                preparedStmt.setInt(1, id);
                preparedStmt.setString (2, cus_nic);
                preparedStmt.setInt(3,pawn_id );
                
                java.sql.Date init_date2,close_date2;
                
                init_date2=this.convertJavaDateToSqlDate(init_date);
                close_date2=this.convertJavaDateToSqlDate(close_date);
                
                preparedStmt.setDate(4, init_date2);
                preparedStmt.setString(5, init_time);
                preparedStmt.setInt(6, time_period);
                preparedStmt.setDate(7, close_date2);
                preparedStmt.setBoolean(8, availability);
                preparedStmt.setDouble(9, allowance);
                preparedStmt.setDouble(10, installment);
                preparedStmt.setDouble(11, init_balance);
                preparedStmt.setDouble(12, current_balance);
                preparedStmt.setDate(13, init_date2);
 
      // execute the preparedstatement
                preparedStmt.execute();
            
                return true;    
                
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
     
     //function to convert util date to sql date
     public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
                    return new java.sql.Date(date.getTime());
                }   
     
     
     
   // to get account details to activate accounts  
     
     public String[][] getAccountDetailstoActivate(){
        String[][] accountInfo= new String[25][6];
        
        for(int i=0; i<25; i++){
            for(int j=0;j<6;j++){
                accountInfo[i][j]= "null";   
               
            }
        }
                    
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today= dateFormat.format(date); 
                    
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from account");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 
                    
                    
                 if(MyRS.getString("init_date").equals(today) && MyRS.getString("availability").equals("0")){
                    //System.out.println(MyRS.getString("time_period"));
                
                    accountInfo[i][0]= MyRS.getString("id");   
                    accountInfo[i][1]= MyRS.getString("cus_nic"); 
                    accountInfo[i][2]= MyRS.getString("pawn_id");
                    accountInfo[i][3]= MyRS.getString("init_date");
                    accountInfo[i][4]= MyRS.getString("close_date"); 
                    accountInfo[i][5]= MyRS.getString("allowance"); 
                    
                    i++;
                   
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return accountInfo;
                }
            }
            return accountInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return accountInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
            
        }
      
        
    }
    
     //function to credit account
    
    public boolean updateAccountBalance(int ac_num,double new_balance){
    
        
        
     
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE account SET current_balance = ? WHERE id = ? ");
 
    // set the preparedstatement parameters
                ps.setDouble(1,new_balance);
                ps.setInt(2,ac_num);
 
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
    
    
    
    //method to activate acount
    
    public void activeAccount(int ac_num){
        
        
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE account SET availability = ? WHERE id = ? ");
 
    // set the preparedstatement parameters
                ps.setBoolean(1, true);
                ps.setInt(2,ac_num);
 
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
    
    
        
    
    
    
    public boolean setAccountAvailability(String ac_num,boolean availability){
    
        
        
     
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE account SET availability = ? WHERE id = ? ");
 
    // set the preparedstatement parameters
                ps.setBoolean(1,availability);
                ps.setInt(2,Integer.parseInt(ac_num));
 
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
    
    
    
    public String[][] getCriticalAccount(Date date){
    
        String[][] accountInfo= new String[100][7];
        
        for(int i=0; i<100; i++){
            for(int j=0;j<7;j++){
                accountInfo[i][j]= "null";   
               
            }
        }
                    
        
                    
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("SELECT * FROM account WHERE close_date < '"+convertJavaDateToSqlDate(date)+"';");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 if(MyRS.getString("availability").equals("1")){
                
                    accountInfo[i][0]= MyRS.getString("id");   
                    accountInfo[i][1]= MyRS.getString("cus_nic"); 
                    accountInfo[i][2]= MyRS.getString("pawn_id");
                    accountInfo[i][3]= MyRS.getString("init_date");
                    accountInfo[i][4]= MyRS.getString("close_date"); 
                    accountInfo[i][5]= MyRS.getString("init_balance"); 
                    accountInfo[i][6]= MyRS.getString("current_balance"); 
                    i++;
                   
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return accountInfo;
                }
            }
            return accountInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return accountInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}  
        }
    }
    
    
    
    
    
    public String[][] getAllActivatedAccountDetails(){
    
        String[][] accountInfo= new String[100][13];
        
        for(int i=0; i<100; i++){
            for(int j=0;j<13;j++){
                accountInfo[i][j]= "null";   
               
            }
        }
                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("SELECT * FROM account WHERE availability = '1';");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 if(MyRS.getString("availability").equals("1")){
                    
                    accountInfo[i][0]= MyRS.getString("id");   
                    accountInfo[i][1]= MyRS.getString("cus_nic"); 
                    accountInfo[i][2]= MyRS.getString("pawn_id");
                    accountInfo[i][3]= MyRS.getString("init_date"); 
                    accountInfo[i][4]= MyRS.getString("init_time"); 
                    accountInfo[i][5]= MyRS.getString("time_period"); 
                    accountInfo[i][6]= MyRS.getString("close_date"); 
                    accountInfo[i][7]= MyRS.getString("availability"); 
                    accountInfo[i][8]= MyRS.getString("allowance"); 
                    accountInfo[i][9]= MyRS.getString("installment");
                    accountInfo[i][10]= MyRS.getString("init_balance");
                    accountInfo[i][11]= MyRS.getString("current_balance");
                    accountInfo[i][12]= MyRS.getString("last_notification");
                    
                    
                    i++;
                   
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return accountInfo;
                }
            }
            return accountInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return accountInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}  
        }
    }
    
    
    
    public void updateLastNotificationDate(int ac_id,Date date){
    
        
        
     
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE account SET last_notification = ? WHERE id = ? ");
 
    // set the preparedstatement parameters
                
                ps.setDate(1,convertJavaDateToSqlDate(date));
                ps.setInt(2,ac_id);
 
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
        
    
    
   
    
    
     
     
     

