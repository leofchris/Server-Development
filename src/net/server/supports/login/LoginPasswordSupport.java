/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.server.supports.login;
import client.MapleClient;
import static client.MapleClient.checkHash;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import tools.DatabaseConnection;
/**
 *
 * @author Chris
 */
public class LoginPasswordSupport {

    private Calendar banDuration = new GregorianCalendar();
    private Calendar registerDate = new GregorianCalendar();
  
    private String pin;
    private MapleClient c;
    
    int characterSlots;
    int banStatus;
    
    byte tos;
    byte verified;
    byte gReason;
    byte loginStatus;
    
    private String userName;
    private String password;
    private String userPassword;
    private String salt;
    
    public LoginPasswordSupport(String userName, String password, MapleClient c){
        this.userName = userName;
        this.password = password;
        this.c = c;
        
        loadData();
        loginStatus();
    }

    public LoginPasswordSupport(MapleClient c){
        this.c = c;
        setToSStatus((byte)1);
        
        setLoginStatus((byte)0);
        
        loadData2();
        
        c.setLoggedIn(true);
    }
        
    public void loadData(){
      
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT id, greason, tempban, createdat, characterslots, banned, tos, verified, password, salt, pic, pin FROM accounts WHERE name = ?");
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()){
                c.setAccID(rs.getInt("id"));
                
                if (rs.getLong("tempban") == 0){
                    banDuration = null;
                } else {
                    banDuration.setTimeInMillis(rs.getTimestamp("tempban").getTime());
                }
                if(rs.getLong("createdat") == 0){
                    registerDate = null;
                } else {
                    registerDate.setTimeInMillis(rs.getTimestamp("createdat").getTime());
                }
                
                pin = rs.getString("pin");
             
                characterSlots = rs.getInt("characterslots");
                banStatus = (byte) rs.getByte("banned");
                gReason = (byte) rs.getInt("greason");
                tos = (byte) rs.getByte("tos");
                verified = (byte) rs.getByte("verified");
                userPassword = rs.getString("password");
                salt = rs.getString("salt");
         } else{
                setLoginStatus((byte)5);
            }
       } catch (SQLException e) {
               e.printStackTrace();
     }    
        try{
            ps.close();
            rs.close();
       } catch (SQLException e){
               e.printStackTrace();
     }
   }
    
    public void loadData2(){
      
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT greason, tempban, createdat, characterslots, banned, tos, verified, password, salt FROM accounts WHERE id = ?");
            ps.setInt(1, c.getAccID());
            rs = ps.executeQuery();
            if (rs.next()){
                
                if (rs.getLong("tempban") == 0){
                    banDuration = null;
                } else {
                    banDuration.setTimeInMillis(rs.getTimestamp("tempban").getTime());
                }
                if(rs.getLong("createdat") == 0){
                    registerDate = null;
                } else {
                    registerDate.setTimeInMillis(rs.getTimestamp("createdat").getTime());
                }
                characterSlots = rs.getInt("characterslots");
         } else{
                setLoginStatus((byte)5);
            }
       } catch (SQLException e) {
               e.printStackTrace();
     }    
        try{
            ps.close();
            rs.close();
       } catch (SQLException e){
               e.printStackTrace();
     }
   }
     
    public void setToSStatus(byte x){
         Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE accounts SET tos = ? WHERE id = ?");
            ps.setByte(1, x);
            ps.setInt(2, c.getAccID());
            ps.executeUpdate();
       } catch (SQLException e) {
               e.printStackTrace();
     }    
        try{
            ps.close();
       } catch (SQLException e){
               e.printStackTrace();
     }
        this.tos = (byte) x;
    }
    
    public void setLoginStatus(byte x){
        this.loginStatus = x;
    }
    
    public byte getGReason(){
        
        return gReason;
    }
    
    public String getPin(){
        return pin;
    }
    
    public void restoreBanStatus(){
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
       
        try{
            ps = con.prepareStatement("UPDATE accounts SET greason = 0, tempban = DEFAULT, banned = 0 WHERE name = ?");
            ps.setString(1, userName);
            ps.executeUpdate(); 
       } catch (SQLException e) {
               e.printStackTrace();
     }    
        try{
            ps.close();
          
       } catch (SQLException e){
               e.printStackTrace();
     }
        
         banStatus = (byte)0;
         banDuration.setTimeInMillis(0);
         gReason = (byte)0;
    }
    
    public byte getLoginStatus(){
        return (byte) loginStatus;
    }
    
    public long getBanDuration(){
        
        if (banDuration == null){
            return 0;
        }
        return banDuration.getTimeInMillis()*10000+116444592000000000L;
    }
    
    public long getRegisterDate(){
        return registerDate.getTimeInMillis()*10000+116444592000000000L;
    }
    
    public int getCharacterSlots(){
        return characterSlots;
    }
    
    public void loginStatus(){
        if (loginStatus != 5) {
            
            c.setLoginAttempt((byte)(c.getLoginAttempt()+1));
            if (c.getLoginAttempt() > 4){
                c.getSession().close(true);
            }
            
        if (banDuration != null && banStatus > 0){
            if (banDuration.getTimeInMillis() > System.currentTimeMillis()){
               restoreBanStatus();
            }
        }
        if (banStatus > 0) {
            setLoginStatus((byte)2);
        } else if (c.getLoginState() > c.getLOGINNOTLOGGEDIN()){
            c.setLoggedIn(false);
            setLoginStatus((byte)7);
        } else if (verified == 0){
            setLoginStatus((byte)16);
        } else if (password.equals(userPassword) || checkHash(userPassword, "SHA-1", password) || checkHash(userPassword, "SHA-512", password + salt)){
            if (tos == 0) {
                       setLoginStatus((byte)23);
            } else{
                c.setLoggedIn(true);
                c.setLoginAttempt((byte)0);
                setLoginStatus((byte)0);
            }
        } else{
                c.setLoggedIn(false);
                setLoginStatus((byte)4);
        }
    }
    }
 }


