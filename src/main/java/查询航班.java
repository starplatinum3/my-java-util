////import com.sun.org.apache.bcel.internal.generic.DADD;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class 查询航班 {
//    public static void main(String[] args) {
//        查询航班 查询航班=new 查询航班();
//        查询航班. 根据旅行游玩持续时间和出发时间计算出回来的时间(旅行游玩持续时间,出发时间);
//        航班查询Req 航班查询Req = new 航班查询Req();
//        航班查询Req.set航班出发时间;
//        航班查询Req.set航班达到时间;
//        航班查询Req.set身份证号码;
////        为什么要省份证 号码呢，感觉不需要吧 但是跟账单有关吧 但是查询机票也需要吗
////                也许什么年龄的不能坐吗？ 那为什么不提供年龄呢
//        航班查询Req.set头等舱还是;
//        航班查询Req.set航班出发的机场;
//        航班查询Req.set航班到达的机场;
//        航班查询Req.set价格上限;
//        航班查询Req.set价格下限;
//
//       List<航班>list航班= 查询航班(航班查询Req);
//
////       发现这样写 代码 挺麻烦的 太细了。
////        是不是 画出流程图没有那么麻烦呢 但是需要输入输出 确实也是要的 呀 感觉也是这样一样麻烦吧
////        但是也许不用定义数据结构吧 但是感觉要的  这样程序不是更加清楚吗
////        但是这样好像把程序员的活都干掉了 但是既然前期可以干掉程序员的活 那不也是好的吗
////        如果流程图要很清楚 那和图形化编程也差不多 所以 就可以直接干程序员的活了
////        所以感觉就直接 可视化编程吧
////                但是 怎么知道一个回来的时间呢，回来的时间应该是他自己定好的吧 不是算出来的
//    }
//
//    void 查询航班(航班查询Req 航班查询Req){
////        航班查询Req
//       if( 航班查询Req.get航班出发时间<=new Date()){
//           String notifi="航班出发时间比现在还早，穿越吗？不可能！";
//           System.out.println("航班出发时间比现在还早，穿越吗？不可能！");
////           但是如果他是买来收藏呢，这个系统可以买之前的票吗，感觉一般也不可以买吧
//           弹窗提示(notifi);
//           return;
//       }
//        if( 航班查询Req.get航班达到时间<=new Date()){
//            String notifi="航班达到时间比现在还早，穿越吗？不可能！";
//            System.out.println(notifi);
//            弹窗提示(notifi);
//            return;
//        }
////        这个 表里没有表示
////        是经济舱的没有价格就是 说没有吗，比如说 设置 -1 就是没有 可以这样试试吧
////        那就不需要判断了
////        前端需要限制 舱型是 在一部分舱型里选的 这个写在内存里就好了 不用去数据库查吧
////        虽然数据库 可以动态的调整 但是每次都要查 就浪费时间啊
////        但是可以弄个static 每过一段时间 就搜到这个list 里，bus
////        根据 座位 的个数 来看他是不是还有
//
////        if( ! 仓型号列表.contains(航班查询Req.get舱型)){
////            System.out.println("没有这种舱型");
////            弹窗提示("没有这种舱型");
////            return;
////        }
////
//////        选择机场其实也是个麻烦的过程吧
////        if( ! 机场list.contains(航班查询Req.get出发的机场)){
////            String notifi="没有这个机场";
////            弹窗提示(notifi);
////            return;
////        }
////        if( ! 机场list.contains(航班查询Req.get到达的机场)){
////            String notifi="没有这个机场";
////            弹窗提示(notifi);
////            return;
////        }
////        机场list.co
//
//        if( 航班查询Req.get价格上限<0){
//            String notifi="不仅想白嫖，还想返利是吧（流汗黄豆 ";
//            弹窗提示(notifi);
//            return;
//        }
//
//        if( 航班查询Req.get价格下限<0){
//            String notifi="不仅想白嫖，还想返利是吧（流汗黄豆 ";
//            弹窗提示(notifi);
//            return;
//        }
//
//        if( 航班查询Req.get价格下限>航班查询Req.get价格上限){
//            String notifi="下限大于上限 可不敢乱搜 ";
//            弹窗提示(notifi);
//            return;
//        }
////        价格是根据航班的座位类型 距离之类算出来的
////        也不用算吧 数据库里就记上了的 因为每个航班都不一样嘛
////        而且 也不能根据距离来算的，
////        表里记录了 价格了，所以有座位类型的话 就可以查到
////        如果没有提供座位类型的话 就把这个价位的所有类型都可以查出来
////        价格上下限就是 大于小于的 sql 时间也是 > <  这种 其他是=
//    }
//
////    void 弹窗提示(String  notifi){
////        System.out.println(notifi);
////        弹窗提示(notifi);
////    }
//    List<String > 仓型号列表=new ArrayList<>();
//    List<String > 机场list=new ArrayList<>();
////    List<String > 仓型号列表=new ArrayList<>();
//    void 根据旅行游玩持续时间和出发时间计算出回来的时间(旅行游玩持续时间,出发时间){
//
//    }
//}
