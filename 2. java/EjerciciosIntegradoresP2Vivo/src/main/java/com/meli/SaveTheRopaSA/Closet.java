package com.meli.SaveTheRopaSA;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Closet {

    private Integer autoincrement = 0;
    private Map<Integer,List<Garmen>> drawerMap = new HashMap<>();

    public Map getDrawerMap() {
        return drawerMap;
    }

    public void setDrawerMap(Map drawerMap) {
        this.drawerMap = drawerMap;
    }

    public Integer saveGarmen(List<Garmen> garmenList){
        autoincrement+=1;
        this.drawerMap.put(autoincrement,garmenList);
        return Integer.valueOf(autoincrement);
    }

    public void showGarmen() {
        this.drawerMap.forEach(
                (k,v) -> System.out.println("Key: [" + k + "]"
                        + " Value: " + v.stream().collect(Collectors.toList()) )
        );
    }

    public List<Garmen> getGarmen(Integer id) {
        for(Map.Entry<Integer,List<Garmen>> c : this.drawerMap.entrySet()){
            if(c.getKey().equals(id)){
                return c.getValue();
            }
        }
        return null;
    }

}
