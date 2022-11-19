//package top.starp.LeetCode;
//
//public class 展平多级双向链表 {
//
//}
//
//
//class Solution {
//    public Node flatten(Node head) {
//        dfs(head);
//        return head;
//    }
//
//    public Node dfs(Node node) {
//        Node cur = node;
//        // 记录链表的最后一个节点
//        Node last = null;
//
//        while (cur != null) {
//            Node next = cur.next;
//            //  如果有子节点，那么首先处理子节点
//            if (cur.child != null) {
//                Node childLast = dfs(cur.child);
//
//                next = cur.next;
//                //  将 node 与 child 相连
//                cur.next = cur.child;
//                cur.child.prev = cur;
//
//                //  如果 next 不为空，就将 last 与 next 相连
//                if (next != null) {
//                    childLast.next = next;
//                    next.prev = childLast;
//                }
//
//                // 将 child 置为空
//                cur.child = null;
//                last = childLast;
//            } else {
//                last = cur;
//            }
//            cur = next;
//        }
//        return last;
//    }
//}
//
////作者：LeetCode-Solution
////        链接：https://leetcode.cn/problems/Qv1Da2/solution/zhan-ping-duo-ji-shuang-xiang-lian-biao-x5ugr/
////        来源：力扣（LeetCode）
////        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。