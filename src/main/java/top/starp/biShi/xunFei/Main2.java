package top.starp.biShi.xunFei;

import java.util.Scanner;

/*
二、判断三角形个数
题目简介
       二维坐标上有 N 个点，任意一个点都可能构成三角形，计算这些三角形中直角三角形的个数。
      暴力枚举：遍历所有三个点构成的组合，判断是否满足勾股定理。后面采用 for 循环和回溯分别来实现。
      输入数据：20
0 0 0 3 1 2 3 4 5 6 7 8 1 4 2 4 3 5 5 0 5 5 2 0 2 2 3 0 3 3 4 5 6 1 3 7 4 0 5 2
      输出数据：165

代码实现1
————————————————
版权声明：本文为CSDN博主「消逝者」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/Little_ant_/article/details/125957608
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();
        int[][] pos=new int[260][2];// N <=256
        for(int i=0;i<N;i++){
            pos[i][0]=s.nextInt();
            pos[i][1]=s.nextInt();
        }

        int res=0;
        for(int i=0;i<N-2;i++)
            for(int j=i+1;j<N-1;j++)
                for(int k=j+1;k<N;k++){
                    // x, y, z 分别为三条边的平方。
                    // A(x1,y1)、B(x2,y2)，则A和B两点之间的距离为：∣AB∣=√[(x1－x2)^2+(y1－y2)^2]

                    int x1=pos[i][0];
                    int x2=pos[j][0];
                    int y1=pos[i][1];
                    int y2=pos[j][1];
                    int xIdx=0;


                    int xDis=pos[i][0]-pos[j][0];
                    double x=Math.pow(pos[i][0]-pos[j][0],2)+Math.pow(pos[i][1]-pos[j][1],2);
                    double y=Math.pow(pos[j][0]-pos[k][0],2)+Math.pow(pos[j][1]-pos[k][1],2);
                    double z=Math.pow(pos[i][0]-pos[k][0],2)+Math.pow(pos[i][1]+-pos[k][1],2);
                    int xx= (int) x,yy=(int) y,zz=(int) z;
                    if(x+y==z||x+z==y||y+z==x)
                        res++;
                }
        
        System.out.println(res);
    }
}
