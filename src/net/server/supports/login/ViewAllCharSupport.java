/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.server.supports.login;

import client.MapleClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import tools.DatabaseConnection;

/**
 *
 * @author Chris
 */
public class ViewAllCharSupport {
    
    private int[] charNworlds = new int[20];
    private int nCharacters = 0;

    private ArrayList<Integer> nWorlds = new ArrayList<Integer>();
    private String pic;
    private HashMap<String, Integer> charStats = new HashMap<String, Integer>();
    private ArrayList<Integer> charEquipment = new ArrayList<Integer>();
    private HashMap<Integer, String> charID = new HashMap<Integer, String>();
    private ArrayList<Integer> charIDList = new ArrayList<Integer>();
    
    private MapleClient c;
 
    public ViewAllCharSupport(MapleClient c){
        this.c = c;
        
        loadData();
        
    }
    
    public ViewAllCharSupport (int currWorld, MapleClient c){
          this.c = c;
        loadCharIDs(currWorld);
        loadData();
        loadPic();
      
    }
      
    public void loadData(){
   
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT world FROM characters WHERE accountid = ?");
            ps.setInt(1, c.getAccID());
            rs = ps.executeQuery();
            while (rs.next()){
                if (!nWorlds.contains(rs.getInt("world"))) {
                    nWorlds.add(rs.getInt("world"));
                    nCharacters++;
                 
                }
                nCharacters++;
                charNworlds[rs.getInt("world")] = charNworlds[rs.getInt("world")]+1;
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
    
    public ArrayList<Integer> getWorld(){
        return nWorlds;
    } 
    
    public int getTotalChar(){
     
    return nCharacters;
    }
    
    public void loadCharIDs(int x){
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT * FROM characters WHERE accountid = ? and world = ?");
            ps.setInt(1, c.getAccID());
            ps.setInt(2, x);
            rs = ps.executeQuery();
            while (rs.next()){
                if(!charID.containsKey(rs.getInt("id"))){
                    charID.put(rs.getInt("id"),rs.getString("name"));
                }
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
        
        charIDList = new ArrayList<Integer>(charID.keySet());
    }
    
    public void loadCharEquipment(int x){
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT itemid FROM inventoryitems WHERE characterid = ? and inventorytype = -1");
            ps.setInt(1, x);
            rs = ps.executeQuery();
            while (rs.next()){
              charEquipment.add(rs.getInt("itemid"));
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
    
    public void loadCharStats(int x){
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT * FROM characters WHERE id = ?");
            ps.setInt(1, x);
            rs = ps.executeQuery();
            if (rs.next()){
               charStats.put("level", rs.getInt("level"));
               charStats.put("exp", rs.getInt("exp"));
               charStats.put("gachaexp", rs.getInt("gachaexp"));
               charStats.put("str", rs.getInt("str"));
               charStats.put("dex", rs.getInt("dex"));
               charStats.put("luk", rs.getInt("luk"));
               charStats.put("int", rs.getInt("int"));
               charStats.put("hp", rs.getInt("hp"));
               charStats.put("mp", rs.getInt("mp"));
               charStats.put("maxhp", rs.getInt("maxhp"));
               charStats.put("maxmp", rs.getInt("maxmp"));
               charStats.put("job", rs.getInt("job"));
               charStats.put("skincolor", rs.getInt("skincolor"));
               charStats.put("gender", rs.getInt("gender"));
               charStats.put("face", rs.getInt("face"));
               charStats.put("hair", rs.getInt("hair"));
               charStats.put("fame", rs.getInt("fame"));
               charStats.put("ap", rs.getInt("ap"));
               charStats.put("sp", rs.getInt("sp"));
               charStats.put("map", rs.getInt("map"));
               charStats.put("spawnpoint", rs.getInt("spawnpoint"));
               charStats.put("gm", rs.getInt("gm"));
               charStats.put("subJob", rs.getInt("subJob"));
               charStats.put("rank", rs.getInt("rank"));
               charStats.put("rankMove", rs.getInt("rankMove"));
               charStats.put("jobRank", rs.getInt("jobRank"));
               charStats.put("jobRankMove", rs.getInt("jobRankMove"));
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
     
    public HashMap<Integer, String> getCharID(){
        return charID;
    }
    
    public ArrayList<Integer> getCharIDList(){
        
        return charIDList;
    }
    
    public int getCharStat(String x){
        
        return charStats.get(x);
    }
    
    public String getCharName(int x){
        
        return charID.get(x);
    }
    
    public int getnCharEquipment(){
        return charEquipment.size();
    }
    
    public ArrayList<Integer> getEquipment(){
        return charEquipment;
    }
    
    public HashMap<String, Integer> getStats(){
        return charStats;
    }
    
    public void loadPic(){
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = con.prepareStatement("SELECT pic FROM accounts WHERE id = ? ");
            ps.setInt(1, c.getAccID());
            rs = ps.executeQuery();
            if (rs.next()){
               pic = rs.getString("pic");
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
        c.setPic(pic);
    }
    
    public String getPic(){
        return pic;
    }
       
}
