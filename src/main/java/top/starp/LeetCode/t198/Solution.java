package top.starp.LeetCode.t198;

import com.alibaba.fastjson.JSONObject;
import top.starp.util.ArrayUtil;
import top.starp.util.JsonUtil;

import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution=new Solution();
        //[1,2,3,1]
        //ArrayUtil.
        //int[] ints = JSONObject.parseObject("[1,2,3,1]", int[].class);
        //JSONObject jsonObject = JsonUtil.stringToJson("[1,2,3,1]");
        //jsonObject.
        //int[] ints1 = JsonUtil.strToObj("[1,2,3,1]", int[].class);
        int[] ints1 = JsonUtil.strToObj("[1,2,3,1]", int[].class);
        //List<int[]> ints = Arrays.asList(ints1);
        //Arrays.stream(ints1).map(o->{
        //    return o ;
        //}).collect()
        //错的
        solution.rob(ints1);
        //System.out.println("jsonObject");
        //System.out.println(jsonObject);
        //solution.rob();
    }
    int max(int ... nums){
        int max=nums[0];
        //for (int i = 0; i < nums.length-1; i++) {
        for (int i = 1; i < nums.length; i++) {
            //max=  Math.max(nums[i],nums[i+1]);
            max=  Math.max(nums[i],max);
        }
        return max;
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            dp[0]=nums[0];
            dp[1]=Math.max(nums[0],nums[1]);
            return dp[1];
            //return nums[0];
        }
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 1; i <nums.length ; i++) {
            if (i+1>=nums.length||i-1>=nums.length){
                break;
            }
            dp[i+1] =  max(dp[i-1] + nums[i]  ,dp[i-1]+nums[i+1], dp[i+1]);
            //dp[i+1] =Math.max ( dp[i-1] + nums[i]  ,dp[i-1]+nums[i+1], dp[i+1]);
        }
        int res=dp[nums.length-1];
        System.out.println("res");
        System.out.println(res);
        //System.out.println();
        return dp[nums.length-1];

    }
}