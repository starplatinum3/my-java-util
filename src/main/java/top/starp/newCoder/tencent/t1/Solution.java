package top.starp.newCoder.tencent.t1;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *https://blog.csdn.net/msthriving/article/details/114991272
     * @param str string字符串
     * @return string字符串
     */
    public String compress (String str) {
        // write code here
        int x = -1;//第一个"]"对应的"["的索引
        int y = -1;//"|"的索引
        int z = -1;//第一个"]"的索引
        int index = 0;
        String result = str;
        while (index <str.length()){
            if(str.charAt(index) == '['){
                x = index;
            }else if(str.charAt(index) == '|'){
                y = index;
            }else if(str.charAt(index) == ']'){
                z = index;//如果找到']'，说明已经找到了第一个[m|S];此时退出循环，进行解压缩
                break;
            }
            index++;
        }

        if(x != -1){//x不等于-1说明存在待解压的字符串。
            String temp = str.substring(y+1,z);
            int count = Integer.parseInt(str.substring(x+1,y));
            String resultTemp = String.join("",Collections.nCopies(count,temp));
            result = str.substring(0,x) + resultTemp + str.substring(z+1);
            result = compress(result);//递归解压缩。
        }
        return result;
    }

}
