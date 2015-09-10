
package Domain_Layer;

import Data_Access_Layer.*;
import View_Layer.LoginGUI;
import java.util.Calendar;
import java.util.Date;
import Data_Access_Layer.UserHandler;
import View_Layer.ManagerGUI;
import View_Layer.OfficerGUI;
import View_Layer.TellerGUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Pawning_Center_Application extends Thread{

    Account account =new Account(0, null,0, null, null, 0, null, false, 0, 0, 0, 0);
    Pawn pawn = new Pawn(0, null, 0,0, null, false);
    Customer cstomer= new Customer(null, null, null, null, null, null, null, null);
    Transaction transaction= new Transaction(0, 0, null, null, null, null, 0, 0);
    
    CustomerHandler  customerhandler= new CustomerHandler();
    PawnHandler pawnhandler = new PawnHandler();
    AccountHandler accounthandler= new AccountHandler();
    InterestHandler interesthandler = new InterestHandler();
    TransactionHandler transactionhandler= new TransactionHandler();
    UserHandler userhandler = new UserHandler();

    

    
            
    
   
    
    public static void main(String[] args) throws javax.mail.MessagingException {
        
        Pawning_Center_Application pawning_center_Application= new Pawning_Center_Application();
        pawning_center_Application.sendNotificationsofAccountDetails();
        LoginGUI logingui = new LoginGUI();
        logingui.show();
        TellerGUI tellergui =new TellerGUI();
        //tellergui.show();
        OfficerGUI officergui= new OfficerGUI();
        //officergui.show();
        ManagerGUI managergui= new ManagerGUI();
        //managergui.show();
        
       // Date date = 
        //Time time = 
       
        
        
        
    }
    
   
    
    //function to call method in Data Access Layer in order to create Login
    public synchronized String createLogin(String username, String password){
       // UserHandler userhandler=new UserHandler();
        return userhandler.createLogin(username, password);
    }
    
    //fucntion to get maximum pawn id
    public synchronized int getMaxPawnID(){
       // PawnHandler pawnhandler=new PawnHandler();
        return pawnhandler.getMaxPawnID();
    }
    
    //fcntion o get maximm account id
    public synchronized int getMaxAccountID(){
        //AccountHandler accounthandler=new AccountHandler();
        return accounthandler.getMaxAccountID();
    }
    
    //funtion to get interest to relevent time period
    public synchronized double getIntersetRate(int period){
       // InterestHandler interesthandler= new InterestHandler();
        return interesthandler.getIntersetRate(period);
    
    }
    //function to get account details
    public synchronized String[] getAccontDetail(String searchcriteria,String searchvalue){
        //AccountHandler accounthandler = new AccountHandler();
        return accounthandler.getAccountDetail(searchcriteria, searchvalue);
    }
    //function to to get close date of the account
    public synchronized Date getCloseDate(Date date,int period) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        if(period==12){
            calendar.add(Calendar.DATE, +365); //relevent days
            return calendar.getTime();
        }
        else if(period==18){
            calendar.add(Calendar.DATE, +548); //relevent days
            return calendar.getTime();
        }
        else if(period==24){
            calendar.add(Calendar.DATE, +730); //relevent days
            return calendar.getTime();
        }
        else
            return null;
    }
    //to get customer detail
    public synchronized String[] getCstomerDetail(String searchcriteria,String searchvalue){
        //CustomerHandler customerhandler = new CustomerHandler();
        return customerhandler.getCustomerDetail(searchcriteria, searchvalue);
    }
    
    public synchronized double calculateInitLack(double allowance, double interest_rate){
        //System.out.println(interest_rate);
        return allowance*(100+interest_rate)/100;
    }
    public synchronized double calculateInstallment(double allowance, double interest_rate,int period){
        return (allowance*(100+interest_rate)/100)/period;
        
    }
    
    //function to create a new account
    
    public synchronized boolean createNewAccount(String nic, String name, String address, String tel_num, String email,int pawn_id,String description,double weight,double assess_value,int account_id, Date init_date, String init_time,int time_period,Date close_date,double allowance,double installment,double init_balance,double current_balance){
        try{
        //CustomerHandler customerhandler= new CustomerHandler();
        //PawnHandler pawnhandler = new PawnHandler();
        //AccountHandler accounthandler= new AccountHandler();
        
        customerhandler.InsertCustomerRecord(nic,name,address,tel_num,email);
        pawnhandler.InsertPawnRecord(pawn_id,description,weight,assess_value,true);
        accounthandler.InsertAccountRecord(account_id,nic,pawn_id,init_date,init_time,time_period,close_date,false,allowance,installment,init_balance,current_balance);
          try{
         
            HashMap param= new HashMap();
            param.put("para_account_num", Integer.toString(account_id));
            
            
            JasperReport compileReport = JasperCompileManager.compileReport("./src/Reports/NewAccountForm.jrxml");
            
          
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pawning_center_application","root","");
            
            JasperPrint fillReport = JasperFillManager.fillReport(compileReport,param,con );
            JasperViewer.viewReport(fillReport, false);
            
            //ReportView rv= new ReportView ();
            
        } catch (JRException ex) {
            Logger.getLogger(TellerGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TellerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
        
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    
    }
    
    //function to get new created account details to active 
    public synchronized String[][] getAccountDetailstoActivate(){
        //AccountHandler accountHandler= new AccountHandler();
        return accounthandler.getAccountDetailstoActivate();
    }
    
    public synchronized String[][] getTellerTransactions(){
        //TransactionHandler transactionhandler= new TransactionHandler();
        return transactionhandler.getTellerTransactions();
    }
    
    
    
    //function to credit account
    public synchronized String creditAccount(String ac_num,String description, double amount,Date date,String time){
        //AccountHandler accounthandler= new AccountHandler();
        //TransactionHandler transactionhandler = new TransactionHandler();
        
        String[] accountinfo= accounthandler.getAccountDetail("id" , ac_num);
        if(accountinfo[0].equals("null")){
            
            return "invalid account number";
        
        }
        
        else {
            if(accountinfo[7].equals("1")){
                if(Integer.parseInt(ac_num)!=1001001 && Double.parseDouble(accountinfo[11])+amount>0){
                    return "Amount is Too High ";
                }
                else{
                    //String user_id = getUserID();
          
                    double newbalance=( Double.parseDouble(accountinfo[11])+amount);
                    boolean x=accounthandler.updateAccountBalance(Integer.parseInt(ac_num), newbalance);
                   // System.out.println("x");
                    if (ac_num.equals("1001001")){                                
                                
                        boolean y=transactionhandler.insertRecordsToTransactionTable(ac_num, description, date, time, User.getUserName(), 0.00/*credit*/, amount/*debit*/);
                    //System.out.println(y);
                        if(x==true && y==true)
                            return "Finished and Printing Receipt !";
                        else
                            return "Unfinished !";
                    
                    }
                    
                    else{
           
                        boolean y=transactionhandler.insertRecordsToTransactionTable(ac_num, description, date, time, User.getUserName(), amount/*credit*/, 0.00/*debit*/);
                    //System.out.println(y);
                        if(x==true && y==true)
                            return "Finished and Printing Receipt !";
                        else
                            return "Unfinished";
                    }
                    
                }
               
            }
            else{
                 return "Transactions Prohibited !";
            }
        
        }
        
         
    
    }
    
    //method to debit an account
    
    public synchronized String DebitAccount(String ac_num,String description, double amount,Date date,String time){
       // AccountHandler accounthandler= new AccountHandler();
        //TransactionHandler transactionhandler = new TransactionHandler();
        
        String[] accountinfo= accounthandler.getAccountDetail("id" , ac_num);
        if(accountinfo[0].equals("null")){
            
            return "Invalid Account Number !";
        
        } 
        
        else {
            if(accountinfo[7].equals("1")){
                
                if(Integer.parseInt(ac_num)!=1001001 && Double.parseDouble(accountinfo[8])!=amount){
                    return "Please Enter the Approved Allowance !";
                }
                else{
                    //String user_id = getUserID();
          
                    double newbalance=( Double.parseDouble(accountinfo[11])-amount);
                    boolean x;
                    
                    if (ac_num.equals("1001001")){
                        x=accounthandler.updateAccountBalance(Integer.parseInt(ac_num), newbalance);
           
                        boolean y=transactionhandler.insertRecordsToTransactionTable(ac_num, description, date, time, User.getUserName(), amount/*credit*/, 0.00/*debit*/);
                    //System.out.println(y);
                        if(x==true && y==true)
                            return "Finished and Printing Receipt !";
                        else
                            return "Unfinished !";
                    
                    }
                    
                    else{
                        x=true;
                        boolean y=transactionhandler.insertRecordsToTransactionTable(ac_num, description, date, time, User.getUserName(), 0.00/*credit*/, amount/*debit*/);
                    //System.out.println(y);
                        if(x==true && y==true)
                            return "Finished and Printing Receipt !";
                        else
                            return "Unfinished";
                    }
                    
                }
               
            }
            else{
                 return "Transactions Prohibited!";
            }
        
        }
        
         
    
    }
    
    
    //method to get sum of all credits
    public synchronized double getSumofCredits(){
       // TransactionHandler transactionhandler = new TransactionHandler();
        return transactionhandler.getSumofCredits(User.getUserName());
        
    }
    
    public synchronized double getSumofCredits(String username){
       // TransactionHandler transactionhandler = new TransactionHandler();
       // System.out.println(username);
        return transactionhandler.getSumofCredits(username);
        
    }
    
    public synchronized double getSumofDebits(){
        //TransactionHandler transactionhandler = new TransactionHandler();
        return transactionhandler.getSumofDebits(User.getUserName());
       
        
    }
    
    public synchronized double getSumofDebits(String username){
        //TransactionHandler transactionhandler = new TransactionHandler();
        // System.out.println(username);
        return transactionhandler.getSumofDebits(username);
        
        
    }
    
    
    //method to active accounts 
    public synchronized void activeAccount(int ac_num){
       // AccountHandler accounthandler = new AccountHandler();
        accounthandler.activeAccount(ac_num);
    }
    
    //method to deactive accounts
    public synchronized boolean DeactiveAccount(String acNumber){
        
        String accountInfo[]=this.getAccontDetail("id", acNumber);
        String pawnid=accountInfo[2];
       
        boolean x= accounthandler.setAccountAvailability(acNumber,false);
        boolean y=pawnhandler.setPawnAvailability(pawnid,false);
        
        if(x==true && y==true)
            return true;
        else
            return false;
        
        
    }
    
    
    // method to get interest rate table in database
    public synchronized double getInterestRate(int period){
        return interesthandler.getIntersetRate(period);
    
    }
    
    public synchronized boolean setNewInterestRate(int period,double new_interest_rate){
        return interesthandler.setNewInterestRate(period,new_interest_rate);
    
    }
    
    //method to get active users of the system
    public synchronized String[][] getActivatedTellers(){
        return userhandler.getTellersWithAuthenticity("1");
    }
    
    
    
    public synchronized String[][] getDeactivatedTellers(){
        return userhandler.getTellersWithAuthenticity("0");
    }
    
    
    //method to active tellers by officer
    public synchronized void setTellerAuthenticationtoActivate(String user_id){
        userhandler.setTellerAuthentication(user_id, "true");
    }
    
    public synchronized void setTellerAuthenticationtoDeactivate(String user_id){
        userhandler.setTellerAuthentication(user_id, "false");
    }
    
    public synchronized String[][] getMonthTransactions(String subdate){
        return transactionhandler.getMonthTransactions(subdate);
    }
    
    public synchronized double getSumofMonthlyCredits(String sub_date){
        return transactionhandler.getSumofMonthlyCredits(sub_date);
    }
    
    public synchronized double getSumofMonthlyDebits(String sub_date){
        return transactionhandler.getSumofMonthlyDebits(sub_date);
    }
    
    public synchronized String[][] getAccountTransactions(int ac_num){
        return transactionhandler.getAccountTransactions(ac_num);
    }
    
    public synchronized String[][] getCriticalAccounts(Date date){
        return accounthandler.getCriticalAccount(date);
    }
    
    public synchronized String change_password(String user_id,String oldpw,String newpw){
        String position=userhandler.createLogin(user_id, oldpw);
        //System.out.println(position);
        if(position !=null){
           return userhandler.ResetPassword(user_id, newpw);
            
        
        }
        else
            return "Username or Password Invalid!";
            
    }
    
    
    
    public synchronized String[] getUserInfo(String searchcriteria, String searchvalue){
        return userhandler.getUserDetail(searchcriteria, searchvalue);
    }
    
    
    public synchronized String addUsers(String nic, String name, String address, String tel_num, String email, String user_id, String position){
    
        boolean status=userhandler.InsertUserRecord(nic, name, address, tel_num, email, user_id, nic, position, true);
        
        if(status){
            return "New User Has Been Added";
        }
        else{
            return "Fail to Add New User";
        }
    
    }
    
    public synchronized void RemoveUser(String userid){
        userhandler.setUserAuthentication(userid, "false");
    }
    
    
    public String getMaxTransactionID(){
        return Integer.toString(transactionhandler.getMaxTransactionID());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public synchronized void sendNotificationsofAccountDetails() throws javax.mail.MessagingException{
        String[][] activatedaccountInfo=accounthandler.getAllActivatedAccountDetails();
        int i=0;
                    
                   // System.out.println(massage);
                   // setLastNotification(date);
                    
                   
                    
                    //String host="localhost";
                    final String senderemail="rascopawningcenter@gmail.com";
                    final String senderPassword="71967290";
                    final String senderName="Rasco Pawning Center";
                    final String subject="Account Details";
                    
                    
                   
                    
                    
                    Properties props = new Properties();
                    
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "587");
                    /*props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.fallback", "false");*/
                    props.put("mail.smtp.starttls.enable", "true");
                    
                    
                    Session mailsession= Session.getDefaultInstance(props,null);
                    
                    //System.out.println("PASSED HERE ------------------------------");
                    mailsession.setDebug(true);
                    
                    Message mailmessage = new MimeMessage(mailsession);
                    
                    mailmessage.setFrom(new InternetAddress(senderemail));
                    
           while(activatedaccountInfo[i][0]!="null"){
            if(!activatedaccountInfo[i][0].equals("1001001"))
            {
                String update_month=(activatedaccountInfo[i][12].substring(5, 7));
                Date date= new Date();
                String month;
                if((date.getMonth()+1)<10)
                    month="0"+(date.getMonth()+1);
                else
                    month=Integer.toString(date.getMonth()+1);
                
                if(!month.equals(update_month)){
                    String[] customerInfo= customerhandler.getCustomerDetail("nic", activatedaccountInfo[i][1]);
                    String cus_name=(customerInfo[1]);
                    String cus_email=(customerInfo[4]);
                    
                    String id       =activatedaccountInfo[i][0];   
                    String cus_nic  =activatedaccountInfo[i][1]; 
                    String pawn_id  =activatedaccountInfo[i][2];
                    String init_date=activatedaccountInfo[i][3]; 
                    String close_date=activatedaccountInfo[i][6]; 
                    
                    String allowance= activatedaccountInfo[i][8]; 
                    String installment=activatedaccountInfo[i][9];
                    String init_balance=activatedaccountInfo[i][10];
                    String current_balance=activatedaccountInfo[i][11];
                    
                    String resever=cus_email;
                    
                    String massage= "\n\t\tYour Account Details\n\n"+"Customer Name : "+cus_name+"\nCustomer NIC : "+cus_nic+"\nAccount ID : "+id+"\nPawn ID : "
                            +pawn_id+"\nInitiated Date : "+init_date+"\nCloseDate : "+close_date+"\nAllowance : "+allowance+"\nInstallment : "
                            +installment+"\nInitial Balance : "+init_balance+"\nCurrent Balance : "+current_balance+"\n\n \t\tThank You!";
        
                    
                    mailmessage.setRecipient(Message.RecipientType.TO, new InternetAddress(resever));
                    mailmessage.setContent(massage, "text/html");
                    mailmessage.setSubject(subject);
                    mailmessage.setSentDate(date);
                    
                    
                    Transport transport = mailsession.getTransport("smtp");
                    //transport.send(mailmessage);
                    /*Transport transport= mailsession.getTransport("smtp");*/
                    transport.connect("smtp.gmail.com",senderemail,senderPassword);
                    
                    transport.sendMessage(mailmessage, mailmessage.getAllRecipients());
                    transport.close();
                    accounthandler.updateLastNotificationDate(Integer.parseInt(id), date);
                    
                    
                    
              
                   
                }
            }
            i++;
        }
    
  
    
    }
    
    
}

    
    
              

