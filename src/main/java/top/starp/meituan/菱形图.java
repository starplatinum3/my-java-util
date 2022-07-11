package top.starp.meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 菱形图
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 菱形是一类非常优美的图形：其对边对称，四条边长度相等。例如正方形就是一类特殊的菱形。对于图论而言，菱形图是指一个无向图形成的环，满足点数大于等于4，其中可以找到四个不相同的点a,b,c,d，使得a→b，b→c，c→d，d→a的距离都相等。
 *
 * 小美刚刚学完图论。她随手造了一张n个点m条无向边的图（不含重边和自环，保证连通，即任意两个点都互相可达），她想知道这张图是不是菱形图。（本题目中，我们默认两点之间的距离为1）
 *
 *
 *
 * 输入描述
 * 第一行一个正整数T，表示有T组数据。
 *
 * 对于每一组数据，第一行两个正整数n，m，表示无向图的点数和边数；
 *
 * 第二行m个正整数ui；第三行m个正整数vi，表示ui与vi之间有一条无向边。
 *
 * 数据保证无重边和自环且图连通。数字间两两有空格隔开。
 *
 * 4≤n≤m≤104 ，1≤ui,vi≤n ，1≤T≤8
 *
 * 输出描述
 * 对于每一组数据，如果其是菱形图，输出一行Yes；否则，输出一行No。
 *
 *
 * 样例输入
 * 3
 * 8 8
 * 1 3 7 8 5 6 2 4
 * 3 7 8 5 6 2 4 1
 * 9 9
 * 1 3 7 8 5 6 2 4 3
 * 3 7 8 5 6 2 4 1 9
 * 7 7
 * 1 5 6 7 3 4 2
 * 5 6 7 3 4 2 1
 * 样例输出
 * Yes
 * No
 * No
 *
 * 提示
 * 第一组样例如图：
 *
 *
 *
 * 不难发现可以选择1,2,5,7四个点，距离都为2。并且整个图是一个环。
 *
 *
 *
 * 第二组样例如图：
 *
 *
 *
 * 整个图不是一个环。
 *
 *
 *
 * 第三组样例如图：
 *
 *
 *
 * 整个图是一个环，但是找不到满足条件的这样四个点。
 */
public class 菱形图 {
    static  class  Edge{
        int u;
        int v;
    }
  static   int maxN=4*10000+7;
  static   boolean [] vis=new boolean[maxN];
//    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//  static   int [][] grid=new int[maxN][maxN];
  static  int head;
    static  int poiCnt;
    static  class Ajen{
        List<Integer> ajens=new ArrayList<>();
    }
  static   Ajen [] ajenMap;
   static void doOne(Scanner scanner){
         poiCnt = scanner.nextInt();
        int edgeCnt = scanner.nextInt();
        if(poiCnt%4!=0){
            System.out.println("No");
            return;
        }
//        for (int i = 0; i < grid.length; i++) {
//            for (int i1 = 0; i1 < grid[i].length; i1++) {
//                grid[i][i1]=0;
//            }
//        }
        for (int i = 0; i < vis.length; i++) {
            vis[i]=false;
        }

        int [] u=new int[edgeCnt];
        int [] v=new int[edgeCnt];
        Edge [] edges=new Edge[edgeCnt];
//       List<Integer> ajens=new ArrayList<>();
     ajenMap=new Ajen[maxN];
       for (int i = 0; i <maxN ; i++) {
           ajenMap[i]=new Ajen();
       }
//       List<Integer> []  ajenMap=new List<Integer>[1];
        for (int i = 0; i <edgeCnt ; i++) {
            edges[i]=new Edge() ;
            edges[i].u=scanner.nextInt();
//            u[i]=scanner.nextInt();
        }
        for (int i = 0; i <edgeCnt ; i++) {

            edges[i].v=scanner.nextInt();
//            u[i]=scanner.nextInt();
//            grid[edges[i].u][edges[i].v]=1;
//          int uName=  edges[i].u;
//            System.out.println("uName");
//            System.out.println(uName);
//            Ajen ajen=  ajenMap[edges[i].u];
//            System.out.println("ajen");
//            System.out.println(ajen);
//           List<Integer> als=  ajenMap[edges[i].u].ajens;
//            System.out.println("als");
//            System.out.println(als);
            ajenMap[edges[i].u].ajens.add(edges[i].v);
        }
//       System.out.println("输入完毕");
        head=edges[0].u;
        no=false;
        doBreak=false;
        dfs(head,0);

    }
    static boolean no=false;
    static boolean doBreak=false;
    static  void dfs(int u,int cnt){
        if(doBreak){
            return;
        }
        if(vis[u]){
//            最后能break 嘛
            if(no){
                doBreak=true;
                System.out.println("No");
                return;
            }
//            已经访问的过的 再次访问了 只能是回到头了
            if(head!=u){
//                不是的话 说明有问题了
                System.out.println("No");
                return;
            }
//            如果不是最后一个 现在的个数是。。
            if(cnt!=poiCnt){
                System.out.println("No");
                return;
            }
            System.out.println("Yes");
            return;
        }
        if(ajenMap[u].ajens.size()!=1){
//            这里打印不行啊
            no=true;
//            System.out.println("No");
//            return;
        }
        vis[u]=true;
        for (Integer ajen : ajenMap[u].ajens) {
            dfs(ajen,cnt+1);
        }
//        for (int v = 0; v <maxN ; v++) {
//            if(grid[u][v]==1){
////                有边
//                dfs(v,cnt+1);
//
//            }
//        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-->0){
            doOne(scanner);
        }
    }
}
