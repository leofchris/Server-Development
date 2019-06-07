/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Chris
 */
public class MapleLogin {
    
    private byte banStatus = 0;
    private byte loginStatus = 0;
    private byte gReason = 0;
    
    public void setBanStatus(byte x){
        this.banStatus = x;
    }
    
    public void setloginStatus(byte x){
        this.loginStatus = x;
    }
    
    public void setgRason(byte x){
        this.gReason = x;
    }
    
    public byte getLoginStatus(){
        return loginStatus;
    }
}
