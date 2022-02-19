package top.starp.LeetCode.t1189;

import java.util.HashMap;
import java.util.Map;

//ac
//https://leetcode-cn.com/problems/maximum-number-of-balloons/
class Solution {
    public int maxNumberOfBalloons(String text) {

        String balloon = "balloon";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (balloon.contains(c + "")) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

        }



        String needOne = "ban";
        String needTwo = "lo";
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < balloon.length(); i++) {
            char c = balloon.charAt(i);
            Integer integer = map.get(c);
                if (needOne.contains(c + "")) {
                    Integer orDefault = map.getOrDefault(c, 0);
                    if(orDefault<=0){
                        return 0;
                    }
                }else if(needTwo.contains(c + "")){
                    Integer orDefault = map.getOrDefault(c, 0);
                    if(orDefault<=1){
                        return 0;
                    }
                }
            //if(integer==null){
            //    return 0;
            //}

        }


        for (int i = 0; i < balloon.length(); i++) {
            char c = balloon.charAt(i);
            if (needOne.contains(c + "")) {
                //max = Math.max(max, map.getOrDefault(c, 0));
                min = Math.min(min, map.getOrDefault(c, 0));
            }else if(needTwo.contains(c + "")){
                //max = Math.max(max, map.getOrDefault(c, 0)/2);
                min = Math.min(min, map.getOrDefault(c, 0)/2);
            }

        }
        //return max;
        return min;
    }
}