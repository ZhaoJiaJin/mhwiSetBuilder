package org.jiajinzhao.mhwi.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ArmorManager {
  private static final String COMMA_DELIMITER = ",";
  private HashMap<String,Armor> armors = new HashMap<>();

  @Inject
  public ArmorManager(
      @Named("armor base") String armorBase,
      @Named("armor skills") String armorSkills,
      @Named("armor trans") String armorTrans
  ) throws IOException {
    setArmorBase(armorBase);
    setArmorSkills(armorSkills);
    setArmorTrans(armorTrans);
    System.out.println(armors);
  }

  public void search(HashMap<String, Integer> targetSkills){}

  private void setArmorBase(String fname) throws IOException {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fname);
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      int linecnt = 0;
      while ((line = bufferedReader.readLine()) != null) {
        linecnt ++;
        if (linecnt == 1){
          continue;
        }
        String[] values = line.split(COMMA_DELIMITER);
        String name = values[1];
        if (!name.endsWith("+")){
          continue;
        }
        Armor armor = new Armor(name,values[3]);
        armor.addSlot(values[5]);
        armor.addSlot(values[6]);
        armor.addSlot(values[7]);
        armors.putIfAbsent(name,armor);
      }
    }catch (Exception e){
      e.printStackTrace();
      throw e;
    }
  }

  private void setArmorSkills(String fname) throws IOException {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fname);
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      int linecnt = 0;
      while ((line = bufferedReader.readLine()) != null) {
        linecnt ++;
        if (linecnt == 1){
          continue;
        }
        String[] values = line.split(COMMA_DELIMITER);
        if (! armors.containsKey(values[0])){
          continue;
        }
        if(values.length >= 3) {
          armors.get(values[0]).setSkills(values[1], values[2]);
        }
        if(values.length >= 5) {
          armors.get(values[0]).setSkills(values[3], values[4]);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
      throw e;
    }

  }
  private void setArmorTrans(String fname) throws IOException {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fname);
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      int linecnt = 0;
      while ((line = bufferedReader.readLine()) != null) {
        linecnt ++;
        if (linecnt == 1){
          continue;
        }
        String[] values = line.split(COMMA_DELIMITER);
        if (armors.containsKey(values[0])) {
          armors.get(values[0]).setNameZh(values[values.length - 2]);
        }
      }
    }catch (Exception e){
      e.printStackTrace();
      throw e;
    }
  }
}
