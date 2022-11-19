package top.starp.biShi.xunFei;

import java.util.Arrays;
import java.util.Scanner;
//作者：keboom
//链接：https://www.nowcoder.com/discuss/694779?type=0&order=0&pos=14&page=1&channel=-1&source_id=discuss_center_0_nctrack
//来源：牛客网
//
//第二题
//有n个基站，我们还可以多设置k个基站，问我们怎么设置基站能够使噪音最小，返回最小噪音。
//
//输入：
//
//1
//2
//3 1
//1 4 5
//意思为已经有三个基站，我们还可以再设置一个基站。那么目前噪音为max{4-1，5-4} = 3
//
//那么我们在1和4之间建立基站2，那么噪音为max{2-1，4-2，5-4} = 2，那么最终返回2
//
//输出
//
//1
//2
//我的想法是将这些基站位置放到int数组中，循环k次设置多出来的基站，每次我们寻找基站之间的距离最远的在其中间设置一个基站。这样k次之后得到噪音就是所求。
//
//之前我一直纠结怎么存放数据，是不是要放到TreeMap中，之后想到用数组，然后排序一下就行了。
//
//没时间提交了，也不知道对不对
public class 以多设置k个基站 {
//    idea 只能回车 一个

     static int n;
    static int k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] zhan = new int[n + k];
        for (int i = 0; i < n; i++) {
            zhan[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = maxZao(zhan);
        }
        System.out.println(max);
    }


    private static int maxZao(int[] zhan) {
        Arrays.sort(zhan);
        int max = 0;
        int index=0;
        for (int i = 1; i < zhan.length; i++) {
            if (zhan[i] - zhan[i - 1] > max) {
                max = zhan[i] - zhan[i - 1];
                index = i;
            }
        }
        k--;
        zhan[n++] = (zhan[index] - zhan[index - 1])/2;
        return max;
    }

}
