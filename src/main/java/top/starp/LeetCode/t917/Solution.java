package top.starp.LeetCode.t917;

import top.starp.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.reverseOnlyLetters("ab-cd");
    }
    public String reverseOnlyLetters(String s) {

        List<Character> list=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isAlphabetic(c)) {
                //continue;
                list.add(c);
            }
            //list.add(c);
            //if()
        }
        //int idx=list.size()-1;
        int idx=0;
        char[] chars = s.toCharArray();
        //ArrayUtil.pr
        System.out.println("chars");
        System.out.println(chars);
        for (int i = chars.length - 1; i >= 0; i--) {
            char aChar = chars[i];
            if(Character.isAlphabetic(aChar)){
                Character characterChange = list.get(idx);
                //System.out.println("characterChange");
                //System.out.println(characterChange);
                chars[i]=list.get(idx);
                //idx--;
                idx++;
                //System.out.println("chars");
                //System.out.println(chars);
            }
        }
        //chars.
        StringBuilder res= new StringBuilder();
        for (char aChar : chars) {
            res.append(aChar);
        }
        System.out.println("res");
        System.out.println(res);
        return res.toString();
        //String string = Arrays.toString(chars);
        //System.out.println("string");
        //System.out.println(string);
        //return  string;
    }
}