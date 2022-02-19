package top.starp.LeetCode.t150;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.test();
    }
    void  test(){
        String str1="[\"4\",\"13\",\"5\",\"/\",\"+\"]";
//        JSO
        String[]strings = JSON.parseObject(str1, String[].class);
        int i = evalRPN(strings);
        System.out.println("i");
        System.out.println(i);
    }
    public int evalRPN(String[] tokens) {
//["4","13","5","/","+"]

        //int []nums=new int[];
        List<Integer> list=new ArrayList<>();
        for (String token : tokens) {
            if(token.equals("+")){
                Integer remove1 = list.remove(list.size() - 1);
                Integer remove2 = list.remove(list.size() - 1);
                list.add(remove1+remove2);
            }
           else if(token.equals("-")){
                Integer remove1 = list.remove(list.size() - 1);
                Integer remove2 = list.remove(list.size() - 1);
                //list.add(remove1-remove2);
                list.add(remove2-remove1);
            }
            else if(token.equals("*")){
                Integer remove1 = list.remove(list.size() - 1);
                Integer remove2 = list.remove(list.size() - 1);
                list.add(remove1*remove2);
            }
            else if(token.equals("/")){
                //remove  size 也会变吗
                Integer remove1 = list.remove(list.size() - 1);
                Integer remove2 = list.remove(list.size() - 1);
                //list.add(remove1/remove2);
                list.add(remove2/remove1);
            }else{
                int i = Integer.parseInt(token);
                list.add(i);
            }

        }
        System.out.println("list.size()");
        System.out.println(list.size());
        return list.get(0);
    }
}