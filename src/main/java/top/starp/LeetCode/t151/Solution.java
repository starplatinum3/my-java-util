package top.starp.LeetCode.t151;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    String  getStr(String [] split,int end){
        StringBuilder res= new StringBuilder();
        //for (int i = split.length-1; i >=1; i--) {
        for (int i = end; i >=1; i--) {
            //System.out.print(split[i]);
            res.append(split[i]).append(" ");
        }
        res.append(split[0]);
        return res.toString();
    }
    public String reverseWords(String s) {

        String[] split = s.split(" ");
        //Arrays.stream(split).collect(Collectors.toList()).stream().reve
        //List<String> collect = Arrays.stream(split).collect(Collectors.toList());
        ////collect.rev
        //for (int i = collect.size()-1; i >=0 ; i--) {
        //    System.out.println();
        //}
        System.out.println("split");
        System.out.println(Arrays.toString(split));
        String[] splitNoBlank=new String[split.length];
        int idx=0;
        for (String s1 : split) {
            //if(StrU)
            if (s1.equals(" ")||s1.equals("")) {
                continue;
            }
            splitNoBlank[idx++]=s1;
        }

        String str = getStr(splitNoBlank,idx);
        return  str;
        //String collect = Arrays.stream(split).collect(Collectors.joining(" "));
        //StringBuilder res= new StringBuilder();
        //for (int i = split.length-1; i >=1; i--) {
        //    //System.out.print(split[i]);
        //    res.append(split[i]).append(" ");
        //}
        //res.append(split[0]);
        //return res.toString();
    }
}