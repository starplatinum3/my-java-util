package top.starp.newCoder.netEase.t1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 匈牙利算法
 * 求二分图的最大匹配
 * https://www.nowcoder.com/questionTerminal/c497247437534a75b6bb795a0f0fa663?f=discussion
 */
public class Main {
    // 存放A员工匹配的B员工id
    static int[] bMatchAId;
    // B员工是否已匹配
    static boolean[] used;
    // A、B员工共同参与的项目，连线为1，不连线为0
    static int[][] map;

    public static int solve(int[] companyA, int[] companyB) {
        Arrays.fill(bMatchAId, -1);
        int res = 0;
        for (int aPerson : companyA) {
            Arrays.fill(used, false);
            if (find(companyB, aPerson)) {
                res++;
            }
        }
        return res;
    }

    public static boolean find(int[] companyB, int aPerson) {
        for (int bPerson : companyB) {
            if (map[aPerson][bPerson] == 1 && !used[bPerson]) {
                used[bPerson] = true;
                if (bMatchAId[bPerson] == -1 || find(companyB, bMatchAId[bPerson])) {
                    bMatchAId[bPerson] = aPerson;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String A = s.nextLine();
        String B = s.nextLine();
        String[] sa = A.split(" ");
        String[] sb = B.split(" ");
        int[] companyA = new int[sa.length];
        int[] companyB = new int[sb.length];
        int a = 0, b = 0;
        int maxa = 0, maxb = 0;
        for (String str : sa){
            int c = Integer.parseInt(str);
            companyA[a++] = c;
            maxa = Math.max(maxa, c);
        }

        for (String str : sb){
            int c = Integer.parseInt(str);
            companyB[b++] = c;
            maxb = Math.max(maxb, c);
        }
        bMatchAId = new int[maxb+1];
        used = new boolean[maxb+1];
        map  = new int[maxa+1][maxb+1];

        int n = s.nextInt();
        while (n-- > 0) {
            int fir = s.nextInt();
            int sec = s.nextInt();
            map[fir][sec] = 1;
        }
        System.out.println(solve(companyA, companyB));
        s.close();
    }
}
