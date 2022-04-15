package top.starp.newCoder.byteDance.t2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().trim().split(" ");
        int n = Integer.parseInt(str[0]); //珠子的个数
        int maxSeriCnt = Integer.parseInt(str[1]);//连续m个珠子
        int c = Integer.parseInt(str[2]);//颜色种类
        Map<Integer,List<Integer>> map = new HashMap<>();// key：颜色， value:包含这种颜色的珠子
        for (int pos = 0; pos < n; ++pos) {
            String[] s = br.readLine().trim().split(" ");
            int num_i = Integer.parseInt(s[0]);
//            有几个 颜色 一个珠子上面
            for (int j = 1; j <= num_i; ++j) {
//                每一种颜色
                int color = Integer.parseInt(s[j]);
                if (!map.containsKey(color)) {
                    List<Integer> judeList = new ArrayList<>();
                    judeList.add(pos);

                    map.put(color,judeList);
                }else {
                    map.get(color).add(pos);
                }
            }
        }
        int count = 0;
        for(List<Integer> judeList : map.values()){
            System.out.println("=======");
//            每种颜色的 他的位置 的好几个
            System.out.println("judeList");
            System.out.println(judeList);
            for(int j=0; j<judeList.size();j++) {
//                相邻的两个珠子 的位置


                if (j+1<judeList.size() && judeList.get(j+1)- judeList.get(j)<maxSeriCnt){
                    Integer integer = judeList.get(j + 1);
                    Integer integer1 = judeList.get(j);
                    System.out.println("integer");
                    System.out.println(integer);
                    System.out.println("integer1");
                    System.out.println(integer1);
                    count++;
                    break;
                }else if(j+1 == judeList.size() && judeList.get(0)+n-judeList.get(j)<maxSeriCnt){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}




