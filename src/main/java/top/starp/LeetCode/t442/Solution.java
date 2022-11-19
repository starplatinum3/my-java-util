package top.starp.LeetCode.t442;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//class Solution {
//    public List<Integer> findDuplicates(int[] nums) {
//
//        int res=nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            res^=nums[i];
//        }
//        System.out.println(res);
////        return res;
//        return null;
//
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.findDuplicates(new int[]{2,4,5});
//    }
//}

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int shouldIdx=nums[i] - 1;
            while (nums[i] != nums[shouldIdx]) {
//                这个数字 要hash到列表的 他的下标去
//                swap(nums, i, nums[i] - 1);
                swap(nums, i, shouldIdx);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
//            这些数字
//            他不在他所在的下标
            int numMinus1MapNum=nums[i] - 1;
//            从0 开始的
            if (numMinus1MapNum != i) {
                System.out.println("=-=======");
                System.out.println("nums");
                System.out.println(Arrays.toString(nums));
                System.out.println("numMinus1MapNum");
                System.out.println(numMinus1MapNum);
                System.out.println("thisNum");
                System.out.println(i);
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.findDuplicates(new int[]{2,4,5});
        solution.findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

//作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/solution/shu-zu-zhong-zhong-fu-de-shu-ju-by-leetc-782l/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
