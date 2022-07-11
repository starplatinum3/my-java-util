package top.starp.meituan;

//import org.graalvm.compiler.java.JsrScope;

import java.util.Scanner;

public class 小美买饮料 {
    static  int maxN=5*10000+7;
   static long []s=new long[maxN];
    static long sum(int l ,int r){
        return s[r]-s[l-1];
    }

   static void doOne( Scanner scanner){
        int cnt = scanner.nextInt();
        int [] drink=new int[cnt+1];
        long allSum=0;
//            for (int i = 0; i <cnt ; i++) {
        for (int i = 1; i <cnt+1 ; i++) {
            drink[i]=scanner.nextInt();
            s[i]=s[i-1]+drink[i];
            allSum+=drink[i];
        }
        for (int i = 1; i <cnt+1 ; i++) {
            for (int j = i; j <cnt+1 ; j++) {
                if(sum(i,j)>allSum){
                    System.out.println("Yes");
                   return;
                }
            }
        }
        System.out.println("No");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        String t = scanner.nextLine();
//        有负数才行
//        2
//        4
//        1 2 3 4
//        3
//        -5 5 -5
        int t = scanner.nextInt();
        while (t-->0){
            doOne(scanner);
//            int cnt = scanner.nextInt();
//            int [] drink=new int[cnt+1];
//            long allSum=0;
////            for (int i = 0; i <cnt ; i++) {
//            for (int i = 1; i <cnt+1 ; i++) {
//                drink[i]=scanner.nextInt();
//                s[i]=s[i-1]+drink[i];
//                allSum+=drink[i];
//            }
//            for (int i = 1; i <cnt+1 ; i++) {
//                for (int j = i; j <cnt+1 ; j++) {
//                    if(sum(i,j)>allSum){
//                        System.out.println("Yes");
//                        break;
//                    }
//                }
//            }

        }
    }
}
