package top.starp.meituan;

import java.util.Scanner;

//小美的仓库
//        时间限制： 3000MS
//        内存限制： 589824KB
//        题目描述：
//        小美的家乡遇到了特大暴雨。为此她建立了一个救援的大米仓库。有货车运来或取走大米。
//        现在有一列车队，每个车都要运来或取走一定的大米。假设小美的仓库最开始有 M千克大米，
//        它会在某辆车路过时打开仓库，这样这辆车以及后面的车辆都可以进入仓库运来或取走大米。
//        如果有一辆车取不到本想取到的大米，小美会提前关闭仓库，这辆车以及后面的车辆都不再能进入仓库。
//        （即小美的仓库会对车队的一个连续子串开放，且保证仓库内的大米不为负值）
//
//        请问小美的仓库最多有多少辆车进入。
//
//
//
//        输入描述
//        对于每一组数据，包含两行数据，第一行是车队的车辆数n和小美仓库本有的大米m，第二行是车队想取走（负值）或运来（正值）的大米ai，数字间两两有空格隔开。
//
//        1≤n≤50000， -109≤ai≤109，0≤m≤109
//
//        输出描述
//        输出一个整数，表示最多有多少辆车进入（最长连续子串）。
//
//
//        样例输入
//        4 10
//        -16 2 -6 8
//        样例输出
//        3
//
//        提示
//        样例解释
//
//        第一辆车路过如果开仓库，第一辆车无法取到16kg的大米，所以第二辆车路过时开，最后一辆关，共有3辆车路过。
//
//        规则
//        请尽量在全场考试结束10分钟前调试程序，否则由于密集排队提交，可能查询不到编译结果
//        点击“调试”亦可保存代码
//        编程题可以使用本地编译器，此页面不记录跳出次数
public class 小美的仓库 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = scanner.nextInt();
        int mi = scanner.nextInt();
        int miPut[] = new int[cnt];
        int seriLen = 0;
        int maxSeriLen = 0;
        for (int i = 0; i < cnt; i++) {
            miPut[i] = scanner.nextInt();
//            如果是负数 不够的话 就不要
            if (miPut[i] < 0) {
                if (-miPut[i] > mi) {

                }
//                不够
                else if (-miPut[i] <= mi) {
//                 够了
                    seriLen++;
                    maxSeriLen = Math.max(maxSeriLen, seriLen);
                }
            }else if (miPut[i]>=0){
//                往里面放
                mi+=miPut[i];
                seriLen++;
                maxSeriLen = Math.max(maxSeriLen, seriLen);
            }
//            if()
        }
        System.out.println(maxSeriLen);

    }
}
