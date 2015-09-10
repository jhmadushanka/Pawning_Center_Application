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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class TransactionHandler {
    
    
     public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
                    return new java.sql.Date(date.getTime());
                }   
     
    
    Connection dbconnection;
    
    //function to insert records to table transaction
    public boolean insertRecordsToTransactionTable(String ac_num,String description,Date date,String time,String userid, double credit, double debit){
    
         try {
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           
             //System.out.println(userid);
             
            
             String query = "INSERT INTO `transaction` (`id`, `ac_number`, `date`, `time`, `user_id`, `description`, `credit`, `debit`)"+" VALUES (?,?,?,?,?,?,?,?);";
 
      // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = dbconnection.prepareStatement(query);
                
                preparedStmt.setInt(1,getMaxTransactionID()+1);
                preparedStmt.setInt(2, Integer.parseInt(ac_num));
                preparedStmt.setDate(3, convertJavaDateToSqlDate(date));
                preparedStmt.setString(4, time);
                preparedStmt.setString(5, userid);
                preparedStmt.setString(6, description);
                preparedStmt.setDouble(7, credit);
                preparedStmt.setDouble(8, debit);
                
 
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
    
    
    //function to predict next transaction id
    public int getMaxTransactionID(){
        
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select max(id) as ID from transaction");
       
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
    
    
    //function to get transaction details of individual teller
    
    public String[][] getTellerTransactions(){
        String[][] transactionInfo= new String[100][7];
        
        for(int i=0; i<100; i++){
            for(int j=0;j<7;j++){
                transactionInfo[i][j]= "null";   
               
            }
        }
                    
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today= dateFormat.format(date); 
                    
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select * from transaction");
             //System.out.println(searchcriteria+""+searchvalue);
            int i=0;
            while(MyRS.next()){
                try{
                 
                    
                   // System.out.println(MyRS.getString("date")+" "+today+" "+MyRS.getString("user_id")+" "+Domain_Layer.User.getUserName());
                    
                 if(MyRS.getString("date").equals(today) && MyRS.getString("user_id").equals(Domain_Layer.User.getUserName())){
                    //System.out.println(MyRS.getString("time_period"));
                
                    transactionInfo[i][0]= MyRS.getString("id");   
                    transactionInfo[i][1]= MyRS.getString("ac_number"); 
                    transactionInfo[i][2]= MyRS.getString("date");
                    transactionInfo[i][3]= MyRS.getString("time");
                    transactionInfo[i][4]= MyRS.getString("description"); 
                    transactionInfo[i][5]= MyRS.getString("credit"); 
                    transactionInfo[i][6]= MyRS.getString("debit"); 
                   
                    
                    i++;
                   
                 }
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return transactionInfo;
                }
            }
            return transactionInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return transactionInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
            
        }
      
        
    }
    
    
    //function to get sum of day credits of individual teller
     
    public double getSumofCredits(String username){                
                
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String today= dateFormat.format(date); 
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            
            
            try{
            ResultSet MyRS = mystatement.executeQuery("SELECT sum(`credit`) as Sum FROM `transaction` WHERE transaction.user_id = '"+username+"' and transaction.date= '"+convertJavaDateToSqlDate(date)+"';");
            
            MyRS.next();
            String sum = MyRS.getString(1);
            //System.out.println(sum);
            double value = Double.parseDouble(sum);
            //double sum=Double.parseDouble(MyRS.getString("Sum"));
            //println(MyRS,getString(1));
     
                return value;  
            }
            //if teller id is not in the table
            catch(Exception e){
               
                return 0.00;
            }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();
                    
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
    
    
    public double getSumofDebits(String username){                
                
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String today= dateFormat.format(date); 
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            try{
            ResultSet MyRS = mystatement.executeQuery("SELECT sum(`debit`) as Sum FROM `transaction` WHERE transaction.user_id = '"+username+"' and transaction.date= '"+convertJavaDateToSqlDate(date)+"';");
            
            MyRS.next();
            
            String sum = MyRS.getString(1);
            //System.out.println(sum);
            double value = Double.parseDouble(sum);
            //double sum=Double.parseDouble(MyRS.getString("Sum"));
            //println(MyRS,getString(1));
     
                return value;    
            }
                //if teller id is not in the table
                
            catch(Exception e){
                
                return 0.00;
            }
            
                
        }
        catch(SQLException ex){
            ex.printStackTrace();
                    
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
    
    
    
    
    
    
    public String[][] getMonthTransactions(String subdate){
        String[][] transactionInfo= new String[100][8];
        
        for(int i=0; i<100; i++){
            for(int j=0;j<8;j++){
                transactionInfo[i][j]= "null";   
               
            }
        }
                                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("SELECT * FROM `transaction` WHERE `date` like '"+subdate+"';");

            int i=0;
            while(MyRS.next()){
                try{
                
                    transactionInfo[i][0]= MyRS.getString("id");   
                    transactionInfo[i][1]= MyRS.getString("ac_number"); 
                    transactionInfo[i][2]= MyRS.getString("date");
                    transactionInfo[i][3]= MyRS.getString("time");
                    transactionInfo[i][4]= MyRS.getString("user_id");
                    transactionInfo[i][5]= MyRS.getString("description"); 
                    transactionInfo[i][6]= MyRS.getString("credit"); 
                    transactionInfo[i][7]= MyRS.getString("debit"); 
                   
                    
                    i++;
                   
                 
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return transactionInfo;
                }
            }
            return transactionInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return transactionInfo;
        }
         
        finally{
            try{
                //System.out.println("finally exected");
                dbconnection.close();
            } 
            catch(Exception ex) { /*ignore*/}
            
        }
      
        
    }
    
    
    
    public double getSumofMonthlyCredits(String subdate){                
                
        try {
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            try{
            ResultSet MyRS = mystatement.executeQuery("SELECT sum(`credit`) as Sum FROM `transaction` WHERE `date` like '"+subdate+"';");
            
            MyRS.next();
            
            String sum = MyRS.getString(1);
            
            double value = Double.parseDouble(sum);
            
     
                return value;    
            }
               
            catch(Exception e){
                
                return 0.00;
            }
            
                
        }
        catch(SQLException ex){
            ex.printStackTrace();
                    
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
    
    
    
    public double getSumofMonthlyDebits(String subdate){                
                
        try {
            dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            try{
            ResultSet MyRS = mystatement.executeQuery("SELECT sum(`debit`) as Sum FROM `transaction` WHERE `date` like '"+subdate+"';");
            
            MyRS.next();
            
            String sum = MyRS.getString(1);
            
            double value = Double.parseDouble(sum);
            
     
                return value;    
            }
               
            catch(Exception e){
                
                return 0.00;
            }
            
                
        }
        catch(SQLException ex){
            ex.printStackTrace();
                    
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
    
    
    
    
    //method to get account transactions details
    public String[][] getAccountTransactions(int ac_num){
        String[][] transactionInfo= new String[100][7];
        
        for(int i=0; i<100; i++){
            for(int j=0;j<7;j++){
                transactionInfo[i][j]= "null";   
               
            }
        }
                                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("SELECT * FROM `transaction` WHERE `ac_number` = '"+ac_num+"';");

            int i=0;
            while(MyRS.next()){
                try{
                
                      
                    transactionInfo[i][0]= MyRS.getString("id"); 
                    transactionInfo[i][1]= MyRS.getString("date");
                    transactionInfo[i][2]= MyRS.getString("time");
                    transactionInfo[i][3]= MyRS.getString("user_id");
                    transactionInfo[i][4]= MyRS.getString("description"); 
                    transactionInfo[i][5]= MyRS.getString("credit"); 
                    transactionInfo[i][6]= MyRS.getString("debit"); 
                   
                    
                    i++;
                   
                 
                }
                catch(SQLException ex){
                    ex.printStackTrace();
                    
                     return transactionInfo;
                }
            }
            return transactionInfo;
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Failed to connect Database!");
            return transactionInfo;
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
