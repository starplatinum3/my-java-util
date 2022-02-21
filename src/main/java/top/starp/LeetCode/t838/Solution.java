package top.starp.LeetCode.t838;

import java.util.*;

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<Character>();
        }
        for (int i = 0; i < n; i++) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                queue.offer(i);
                time[i] = 0;
                force[i].add(f);
//                这里会有两个吗 应该是 会有0个 所以下面要判断
            }
        }

        char[] res = new char[n];
        Arrays.fill(res, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {
//                一个 就是有方向的  而不是 直立的
                char f = force[i].get(0);
                res[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;
//                往左边跑 或者往右边
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
//                        没有受力  现在被受力了
                        queue.offer(ni);
                        time[ni] = t + 1;
//                        推倒的时间
                        force[ni].add(f);
                    } else if (time[ni] == t + 1) {
//                        已经走到了？
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(res);
    }
}

//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/push-dominoes/solution/tui-duo-mi-nuo-by-leetcode-solution-dwgm/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
