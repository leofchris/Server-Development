/*
	This file is part of the OdinMS Maple Story Server
    Copyright (C) 2008 Patrick Huy <patrick.huy@frz.cc>
		       Matthias Butz <matze@odinms.de>
		       Jan Christian Meyer <vimes@odinms.de>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as
    published by the Free Software Foundation version 3 as published by
    the Free Software Foundation. You may not use, modify or distribute
    this program under any other version of the GNU Affero General Public
    License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package provider;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import provider.wz.MapleDataType;

public class MapleDataTool {
    public static String getString(MapleData data) {
        return ((String) data.getData());
    }

    public static String getString(MapleData data, String def) {
        if (data == null || data.getData() == null) {
            return def;
        } else {
            return ((String) data.getData());
        }
    }

    public static String getString(String path, MapleData data) {
        return getString(data.getChildByPath(path));
    }

    public static String getString(String path, MapleData data, String def) {
        return getString(data.getChildByPath(path), def);
    }

    public static double getDouble(MapleData data) {
        return ((Double) data.getData()).doubleValue();
    }

    public static float getFloat(MapleData data) {
        return ((Float) data.getData()).floatValue();
    }

    public static int getInt(MapleData data) {
        if (data == null || data.getData() == null) {
            return 0;// DEF?
        }
        return ((Integer) data.getData()).intValue();
    }

    public static int getInt(String path, MapleData data) {
        return getInt(data.getChildByPath(path));
    }

    public static int getIntConvert(MapleData data) {
        if (data.getType() == MapleDataType.STRING) {
            return Integer.parseInt(getString(data));
        } else {
            return getInt(data);
        }
    }

    public static int getIntConvert(String path, MapleData data) {
        MapleData d = data.getChildByPath(path);
        if (d.getType() == MapleDataType.STRING) {
            return Integer.parseInt(getString(d));
        } else {
            return getInt(d);
        }
    }

    public static int getInt(MapleData data, int def) {
        if (data == null || data.getData() == null) {
                return def;
        } else if (data.getType() == MapleDataType.STRING) {
                 return Integer.parseInt(getString(data));
        } else {
            return ((Integer) data.getData()).intValue();
        }
      
    }
    
    public static int getInt(MapleData data, int def, int curLvl) {
        if (data == null || data.getData() == null) {
                return def;
        } else if (data.getType() == MapleDataType.STRING) {
           
                 return (int)getEquation(data, curLvl);
            
        } else {
            return ((Integer) data.getData()).intValue();
        }
       
    }
    
     public static int getIntCommon(MapleData data, int def, int curLvl) {
        if (data == null || data.getData() == null) {
            return  def;
        }
        return (int)getEquation(data, curLvl);
    }

    public static int getInt(String path, MapleData data, int def, int curLvl) {
        if (data.getChildByPath(path) == null)
          return def;
        
        return getInt(data.getChildByPath(path), def, curLvl);
    }
    
    public static int getIntCommon(String path, MapleData data, int def, int curLvl){
      
        return getIntCommon(data, def, curLvl);
    }   

    public static int getIntConvert(String path, MapleData data, int def, int curLvl) {
        MapleData d = data.getChildByPath(path);
        if (d == null) {
            return def;
        }
        if (d.getType() == MapleDataType.STRING) {
            try {
                return (int)getEquation(d, curLvl);
            } catch (NumberFormatException nfe) {
                return def;
            }
        } else {
            return getInt(d, def);
        }
    }
    
    public static int getIntConvertCommon(String path, MapleData data, int def, int curLvl){
        if(!(data.getName().equals(path))){
            return def;
        } 
        return (int)getEquation(data, curLvl);
    }

    public static BufferedImage getImage(MapleData data) {
        return ((MapleCanvas) data.getData()).getImage();
    }

    public static Point getPoint(MapleData data) {
        return ((Point) data.getData());
    }

    public static Point getPoint(String path, MapleData data) {
        return getPoint(data.getChildByPath(path));
    }

    public static Point getPoint(String path, MapleData data, Point def) {
        final MapleData pointData = data.getChildByPath(path);
        if (pointData == null) {
            return def;
        }
        return getPoint(pointData);
    }

    public static String getFullDataPath(MapleData data) {
        String path = "";
        MapleDataEntity myData = data;
        while (myData != null) {
            path = myData.getName() + "/" + path;
            myData = myData.getParent();
        }
        return path.substring(0, path.length() - 1);
    }
    
    public static double getEquation(MapleData data, int curLvl){
     
     StringBuilder equation = null;
     ScriptEngineManager man = new ScriptEngineManager();
     ScriptEngine engine = man.getEngineByName("javascript");
     double value = 0;
     if (String.class.isInstance(data.getData())){
         equation = new StringBuilder(getString(data));
         
         if(equation.indexOf("x") >= 0){
         
            if(equation.indexOf("u") >= 0){
                
            int uPos = equation.indexOf("u");
            int xPos = equation.indexOf("x");
            
            equation.deleteCharAt(xPos);
            equation.insert(xPos, curLvl);
            equation.deleteCharAt(uPos);
            equation.insert(uPos, "Math.ceil");
           
           try{
              value = ((Double)engine.eval(equation.toString())).doubleValue();
            } catch(Exception e){    
           }

         } else if (equation.indexOf("d") >= 0){
            int dPos = equation.indexOf("d");
            int xPos = equation.indexOf("x");
            
            equation.deleteCharAt(xPos);
            equation.insert(xPos, curLvl);
            equation.deleteCharAt(dPos);
            equation.insert(dPos, "Math.floor");
           
           try{
           value = ((Double)engine.eval(equation.toString())).doubleValue();
           } catch(Exception e){   
          } 
        } else {
          int xPos = equation.indexOf("x");
          equation.deleteCharAt(xPos);
          equation.insert(xPos, curLvl);
         try{ 
         value = ((Double)engine.eval(equation.toString())).doubleValue();
         } catch(Exception e){   
        }
       }
    } else{
          if(!(equation.toString().matches(".*\\d.*"))){
                 return 0;
             }else{
                 try{
                   return ((Double)engine.eval(equation.toString())).doubleValue();
         }
            catch(Exception e){
                
            }
             }     
            
         }
   
     } else if (Integer.class.isInstance(data.getData())){
       return (int)data.getData();
     }
     
     
     
    
    return value;
}
}
