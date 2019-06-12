/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.Collections;
import client.MapleClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tools.DatabaseConnection;

/**
 *
 * @author Chris
 */
public class MapleViewAllCharacter {
    
    private int nCountRelatedSvrs;
    private int nCountCharacters;
    private ArrayList<Integer> worlds = new ArrayList<Integer>(); // How many worlds the character have
    private ArrayList<Integer> characterID = new ArrayList<Integer>(); // Character ID
    private ArrayList<String> characterName = new ArrayList<String>();
    private ArrayList<Integer> characterGender = new ArrayList<Integer>();
    private ArrayList<Integer> characterSkin = new ArrayList<Integer>();
    private ArrayList<Integer> characterFace = new ArrayList<Integer>();
    private ArrayList<Integer> characterHair = new ArrayList<Integer>();
    private ArrayList<Integer> characterLevel = new ArrayList<Integer>();
    private ArrayList<Integer> characterJob = new ArrayList<Integer>();
    private ArrayList<Integer> characterSTR = new ArrayList<Integer>();
    private ArrayList<Integer> characterDEX = new ArrayList<Integer>();
    private ArrayList<Integer> characterINT = new ArrayList<Integer>();
    private ArrayList<Integer> characterLUK = new ArrayList<Integer>();
    private ArrayList<Integer> characterHP = new ArrayList<Integer>();
    private ArrayList<Integer> characterMAXHP = new ArrayList<Integer>();
    private ArrayList<Integer> characterMP = new ArrayList<Integer>();
    private ArrayList<Integer> characterMAXMP = new ArrayList<Integer>();
    private ArrayList<Integer> characterAP = new ArrayList<Integer>();
    private ArrayList<Integer> characterSP = new ArrayList<Integer>();
    private ArrayList<Integer> characterEXP = new ArrayList<Integer>();
    private ArrayList<Integer> characterFame = new ArrayList<Integer>();
    private ArrayList<Integer> characterGACHAEXP = new ArrayList<Integer>();
    private ArrayList<Integer> characterSpawnPoint = new ArrayList<Integer>();
    private ArrayList<Integer> characterEquipment = new ArrayList<Integer>();
    
    private int [] charWorld = new int[20];
    
    public void loadData(MapleClient c){
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          ps = con.prepareStatement("SELECT world FROM characters WHERE accountid = ?");
          ps.setInt(1, c.getAccID());
          rs = ps.executeQuery();
          
          while(rs.next()){
              if (!worlds.contains(rs.getInt("world"))) {
                 worlds.add(rs.getInt("world"));
                 nCountRelatedSvrs++;
                 nCountCharacters++;
              }
              else{
                  nCountCharacters++;
              }
              charWorld[rs.getInt("world")] = charWorld[rs.getInt("world")]+1;
          }
      } catch (SQLException e) {
            e.printStackTrace();
      } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
            
         
        }     
   }   
    
    public int getnCountRelatedSvrs(){
        return this.nCountRelatedSvrs;
    }
    
    public int getnCountCharacters(){
        return this.nCountCharacters;
    }
    
    public int getWorldSize(){
        
        return worlds.size();
    }
    
    public int getNumberOfCharacterInworld(int worldID){
        
        return charWorld[worldID];
    }
    
    public int getCharID(int x){
        
        return characterID.get(x);
    }
    
    public String getCharName(int x){
        
        return characterName.get(x);
    }
    
    public int getCharGender(int x){
        return characterGender.get(x);
    }
    
    public int getCharSkin(int x){
        return characterSkin.get(x);
    }
    
    public int getCharFace(int x){
        return characterFace.get(x);
    }
    
    public int getCharHair(int x){
        return characterHair.get(x);
    }
    
    public int getCharLevel(int x){
        return characterLevel.get(x);
    }
    
    public int getCharJob(int x){
        return characterJob.get(x);
    }
    
    public int getCharSTR(int x){
        return characterSTR.get(x);
    }
    
    public int getCharDEX(int x){
        return characterDEX.get(x);
    }
    
    public int getCharINT(int x){
        return characterINT.get(x);
    }
    
    public int getCharLuk(int x){
        return characterLUK.get(x);
    }
    
    public int getCharHP(int x){
        return characterHP.get(x);
    }
    
    public int getCharMAXHP(int x){
        return characterMAXHP.get(x);
    }
    
    public int getCharMP (int x){
        return characterMP.get(x);
    }
    
    public int getCharMAXMP(int x){
        return characterMAXMP.get(x);
    }
    
    public int getCharAP(int x){
        return characterAP.get(x);
    }
    
    public int getCharSP(int x){
        return characterSP.get(x);
    }
    
    public int getCharEXP(int x){
        return characterEXP.get(x);
    }
    
    public int getCharFame(int x){
        return characterFame.get(x);
    }
    
    public int getCharGACHAEXP(int x){
        return characterGACHAEXP.get(x);
    }
    
    public int getCharSpawnPoint (int x){
        return characterSpawnPoint.get(x);
    }
    
    public int getCurrentEquipment (int x){
    return characterEquipment.get(x);
            }
    public void loadCharacterStats(int nWorldID, MapleClient c){
        characterID = new ArrayList<Integer>();
        characterName = new ArrayList<String>();
        characterGender = new ArrayList<Integer>();
        characterFace = new ArrayList<Integer>();
        characterHair = new ArrayList<Integer>();
        characterLevel = new ArrayList<Integer>();
        characterJob = new ArrayList<Integer>();
        characterSTR = new ArrayList<Integer>();
        characterDEX = new ArrayList<Integer>();
        characterINT = new ArrayList<Integer>();
        characterLUK = new ArrayList<Integer>();
        characterHP = new ArrayList<Integer>();
        characterMAXHP = new ArrayList<Integer>();
        characterMP = new ArrayList<Integer>();
        characterMAXMP = new ArrayList<Integer>();
        characterAP = new ArrayList<Integer>();
        characterSP = new ArrayList<Integer>();
        characterEXP = new ArrayList<Integer>();
        characterFame = new ArrayList<Integer>();
        characterGACHAEXP = new ArrayList<Integer>();
        characterSpawnPoint = new ArrayList<Integer>();
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          ps = con.prepareStatement("SELECT * FROM characters WHERE accountid = ? AND world = ?");
          ps.setInt(1, c.getAccID());
          ps.setInt(2, nWorldID);
          rs = ps.executeQuery();
          while(rs.next()){
      
              if(!characterID.contains(rs.getInt("id"))){
                  characterID.add(rs.getInt("id"));
              }
              
              if (!characterName.contains(rs.getString("name"))){
                  characterName.add(rs.getString("name"));
              }
              
              characterGender.add(rs.getInt("gender"));
              characterSkin.add(rs.getInt("skincolor"));
              characterFace.add(rs.getInt("face"));
              characterHair.add(rs.getInt("hair"));
              characterLevel.add(rs.getInt("level"));
              characterJob.add(rs.getInt("job"));
              characterSTR.add(rs.getInt("str"));
              characterDEX.add(rs.getInt("dex"));
              characterINT.add(rs.getInt("int"));
              characterLUK.add(rs.getInt("luk"));
              characterHP.add(rs.getInt("hp"));
              characterMAXHP.add(rs.getInt("maxhp"));
              characterMP.add(rs.getInt("mp"));
              characterMAXMP.add(rs.getInt("maxmp"));
              characterAP.add(rs.getInt("ap"));
              characterSP.add(rs.getInt("sp"));
              characterEXP.add(rs.getInt("exp"));
              characterFame.add(rs.getInt("fame"));
              characterGACHAEXP.add(rs.getInt("gachaexp"));
              characterSpawnPoint.add(rs.getInt("spawnpoint"));
              
          }
      } catch (SQLException e) {
            e.printStackTrace();
      } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        
    }
        
        
    }
    
    public void loadCharAvatar(int x){
         Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          ps = con.prepareStatement("SELECT inventorytype FROM inventoryitems WHERE characterid = ?");
          ps.setInt(1, getCharID(x));
          rs = ps.executeQuery();
          while(rs.next()){
      
              if(!characterID.contains(rs.getInt("id"))){
                  characterID.add(rs.getInt("id"));
              }
              
              if (!characterName.contains(rs.getString("name"))){
                  characterName.add(rs.getString("name"));
              }
              
              characterGender.add(rs.getInt("gender"));
              characterSkin.add(rs.getInt("skincolor"));
              characterFace.add(rs.getInt("face"));
              characterHair.add(rs.getInt("hair"));
              characterLevel.add(rs.getInt("level"));
              characterJob.add(rs.getInt("job"));
              characterSTR.add(rs.getInt("str"));
              characterDEX.add(rs.getInt("dex"));
              characterINT.add(rs.getInt("int"));
              characterLUK.add(rs.getInt("luk"));
              characterHP.add(rs.getInt("hp"));
              characterMAXHP.add(rs.getInt("maxhp"));
              characterMP.add(rs.getInt("mp"));
              characterMAXMP.add(rs.getInt("maxmp"));
              characterAP.add(rs.getInt("ap"));
              characterSP.add(rs.getInt("sp"));
              characterEXP.add(rs.getInt("exp"));
              characterFame.add(rs.getInt("fame"));
              characterGACHAEXP.add(rs.getInt("gachaexp"));
              characterSpawnPoint.add(rs.getInt("spawnpoint"));
              
          }
      } catch (SQLException e) {
            e.printStackTrace();
      } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        
    }
    }
    
    public int getEquipmentSize(int currentCharacterCount){
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int counter = 0;
        
        try{
          ps = con.prepareStatement("SELECT inventorytype FROM inventoryitems WHERE characterid = ?");
          ps.setInt(1, getCharID(currentCharacterCount));
          rs = ps.executeQuery();
          while(rs.next()){
      
                if (rs.getInt("inventorytype") == -1){
                    counter++;
                }
             
          }
      } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR");
      } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        
    }
        
        return counter;
    }
    
    public void loadEquipment(int currentCharacterCount){
        
        characterEquipment = new ArrayList<Integer>();
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int counter = 0;
        
        try{
          ps = con.prepareStatement("SELECT inventorytype, itemid FROM inventoryitems WHERE characterid = ?");
          ps.setInt(1, getCharID(currentCharacterCount));
          rs = ps.executeQuery();
          while(rs.next()){
      
                if (rs.getInt("inventorytype") == -1){
                   characterEquipment.add(rs.getInt("itemid"));
                }
             
          }
      } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR");
      } finally {
            try {
                if (ps != null && !ps.isClosed()) {
                    ps.close();
                }
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
            }
        
    }
    }
    
 
        
    
}
