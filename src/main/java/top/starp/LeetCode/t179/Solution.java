package top.starp.LeetCode.t179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//ac
class Solution {
    public String largestNumber(int[] nums) {
        //Arrays.stream(nums).sorted().
        //nums.sort

        //Arrays.sort(nums);
        //List<String >list=new ArrayList<>();
        List<String> collect = Arrays.stream(nums).mapToObj(o -> {
            return o + "";
        }).collect(Collectors.toList());
        collect.sort((o1,o2)->{
           //return (o1+o2).compareTo((o2+o1));
           return (o2+o1).compareTo((o1+o2));
        });

        //collect.stream().su
        //collect.stream().
        StringBuilder res= new StringBuilder();
        boolean allZero=true;
        for (String s : collect) {
            if(!s.equals("0")){
                allZero=false;
            }
            res.append(s);
        }
        if(allZero){
            return "0";
        }
        return res.toString();
        //return "";
    }
}