//package top.starp.LeetCode.t838;
//
////import lombok.AllArgsConstructor;
////import lombok.Builder;
////import lombok.Data;
////import lombok.NoArgsConstructor;
//

////import top.starp.util.StrUtil;
//
////import top.starp.util.StrUtil;
//
//import java.util.*;
//
////@Data
////@Builder
////@NoArgsConstructor
////@AllArgsConstructor
//class Dirs{
//    public Dirs(List<Character> dirs) {
//        this.dirs = dirs;
//    }
//
//    public Dirs() {
//    }
//
//    //    他的方向
////    List<Character> dirs=new ArrayList<>();
//    List<Character> dirs;
//}
//
//public  class SolutionNoImport {
//
////    public static void main(String[] args) {
////        SolutionNoImport solution2=new SolutionNoImport();
////
//////        String s = solution2.pushDominoes("RR.L");
////        String s = solution2.pushDominoes(".L.R...LR..L..");
////        System.out.println("s");
////        System.out.println(s);
//////        solution2.pushDominoes("")
////    }
//
//
//    public String pushDominoes(String dominoes) {
//
//        boolean debugIt=false;
//        int [] pos=new int[dominoes.length()];
//
//
//        int [] time=new int[dominoes.length()];
////        多米诺 时间
//        char[] force=new char[dominoes.length()];
//
////        List<Character>list=new ArrayList<>();
//        List<Character>list=new LinkedList<>();
////        Deque<Character> deque=new ArrayDeque<>();
//        Deque<Integer> deque=new ArrayDeque<>();
////        知道了 现在的 方向 放的 方向 因为 旁边的 会把他方向推倒 所以方向会变
////        所以 offer 的时候就方向变了
////        List<List<Character>>dirs=new ArrayList<>();
////        List<Dirs>dirs1=new ArrayList<>();
//        Dirs[] dirs=new Dirs[dominoes.length()];
//        for (int i = 0; i < dominoes.length(); i++) {
//            time[i]=-1;
//            pos[i]=i;
//            force[i]=dominoes.charAt(i);
//          char  dir=  dominoes.charAt(i);
////            作用力
////            他是不知道他是第几个 的 queue 里面东西要变化的
//            deque.offer(i);
////            char c = dominoes.charAt(i);
////            int i=next[i];
////            int t=time[i];
////            int ni=c=='L' ?i-1:i+1;
////            现在的位置 下一个位置
////            if(c=='L'){
////                time[i+1]
////            }else{
////
////            }
////            list.of
////            list.off
////            一个可能有多个 方向吗啊 不是 是有一个 或者没有 方向
////            就是 某个 位置要放一个 list 放的 是他 的 方向
////            dirs.add()
////            这个位置的 他的 方向
//            Dirs dirs1 = new Dirs(new ArrayList<>());
//            dirs[i]=dirs1;
////            dirs[i]=Dirs.builder().dirs(new ArrayList<>()).build();
//            if(dir=='.'){
//                continue;
//            }
//
////            dirs[i]=new Dirs();
////            dirs[i].dirs=new ArrayList<>();
//            dirs[i].dirs.add(dir);
//        }
//
//        System.out.println("一开始所有的受力 force");
//        System.out.println(force);
//        while (!deque.isEmpty()){
////            Character poll = deque.poll();
//            Integer i = deque.poll();
////            他现在的 位置
//            //           这个位置 收到的作用力
//            char forceNow= force[i];
////            已经有的 受力
//            int t=time[i];
//            if (dirs[i].dirs.size()==1) {
//                System.out.println("============");
////                如果有方向
//                Character giveForce = dirs[i].dirs.get(0);
//                System.out.println("giveForce");
////                System.out.println(giveForce);
////                System.out.println("pos");
////                System.out.println(i);
////                ArrayUtil.printListHighLight(dominoes, Arrays.asList(i));
////                StrUtil.printStrHighLight(dominoes, Arrays.asList(i));
////                现在新来的 给出去的 力
////                给的力 一定是力的
//                int ni=giveForce=='L' ?i-1:i+1;
//                if(ni<0||ni>=dominoes.length()){
//                    continue;
//                }
//
//                if(time[ni]==-1){
//                    System.out.println("没有倒下 需要倒下");
//                    System.out.println("需要倒下的位置是 pos "+ni);
////                    StrUtil.printStrHighLight(dominoes, Arrays.asList(ni));
////                    说明没有到下
////                    就需要倒下
//                    //                可以走下一步
////                    但是万一 他自己受力是 R 然后受到一个 L
////                    会变成啥呢 他自己应该是 L 不变的
////                    if(forceNow=='.'){
//                    if(force[ni]=='.'){
////                        如果需要倒下的 收到的力 是没有的 原来没有
//                        System.out.println(" 他自己是正直的 那就是谁来推他 他就被推");
////                        他自己是正直的 那就是谁来推他 他就被推/**/
//                        force[ni]=giveForce;
////                但是万一 右边也是 受力呢
////                受力不一定到下
////                time[ni]
//                        time[ni]=t+1;
////                    是不是下一次
//                        deque.offer(ni);
////                    为什么要 offer进去
////                    下一次 拿到这个位置
//                        System.out.println("现在所有的受力");
//                        System.out.println(force);
//                    }
////                 如果他是 受到一个相反的 力的话  那就是僵持 住
////                    相同的力的话 就还是原来的 所以都不用变化
//                }else{
////                    他已经倒下了
////                    就不用到下了
////                    如果 收到了 左边的 ，但是现在有收到了 右边的
////                    就可以从倒下的变成不倒下的 是不是可以啊
////                    force[ni];
////                    现在收到的 力气是
////                    forceDir
//                    System.out.println(" 他已经倒下了 就可以从倒下的变成不倒下的 是不是可以啊");
//                    if(!giveForce.equals(forceNow)){
////                        说明 就是变成了 直立人
//                        System.out.println("  说明 就是变成了 直立人");
//                        force[ni]='.';
//                    }
////                    if(character.equals(forceDir)){
//////                        还是原来的额
////                    }else{
//////                        不一样的受力 如果 相反的话 就是变成不受力
//////                        if(character.)
//////                        已经倒下不可能不受力 所以 forceDir 不可能是.
//////                        所以讨论 cha
////
////                        if (character.equals('.')) {
//////                            现在给的是不给力
//////                            不能有这种情况
//////                            但是不给力的话 之前初始化 是不插入他的给的方向的吧
////                        }
//////                        只有一样和 不一样的区别
////
////                    }
//                }
//            }
//
//        }
////        最后的情况
////        就是 for
////        force
//
////        force.
//        String s = String.valueOf(force);
//        return s;
////        for (int i = 0; i < dominoes.length(); i++) {
////            char c = dominoes.charAt(i);
////            int i=next[i];
////            int t=time[i];
////            int ni=c=='L' ?i-1:i+1;
//////            现在的位置 下一个位置
//////            if(c=='L'){
//////                time[i+1]
//////            }else{
//////
//////            }
////        }
//    }
//}
//
////作者：LeetCode-Solution
////链接：https://leetcode-cn.com/problems/push-dominoes/solution/tui-duo-mi-nuo-by-leetcode-solution-dwgm/
////来源：力扣（LeetCode）
////著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
