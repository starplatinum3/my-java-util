package top.starp.LeetCode.t819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    static boolean contains(String[] lst, String word) {
        for (String word1 : lst) {
            if (word1.equals(word)) {
                return true;
            }

        }
        return false;
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
//            word = word.trim(",.");
//            String strip = word.strip(",.");
//            word= word.replace("[,.]","");
            word= word.replace(".","");
            word= word.replace(",","");
//            word.trim()
            word=word.toLowerCase();
            if (!contains(banned, word)) {
                if (map.containsKey(word)) {
//  map.put(map.get(word)+1,1);
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }

            }
        }
        int max = 0;
        String res = "";
//        map java遍历
//        map.forEach((k, v) -> {
//            if (max < v) {
//                max = v;
//                res = k;
//            }
//        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if (max < mapValue) {
                max = mapValue;
                res = mapKey;
            }
//            System.out.println(mapKey + "：" + mapValue);
        }


//        for((k,v) :map){
//
//        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        System.out.println("s");
        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String next = scanner.next();

        List<Integer>list= Arrays.asList(1,3);
        list.sort((o1,o2)->{
            return  o1-o2;
        });


    }
}
