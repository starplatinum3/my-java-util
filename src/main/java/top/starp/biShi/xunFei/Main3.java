package top.starp.biShi.xunFei;

import java.util.*;

/*
三、计算球队得分情况
题目简介
       有5支球队，进行单循环比赛，每个球队都只和另一只球队打一场。一共10场比赛，求有多少种得分情况（得分情况降序排列，需要去重）？
       以及给定一组得分情况，判断其是否合理？
      回溯 ，依次来判断，每场比赛只有三种可能性，one Vs another， 要么赢，要么输，要么平。

代码实现
————————————————
版权声明：本文为CSDN博主「消逝者」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Little_ant_/article/details/125957608

 */
public class Main3 {
    final static int Teams=5; //有五只队伍
    final static int Rounds=10; // 轮次有10场， 每支队伍只和其余队伍打一场
    static HashSet<List<Integer>> set=new HashSet<>(); // 存放得分信息的 set
    static int[][] r=new int[Rounds][2];  // 每一场比赛的参赛队伍
    static HashMap<Integer,Integer> scoreOfTeam=new HashMap<>();// 用来记录每种得分情况

    private static void compute(int start){
        if(start==Rounds){
            List<Integer> l=new ArrayList<>();
            for(int i:scoreOfTeam.values())
                l.add(i);
            l.sort((a, b) -> {
                return b - a;
            }); //降序排列
            set.add(l);
        }
        for(int i=start;i<Rounds;i++){
            int one=r[i][0],another=r[i][1];
            // one 赢 another
            scoreOfTeam.put(one,scoreOfTeam.get(one)+3);
            scoreOfTeam.put(another,scoreOfTeam.get(another)+0);// 这一步可以省略
            compute(i+1);
            // one 输 another
            scoreOfTeam.put(one,scoreOfTeam.get(one)-3);
            scoreOfTeam.put(another,scoreOfTeam.get(another)+3);
            compute(i+1);
            // one 平 another
            scoreOfTeam.put(one,scoreOfTeam.get(one)+1);
            scoreOfTeam.put(another,scoreOfTeam.get(another)-2);
            compute(i+1);
            // 复原 reset
            scoreOfTeam.put(one,scoreOfTeam.get(one)-1);
            scoreOfTeam.put(another,scoreOfTeam.get(another)-1);
        }
    }

    public static void main(String[] args) {
        // 初始化 r, 参赛队伍信息。 参赛队伍为： 0 1 2 3 4
        int index=0;
        for(int i=0;i<Teams;i++){ // 这里也可以写成 i<Teams-1;
            for(int j=i+1;j<Teams;j++){
                r[index][0]=i;
                r[index][1]=j;
                index++;
            }
        }
        // 初始化 hashMap, 刚开始每只队伍得分均为 0
        for(int i=0;i<Teams;i++)
            scoreOfTeam.put(i,0);

        compute(0);

        System.out.println(set.size());
        List<Integer> input=new ArrayList<>(Arrays.asList(6,5,5,5,4));  
        System.out.println(set.contains(input));
    }
}

