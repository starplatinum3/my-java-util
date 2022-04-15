package top.starp.newCoder.byteDance;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); //读取用户个数
        String[] str = br.readLine().trim().split(" ");//读取每个用户的喜好度
        Map<Integer,List<Integer>> userLike = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int key = Integer.parseInt(str[i]);
//            喜好度
            if (!userLike.containsKey(key)) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
//                每个人的喜好度列表
                userLike.put(key,list);
            }else {
                userLike.get(key).add(i);
            }
        }
        int q = Integer.parseInt(br.readLine().trim());//读取查询组数
        for (int j = 0; j < q; ++j){
            String[] s = br.readLine().trim().split(" ");
            int l = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int count = 0;
            List<Integer> list = userLike.get(k);
            if (list != null) {
                for (Integer i : list){
//                    这个是暴力的吗
                    if (i >= l-1 && i <= r-1) {
                        ++count;
                    }
                }
            }
            System.out.println(count);
        }

    }
}
