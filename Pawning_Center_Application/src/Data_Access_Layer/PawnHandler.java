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
public class PawnHandler {
    Connection dbconnection=null;
    
    public int getMaxPawnID(){
        
         
        
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
            ResultSet MyRS = mystatement.executeQuery("select max(id) as ID from pawn");
       
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
    
    //function to insert records to the table pawn in the database
    
     public boolean InsertPawnRecord(int id,String description, double weight, double assess_value, boolean availability){
        
                     
         try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // mystatement.executeQuery("INSERT INTO `pawn`(`id`, `description`, `weight`, `assess_value`, `availability`) VALUES ('"+id+"','"+description+"','"+weight+"','"+assess_value+"','"+availability+"');");
             
            
            
            String query = "INSERT INTO `pawn`(`id`, `description`, `weight`, `assess_value`, `availability`)"+" VALUES (?,?,?,?,?);";
 
      // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = dbconnection.prepareStatement(query);
            preparedStmt.setInt(1, id);
            preparedStmt.setString (2, description);
            preparedStmt.setDouble(3, weight);
            preparedStmt.setDouble(4, assess_value);
            preparedStmt.setBoolean(5, availability);
 
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
     
     
     //method to set availabiliy of pawn in the database table
     
     public boolean setPawnAvailability(String pawnid,boolean availability){
    
        
        
     
        try {
            dbconnection= DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            Statement mystatement = dbconnection.createStatement();
           // ResultSet MyRS = mystatement.executeQuery("select * from account");
            
            try{
            
            PreparedStatement ps = dbconnection.prepareStatement("UPDATE pawn SET availability = ? WHERE id = ? ");
 
    // set the preparedstatement parameters
                ps.setBoolean(1,availability);
                ps.setInt(2,Integer.parseInt(pawnid));
 
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
