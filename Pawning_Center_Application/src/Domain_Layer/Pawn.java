/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain_Layer;

import java.awt.Image;

/**
 *
 * @author Dell
 */
public class Pawn {
    private int id;
    private String description;
    private double weight;
    private double assess_value;
    //private Image image;
    private boolean availability;
    
    public Pawn(int id1, String description1, double weight1, double assess_value1, Image image1, boolean avaliability1){
        this.id=id1;
        this.description=description1;
        this.weight=weight1;
        this.assess_value=assess_value1;
        //this.image=image1;
        this.availability=avaliability1;  
    }
    
    public void setId(int id1){
        this.id=id1;
    }
    public void setDescription(String description1){
        this.description=description1;
    }
    public void setWeight(double weight1){
        this.weight=weight1;
    }
    public void setAssess_value(double assess_value1){
        this.assess_value=assess_value1;
    }
    /*public void setImage(Image image1){
        this.image=image1;
    }*/
    public void setAvailablity(boolean availability1){
        this.availability=availability1;
    }
    
    
    public int getId(){
        return this.id;
    }
    public String getDescription(){
        return this.description;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getAssess_value(){
        return this.assess_value;
    }
    /*public Image getImage(){
        return this.image;
    }*/
    public boolean getAvailablity(){
        return this.availability;
    }
    
    
}
