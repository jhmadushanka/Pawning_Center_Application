/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain_Layer;

import Data_Access_Layer.AccountHandler;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Account {
    private int id;
    private String cus_nic;
    private int pawn_id;
    private Date init_date;
    private Time init_time;
    private int time_period;    //months
    private Date close_date;
    private boolean availability;
    private double allowance;
    private double installment;
    private double init_lack;
    private double current_lack;
    
    public Account(){
        this.id=0;
        this.cus_nic=null;
        this.pawn_id=0;
        this.init_date=null;
        this.init_time=null;
        this.time_period=0;
        //this.close_date="0000-;
        this.availability=false;
        this.allowance=0;
        this.installment=0;
        this.init_lack=0;
        this.current_lack=0;
    }
    public Account(int id1, String cus_nic1, int pawn_id1, Date init_date1, Time init_time1,int time_period1,Date close_date1, boolean avalability1,double allowance1,double insstallment1,double init_lack1, double current_lack1 ){
        this.id=id1;
        this.cus_nic=cus_nic1;
        this.pawn_id=pawn_id1;
        this.init_date=init_date1;
        this.init_time=init_time1;
        this.time_period=time_period1;
        this.close_date=close_date1;
        this.availability=avalability1;
        this.allowance=allowance1;
        this.installment=insstallment1;
        this.init_lack=init_lack1;
        this.current_lack=current_lack1;
    }
    
    public void setId(int id1){
        this.id=id1;
    }
    public void setCustomer_nic(String cus_nic1){
        this.cus_nic=cus_nic1;
    }
    public void setPawnid(int pawnid1){
        this.pawn_id=pawnid1;
    }
    public void setInit_date(Date init_date1){
        this.init_date=init_date1;
    }
    public void setInit_time(Time init_time1){
        this.init_time=init_time1;
    }
    public void setTime_Period(int time_period1){
        this.time_period=time_period1;
    }
    public void setClosedate(Date close_date1){
        this.close_date=close_date1;
    }
    public void setAvailability(boolean availability1){
        this.availability=availability1;
    }
    public void setAllowance(double allowance1){
        this.allowance=allowance1;
    }
    public void setInstallment(double installment1){
        this.installment=installment1;
    }
    public void setInit_lack(double init_lack1){
        this.init_lack= init_lack1;
    }
    public void setCurrent_lack(double current_lack1){
        this.current_lack=current_lack1;
    }
    
    
    public int getId(){
        return this.id;
    }
    public String getCustomer_nic(){
        return this.cus_nic;
    }
    public int getPawnid(){
        return this.pawn_id;
    }
    public Date getInit_date(){
        return this.init_date;
    }
    public Time getInit_time(){
        return this.init_time;
    }
    public int getTime_Period(){
        return this.time_period;
    }
    public Date getClosedate(){
        return this.close_date;
    }
    public boolean getAvailability(){
        return this.availability;
    }
    public double getAllowance(){
        return this.allowance;
    }
    public double getInstallment(){
        return this.installment;
    }
    public double getInit_lack(){
        return this.init_lack;
    }
    public double getCurrent_lack(){
        return this.current_lack;
    }
    
    public String[] getAccontDetail(String searchcriteria,String searchvalue){
        AccountHandler accounthandler = new AccountHandler();
        return accounthandler.getAccountDetail(searchcriteria, searchvalue);
    }
    
    
    
}
