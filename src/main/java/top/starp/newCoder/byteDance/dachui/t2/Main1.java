package top.starp.newCoder.byteDance.dachui.t2;// 解题思路：
//   原问题等价于，有序的正整数中取三个，最大最小差值小于等于D
//   假设三个张最大的为max，依次遍历max值取a[i](i>=2)的可能性与可能情况数目。
import java.util.Scanner;

//https://blog.csdn.net/qq_37717494/article/details/104987401
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numBuildings = in.nextInt();//建筑物的个数
        int maxDis = in.nextInt(); //距最远的两名特工间的距离不超过D
        int[] pos = new int[numBuildings];//定义一个数组来接收位置
        //while(in.hasNext()){
            for(int i = 0;i<numBuildings;i++){
                pos[i] = in.nextInt();
            }
            System.out.println(new allWay().func(pos,maxDis));
        //}
    }

}
class allWay{
    private long count = 0 ;
    private final int mod = 99997867;

    public static void main(String[] args) {
        long c = C(2);
        System.out.println("c");
        System.out.println(c);
//        1
    }
//    1 2 3 4 5
    public long func (int[] pos,int maxDis){
        for(int after = 0,front= 0 ;after<pos.length;after++){
            //因为有三个特工，所以i>=2的时候取dist[2]是第三个特工
            //这时候j=0，dist[i]-dist[j]>D是比较最近和最远的距离
//            为什么i  >=2
//                  0 1 2  不然就没有2 距离超过了 j往前走点 咱们要离得近点
//            中间的那个可以随意了 因为在maxDis 的范围内 中间就可以随便来
//                    1 2 3 4 5
//           ( 1 )2 3 4 (5)
//            中间可以 2 3 4
//            1 2 3 4 5

//            1 2 3
//            1 2 3
//                1 2 5
//            1 3 4..5
//            1 4 5
//            3 +2 +1  就是 n(n-1)/2
            while(after>= 2 && pos[after]-pos[front] > maxDis){
                front++; //满足距离小于等于D的时候，个数加一
            }
//            1 (2 3 4)

            int res=after-front;
            System.out.println("===========");
            System.out.println("after");
            System.out.println(after);
            System.out.println("front");
            System.out.println(front);
            System.out.println("res");
            System.out.println(res);
            count += C(after-front);
        }
        return count % mod ; //最后结果可能溢出，所以对mod取模
    }
    public static  long C(int n){
        return n*(n-1)/2;
    }
}
