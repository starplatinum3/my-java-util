package top.starp.LeetCode.t141; /**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//ac
 import top.starp.util.ListNode;

 import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 
        Set<ListNode>set=new HashSet<>();
        for(ListNode node=head;node!=null;node=node.next){
            if(set.contains(node)){
                return true;
            }
            set.add(node);
        }
        return false;
        // head.next
    }
}