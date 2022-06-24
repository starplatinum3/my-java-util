package top.starp.meituan;

import java.util.Map;
import java.util.Scanner;

public class 小美的01串 {
    static int sumOfStr(String string){
        int sum=0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            sum+=c-'0';
        }
        return sum;
    }
    static int minus(String a, String b) {
//        if("00".equals(a)&&"00".equals(b)){
//            return 0;
//        }
//        if("11".equals(a)&&"11".equals(b)){
//            return 0;
//        }
//        if("10".equals(a)&&"10".equals(b)){
//            return 0;
//        }
        return Math.abs(sumOfStr(a)-sumOfStr(b));
//        int sum
//        for (int i = 0; i < a.length(); i++) {
//
//        }
//        if (a.equals(b)) {
//            return 0;
//        }
////        &&"01".equals(b)
//        if ("00".equals(a)) {
//            if ("01".equals(b)) {
//                return 1;
//            }
//            if ("10".equals(b)) {
//                return 1;
//            }
//            if ("11".equals(b)) {
//                return 2;
//            }
////            return 0;
//        }
//
//        if ("00".equals(b)) {
//            if ("01".equals(a)) {
//                return 1;
//            }
//            if ("10".equals(a)) {
//                return 1;
//            }
//            if ("11".equals(a)) {
//                return 2;
//            }
////            return 0;
//        }
//        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
//        System.out.println("s");
//        System.out.println(s);
//        System.out.println("t");
//        System.out.println(t);
//  01 10 00 11
        int sum = 0;
//        int end=1;
        int end= s.length()-1;

//        int end=2;
        for (int i = 0; i < s.length() - end; i++) {
//            String substring = s.substring(i, i + 1);
//            String substring = s.substring(i, i + 2);
            String substring = s.substring(i, i + end+1);
            for (int j = 0; j < t.length() - end; j++) {
//                01
//                00111
//                String sub2 = s.substring(j, j + 1);
//                String sub2 = t.substring(j, j + 2);
                String sub2 = t.substring(j, j + end+1);
//                if("00".equals(substring))

//                System.out.println("========");
//////                System.out.println("j");
//////                System.out.println(j);
//                System.out.println("sub2");
//                System.out.println(sub2);
//                System.out.println("substring");
//                System.out.println(substring);
                int minuss= minus(sub2, substring);
//                sum += minus(sub2, substring);
//                System.out.println("minuss");
//                System.out.println(minuss);
                sum += minuss;
//                输出一个整数，表示汉明距离的和。
            }
        }
        System.out.println(sum);
    }
}
