package top.starp.biShi.xunFei;

import java.util.Scanner;

/**
 * 前言
 *        简单记录一下笔试情况。
 *
 * 一、转换整数
 * 题目简介
 *        汉宁窗公式 ：H(n)=0.5*(1-cos(2PIn/N))，N 为窗长度，0<= n < N，PI=3.1415927。
 *        对任意长度为 N 的双字节整数序列 x(n)，加窗之后 y(n) =x(n) *H(n)。
 *        即输入一个整数序列，对其按照上面的公式做一个转换即可。要求对输出 y(n) 四舍五入取整数部分。
 *        {正数： int(x+0.5) 负数：int(x-0.5) }
 *
 * 代码实现
 *       输入数据：32
 * 1953 2347 16 -1042 -1546 -933 -1946 -2722 -427 2111 3260 -1265 -8196 -8766 -2922 4135 6564 4644 2726 2789 4939 4451 149 -2320 -1348 2211 3370 900 -886 -1998 -643 172
 *       输出数据：0 23 1 -88 -226 -207 -601 -1095 -214 1261 2254 -984 -6996 -8027 -2811 4095 6564 4599 2622 2554 4216 3462 103 -1386 -674 890 1040 200 -130 -168 -24 2
 * ————————————————
 * 版权声明：本文为CSDN博主「消逝者」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：<a href="https://blog.csdn.net/Little_ant_/article/details/125957608">...</a>
 */
public class Main1 {
    static double PI=3.1415927;
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int[] res=new int[N];


        for(int i=0;i<N;i++){
            int tmp=s.nextInt(); // tmp ->  x(i)
            double d=tmp*(0.5*(1-Math.cos(2*PI*i/N)));// 计算 d -> y(i)

            if(d>0)
                d+=0.5;
            else if(d<0)
                d-=0.5;
            res[i]=(int)d;  //四舍五入 取整保存在 res 中。
        }



        for(int i=0;i<N-1;i++) // 注意输出格式
            System.out.print(res[i]+" ");
        System.out.println(res[N-1]);
    }
}
