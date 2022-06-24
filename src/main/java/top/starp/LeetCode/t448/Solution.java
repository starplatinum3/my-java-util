package top.starp.LeetCode.t448;

import top.starp.util.LeetCodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            System.out.println("======");
            System.out.println("nums");
            System.out.println(Arrays.toString(nums));
            System.out.println("x");
            System.out.println(x);
            System.out.println("num");
            System.out.println(num);
            nums[x] += n;
//            他本身都是出现了 只要出现过一次 就会被增大
//            所以只有没有出现过的 才是正常范围
            System.out.println(" nums[x]");
//            因为1 是下标为0 的 所以要-1 嘛
            System.out.println( nums[x]);
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
//                在范围内
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
//        LeetCodeUtil.strToLinkedList()
//        solution.findDisappearedNumbers([4,3,2,7,8,2,3,1])
        solution.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}


//作者：LeetCode-Solution
//链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
