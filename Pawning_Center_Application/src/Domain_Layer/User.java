/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain_Layer;

/**
 *
 * @author Dell
 */
public class User {
    public static String user_name;
    public static void setUserName(String username){
        user_name=username;
    }
    
    public static String getUserName(){
        return user_name;
    }
    
    
}
