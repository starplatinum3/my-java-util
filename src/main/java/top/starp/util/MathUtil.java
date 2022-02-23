package top.starp.util;

public class MathUtil {

    public  static  int max(int ... nums){
        int max=nums[0];
        //for (int i = 0; i < nums.length-1; i++) {
        for (int i = 1; i < nums.length; i++) {
            //max=  Math.max(nums[i],nums[i+1]);
            max=  Math.max(nums[i],max);
        }
        return max;
    }
}
