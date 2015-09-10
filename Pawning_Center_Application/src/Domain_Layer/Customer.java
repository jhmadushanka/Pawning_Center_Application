/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain_Layer;

import Data_Access_Layer.CustomerHandler;
import java.awt.Image;


/**
 *
 * @author Dell
 */
public class Customer {
    private String  nic;
    private String  name;
    private String  address;
    private String  tel_num;
    private String  email;
    //private Image   image;
    //private String  username;
    //private String  password;
    
    public Customer(String nic1, String name1, String address1, String tel_num1, String email1, Image image1,String username1, String passwod1){
        this.nic = nic1;
        this.name = name1;
        this.address = address1;
        this.tel_num= tel_num1;
        this.email=email1;
        //this.image=image1;
        //this.username= username1;
       // this.password=passwod1;
    }
    
    public void setNic(String nic1){
        this.nic=nic1;
    }
    public void setName(String name1){
        this.name=name1;
    }
    public void setAddress(String address1){
        this.address=address1;
    }
    public void setTel_num(String tel_num1){
        this.tel_num=tel_num1;
    }
    public void setEmail(String email1){
        this.email=email1;
    }
  /*  public void setImage(Image image1){
        this.image=image1;
    }
    public void setUsername(String username1){
        this.username=username1;
    }
    public void setPassword(String password1){
        this.password=password1;
    }*/
    
    
    public String getNic(){
        return this.nic;
    }
    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getTel_num(){
        return this.tel_num;
    }
    public String getEmail(){
        return this.email;
    }
    
    public String[] getCstomerDetail(String searchcriteria,String searchvalue){
        CustomerHandler customerhandler = new CustomerHandler();
        return customerhandler.getCustomerDetail(searchcriteria, searchvalue);
    }
    
   /* public Image getImage(){
        return this.image;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    */
}
