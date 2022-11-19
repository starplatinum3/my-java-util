package top.starp.LeetCode.offer073;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int k = high;
        while (low < high) {
            int speed = (high - low) / 2 + low;
            long time = getTime(piles, speed);
            if (time <= h) {
                k = speed;
                high = speed;
            } else {
                low = speed + 1;
            }
        }
        return k;
    }

    public long getTime(int[] piles, int speed) {
        long time = 0;
        for (int pile : piles) {
            int curTime = (pile + speed - 1) / speed;
            time += curTime;
        }
        return time;
    }

    /**
     * 二分查找结束之后，即可得到在 hh 小时内吃掉所有香蕉的最小速度 kk。
     *
     * 实现方面，在计算吃掉每一对香蕉的时间时，由于 \textit{pile}pile 和 \textit{speed}speed 都大于 00，
     * 因此 \Big\lceil \dfrac{\textit{pile}}{\textit{speed}} \Big\rceil⌈
     * speed
     * pile
     * ​
     *  ⌉ 等价于 \Big\lfloor \dfrac{\textit{pile} + \textit{speed} - 1}{\textit{speed}} \Big\rfloor⌊
     * speed
     * pile+speed−1
     * ​
     *  ⌋。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/nZZqjQ/solution/fei-fei-chi-xiang-jiao-by-leetcode-solut-0jge/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
//        for (int i = 2; i <4 ; i++) {
//            int pile=i;
//            int speed=i;
//            int curTime = (pile + speed - 1) / speed;
//            System.out.println("curTime");
//            System.out.println(curTime);
//            int  pileChuSp= pile/speed;
//            System.out.println("pileChuSp");
//            System.out.println(pileChuSp);
//        }
//        3/2  3+1-1）/2
//        4/2  4+1-1）/2

        make();

        System.out.println(4/ 3);
        System.out.println((4 +3 -1 ) / 3);
//        pileChuSpe
//        4/ 3
//        pileChuSpeAdd
//        4 +3 -1 ) / 3

//        1
//        2
    }


 static    void  testPrint(){
        int pile=4;
        int speed=3;
        int curTime = (pile + speed - 1) / speed;
        int  pileChuSp= pile/speed;
        System.out.println("curTime");
        System.out.println(curTime);
        System.out.println("pileChuSp");
        System.out.println(pileChuSp);

     System.out.println();

    }
   static void make(){
      String templ=  "#pile#/ #speed#";
      String templAdd=  "#pile# +#speed# -1 ) / #speed#";
      int pile=4;
      int speed=3;

      String pileChuSpe=
      templ
              .replace("#pile#", String.valueOf(pile))
              .replace("#speed#", String.valueOf(speed))
              ;
        String pileChuSpeAdd=
                templAdd
                        .replace("#pile#", String.valueOf(pile))
                        .   replace("#speed#", String.valueOf(speed))
                ;

        System.out.println("pileChuSpe");
        System.out.println(pileChuSpe);


        System.out.println("pileChuSpeAdd");
        System.out.println(pileChuSpeAdd);
    }
}
