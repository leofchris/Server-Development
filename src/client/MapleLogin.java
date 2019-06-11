/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Chris
 */
public class MapleLogin {
   
    Calendar banDate = new GregorianCalendar();
    private byte banStatus = 0;
    private byte loginStatus = 0;
    private short gReason = 0;
    
    public void setBanStatus(byte x){
        this.banStatus = x;
    }
    
    public void setloginStatus(byte x){
        this.loginStatus = x;
    }
    
    public void setgReason(short x){
        this.gReason = x;
    }
    
    public void setbanDate(Calendar x){
        
        this.banDate = x;
    }
    
    public byte getLoginStatus(){
        return loginStatus;
    }
    
    public short getsetgReason(){
        return gReason;
    }
    
    public long getbanDate(){
        return banDate.getTimeInMillis();
    }
    
   
    
    
}
