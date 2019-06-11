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
    public ArrayList<Integer> characterID = new ArrayList<Integer>(); // Character ID
    ArrayList<String> characterName = new ArrayList<String>();
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
    
    public int getCharID(int currentCharacterCount){
        
        return characterID.get(currentCharacterCount);
    }
    
    public String getCharName(int currentCharacterCount){
        
        return characterName.get(currentCharacterCount);
    }
    
    public void loadCharacterID(int worldID, MapleClient c){
        characterID = new ArrayList<Integer>();
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          ps = con.prepareStatement("SELECT id FROM characters WHERE accountid = ? AND world = ?");
          ps.setInt(1, c.getAccID());
          ps.setInt(2, worldID);
          rs = ps.executeQuery();
          while(rs.next()){
      
              if (!characterID.contains(rs.getInt("id"))){
              characterID.add(rs.getInt("id"));
              }
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
      
    public String loadCharacterName(int worldID, MapleClient c){
        
        characterName = new ArrayList<String>();
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
          ps = con.prepareStatement("SELECT name FROM characters WHERE accountid = ? AND world = ?");
          ps.setInt(1, c.getAccID());
          ps.setInt(2, worldID);
          rs = ps.executeQuery();
          while(rs.next()){
      
              if (!characterName.contains(rs.getString("name"))){
              characterName.add(rs.getString("name"));
              }
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
        
        
        
        return"Yo";
    }
}
