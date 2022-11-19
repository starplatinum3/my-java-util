package top.starp.biShi.xunFei;

import java.util.Scanner;
//作者：keboom
//链接：https://www.nowcoder.com/discuss/694779?type=0&order=0&pos=14&page=1&channel=-1&source_id=discuss_center_0_nctrack
//来源：牛客网
//
//第二部分
//算法题三道，ACM模式，可用IDE
//
//第一题
//给N个杯子倒扣在桌面上，在第X个杯子中有一个球，移动杯子里面的球会跟着移动，经过K次移动，求最后那个球在第几个杯子中？
//
//输入：
//
//1
//2
//3
//4
//5
//3 2
//3
//1 3
//3 2
//1 2
//输出
//
//1
//3
//（输入的意思是有3个杯子，球在第2个杯子中，经过三次移动，第一次移动为第一个与第三个杯子交换位置，第二次移动为第三个杯子与第二个杯子交换，第三次移动为第一个杯子与第二个杯子交换。最终输出3，意思为球最终在第三个杯子中）
//
//我的代码：

//3 2
//3
//1 3
//3 2
//1 2
//3
public class N个杯子倒扣在桌面 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int K = sc.nextInt();
        int[] cups = new int[N + 1];
        cups[X] = 1;
        for (int i = 0; i < K; i++) {
            int cup1 = sc.nextInt();
            int cup2 = sc.nextInt();
            swap(cups,cup1,cup2);
        }
        for (int i = 1; i <= cups.length; i++) {
            if (cups[i] == 1) {
                System.out.println(i);
                return;
            }
        }
    }

    private static void swap(int[] cups, int i, int j) {
        int tmp = cups[i];
        cups[i] = cups[j];
        cups[j] = tmp;
    }
}



