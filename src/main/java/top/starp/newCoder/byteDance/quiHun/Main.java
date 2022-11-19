package top.starp.newCoder.byteDance.quiHun;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author guizimo
 * @date 2020/7/18 12:44 下午
 */
//https://zhuanlan.zhihu.com/p/161470552
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] state = new int[9], temp = new int[9];
        ArrayList<Integer> res = new ArrayList<>();
        //获取13个数字，统计每个数字出现的次数
        for (int i = 0; i < 13; i++) {
            int num = scanner.nextInt();
            state[num - 1]++;
//            0 开始
        }
        //依次添加数字进行测试
        for (int i = 0; i < 9; i++) {
            if (state[i] < 4) {
                int num = i + 1;
                System.arraycopy(state, 0, temp, 0, 9);
                temp[i]++;
                //判断是否符合规则，若符合记录当前的数字
                if (run(temp, 14, false)) {
                    res.add(num);
                }
            }
        }
        if (res.isEmpty()) { //如果为空
            System.out.println(0);
        } else { //不为空
            StringBuffer sbf = new StringBuffer();
            sbf.append(res.get(0));
            for (int i = 1; i < res.size(); i++) {
                sbf.append(" ");
                sbf.append(res.get(i));
            }
            System.out.println(sbf.toString());
        }

    }

    public static boolean run(int[] temp, int count, boolean hasRun) {
        if (count == 0) {
            return true;
        }
        if (!hasRun) {
            for (int i = 0; i < 9; i++) {
                //遍历个数大于2的数字，让它作为雀头，判断后面的规则是否通过
                if (temp[i] >= 2) {
                    temp[i] -= 2;
                    //递归
                    if (run(temp, count - 2, true)) {
                        return true;
                    }
                    temp[i] += 2;
                }
            }
            return false;
        } else {
            for (int i = 0; i < 9; i++) {
                if (temp[i] > 0) {
                    //判断刻子
                    if (temp[i] >= 3) {
                        temp[i] -= 3;
                        if (run(temp, count - 3, true)) {
                            return true;
                        }
                        temp[i] += 3;
                    }
                    //判断顺子
                    if (i + 2 < 9 && temp[i + 1] > 0 && temp[i + 2] > 0) {
                        temp[i]--;
                        temp[i+1]--;
                        temp[i+2]--;
                        if(run(temp,count-3,true)){
                            return true;
                        }
                        temp[i]++;
                        temp[i+1]++;
                        temp[i+2]++;
                    }
                }
            }
        }
        return false;
    }
}
