package top.starp.LeetCode.t338;

import top.starp.util.LeetCodeUtil;

class Solution {
    public int[] countBits(int n) {

        return new int[]{1};
    }

    public static void main(String[] args) {
        int x=0x31231;
        int y=0x1000;
        int z=x-y;
        System.out.println("x");
        System.out.println(x);
        System.out.println("y");
        System.out.println(y);
        System.out.println("z");
        System.out.println(z);
        System.out.println("bin x");
//        110001001000110001
//        10000.。。00000
//        z=x-y 就是把最高位的剪掉了 就是少了一个最高位的1
//        y~\&~(y-1)=0y & (y−1)=0
//        y & (y−1)=0
//        100000&0111111 ==0
        LeetCodeUtil.printBinary(x);
    }
}
