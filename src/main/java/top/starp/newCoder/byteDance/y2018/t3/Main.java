package top.starp.newCoder.byteDance.y2018.t3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <a href=https://interview.nowcoder.com/questionTerminal/43068a1013b4417a85c2c2ce8b18159e>牛客描述</a>
 * 思路：分配后的房间里，人数最少的那一个房间就是i号房间。如果有多个房间人数最少，则取x号房间往前数的第一个人最少的房间。综上：无论哪种情况，从x房间往前数找到的第一个人最少的房间就是i号房间。
 * 找出i号房间后，就很容易求出之前的人数了。首先根据i号房间最后的人数确定完整的轮数，然后从x号往前再减去最后不足一轮的部分，然后把多出的人数全部补到第i个房间，就结束了
 *
 * @author LBW
 */
//1 2  3 4 5 6 7
//    一定是最少的吗  因为被分配到别的地方了 但是是0 吗
//    万一他被分配到2次 别人一开始是1 但是只是被分配到1次呢
public class Main {

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
//        最后一个房间号 但是从0 开始 所以-1
        long[] room = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            room[i] = scanner.nextInt();
            if (room[i] < min)
                min = room[i];
//            最小的房间
        }
//        分配之后的总人数
        //get min_index
        int minIndex = x;
        while (room[minIndex] != min) {
//            n-1 循环到最后了
            minIndex = minIndex > 0 ? minIndex - 1 : n - 1;
        }
        // remove the round number.
        for (int i = 0; i < n; i++) {
            room[i] -= min;
        }
        // remove the tail
        int remain = 0;
        for (int i = x; i != minIndex; i = i > 0 ? i - 1 : n - 1) {
            room[i] -= 1;
            remain += 1;
        }
        room[minIndex] += remain + n * min;
        //print the result
        for (int i = 0; i < n; i++) {
            System.out.print(room[i] + " ");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.putPeople();
    }

    void printPeople(int[] room, int outIdx) {
        for (int i = 0; i < room.length; i++) {
            if (i == outIdx) {
                System.out.print("("+room[i]+") ");
            } else {
                System.out.print(room[i] + " ");
            }
        }
        System.out.println();
//        for (int ro : room) {
//            if()
//        }
    }


    void putPeople() {
        int roomCnt = 33;
        int[] room = new int[roomCnt];
        for (int i = 0; i < room.length; i++) {
            room[i] = i;
        }
//        for (int ro : room) {
//
//        }
        int outIdx = 4;
        int outPerCnt = room[4];
        room[outIdx] = 0;
        int idx = outIdx + 1;
        while (outPerCnt-- > 0) {
            room[idx]++;
            idx++;
            if (idx >= roomCnt) {
                idx = 0;
            }
        }
//        0 1 2 3 (0) 6 7 8 9 9 10 11 12 13 14 15 16 17 18 19
//        因为一开始房间里总是有人的 不过也可以是0
        printPeople(room,outIdx);
//        System.out.println("room");
//        System.out.println(Arrays.toString(room));
    }
}
