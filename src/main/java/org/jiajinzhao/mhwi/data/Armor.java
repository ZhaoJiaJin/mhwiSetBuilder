package org.jiajinzhao.mhwi.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Armor {
  private final String nameEn;
  private final String type;
  private String nameZh;
  private List<Integer> slots = new ArrayList(3);
  private HashMap<String, Integer> skills = new HashMap<>();

  public Armor(String nameEn,String type){
    this.nameEn = nameEn;
    this.type = type;
  }

  public void setSkills(String name, String level){
    int levelInt = Integer.parseInt(level);
    if (levelInt <= 0){
      return;
    }
    skills.putIfAbsent(name,levelInt);
  }

  public void setNameZh(String nameZh) {
    this.nameZh = nameZh;
  }

  public void addSlot(String level){
    int levelInt = Integer.parseInt(level);
    if (levelInt <= 0){
      return;
    }
    slots.add(levelInt);
  }


  @Override
  public String toString() {
    return "Armor{" +
        ", nameZh='" + nameZh + '\'' +
        '}';
  }
}
