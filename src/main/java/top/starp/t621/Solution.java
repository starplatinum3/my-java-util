package top.starp.t621;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] count = new int[26];
        int max = 0;
        for(int i = 0;i < tasks.length;i++){
            System.out.println("现在这个task是什么 给他增加 1"+tasks[i] );
            count[tasks[i] - 'A']++;
            if(count[tasks[i] - 'A'] > max) {
                System.out.println("=======");
                System.out.println("更新最大");
//                最大的是什么
                System.out.println("最大的是什么 "+tasks[i]);
                max = count[tasks[i] - 'A'];
            }
//            哪个字母是最大的额 个数
        }
        int same = 0;
        for(int i = 0;i < 26;i++){
            if(count[i] == max ){
                same++;
            }
        }
        int maybeMax=(n + 1) * (max - 1) + same;
//        间隔 +1
        System.out.println("maybeMax");
        System.out.println(maybeMax);
        return Math.max(tasks.length,maybeMax);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String [] strings=  new String[]{"A","A","A","B","B","B"};
        char [] chars=  new char[]{'A','A','A','B','B','B'};
        int i = solution.leastInterval(chars, 2);
        System.out.println(i);
//        String collect = Arrays.stream(strings).map(o -> "'" + o + "'").collect(Collectors.joining(","));
//        System.out.println(collect);
    }
}
