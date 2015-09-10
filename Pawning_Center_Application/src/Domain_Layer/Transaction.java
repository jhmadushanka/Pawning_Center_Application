/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Domain_Layer;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Dell
 */
public class Transaction {
    private int     id;
    private int     account_num;
    private Date    date;
    private Time    time;
    private String     staff_id;
    private String  description;
    private double  credit;
    private double  debit;
    
    public Transaction(int id1, int account_num1,Date date1,Time time1,String staff_id1, String description1,double credit1,double debit1){
        this.id             =id1;
        this.account_num    =account_num1;
        this.date           =date1;
        this.time           =time1;
        this.staff_id       =staff_id1;
        this.description    =description1;
        this.credit         =credit1;
        this.debit          =debit1;
    }
    
    public void setId(int id1){
        this.id=id1;
    }
    public void setAccount_num(int ac_num1){
        this.account_num    =ac_num1;
    }
    public void setDate(Date date1){
        this.date           =date1;
    }
    public void setTime(Time time1){
        this.time           =time1;
    }
    public void setStaff_id(String staff_id1){
        this.staff_id       =staff_id1;
    }
    public void setDesciption(String description1){
        this.description    =description1;
    }
    public void setCredit(double credit1){
        this.credit         =credit1;
    }
    public void setDebit(double debit1){
        this.debit          =debit1;
    }
    
    
    public int getId(){
        return this.id;
    }
    public int getAccount_num(){
        return this.account_num;
    }
    public Date getDate(){
        return this.date;
    }
    public Time getTime(){
        return this.time;
    }
    public String getStaff_id(){
        return this.staff_id;
    }
    public String getDesciption(){
        return this.description;
    }
    public double getCredit(){
        return this.credit;
    }
    public double getDebit(){
        return this.debit;
    }
}
