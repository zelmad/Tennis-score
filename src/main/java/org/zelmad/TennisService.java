package org.zelmad;

import java.util.HashMap;
import java.util.Map;

public class TennisService {

    public static final String ADVANTAGE = "advantage";

    public String getWinner(String input){
        Map<String, String> map = new HashMap<>();
        map.put("A", "0");
        map.put("B", "0");
        for(int i=0; i<input.length();i ++){
            String playerAScore = map.get("A");
            String playerBScore = map.get("B");
            if('A' == input.charAt(i)) {
                if(ADVANTAGE.equals(playerBScore)){
                    map.put("B", "40");
                } else if(ADVANTAGE.equals(playerAScore) || ("40".equals(playerAScore) && !"40".equals(playerBScore))) {
                    return "Player A wins the game";
                } else  {
                    addValue("A", map);
                }
                System.out.println("Player A : " + map.get("A") + " / Player B : " + map.get("B"));
            } else {
                if(ADVANTAGE.equals(playerAScore)){
                    map.put("A", "40");
                } else if(ADVANTAGE.equals(playerBScore) || (!"40".equals(playerAScore) && "40".equals(playerBScore))) {
                    return "Player B wins the game";
                } else  {
                    addValue("B", map);
                }
                System.out.println("Player A : " + map.get("A") + " / Player B : " + map.get("B"));
            }
        }
        return "";
    }

    private void addValue(String key, Map<String, String> map) {
        String value = map.get(key);
        if ("0".equals(value)){
            map.put(key, "15");
        }else if("15".equals(value)){
            map.put(key, "30");
        } else if("30".equals(value)) {
            map.put(key, "40");
        } else if("40".equals(value)) {
            map.put(key, ADVANTAGE);
        }
    }
}