package top.starp.LeetCode.t147;

import top.starp.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    //https://www.cnblogs.com/xiaoming0601/p/5862793.html
    public static void InsertSort(int[] arr)
    {
        int i, j;
        int n = arr.length;
        int target;

        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 - n-1
        for (i = 1; i < n; i++)
        {
            j = i;
            //4(j 3（i 2 1
            //3 比 4 小 ，所以
            //4(j 4 (i 2 1
            //从i 开始 往前面找 找到比他小的
            //比他大的全部都往后放
            //3 4 2（i 1
            //3 4 (j 2（i 1
            //2 要找到 3 ，放在他的前面
            //找到第一个比2 大的
            target = arr[i];
            //3 4 (j 2（i 1
            //前面是确保排序正确的吗 好像是的啊

            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }

            arr[j] = target;
        }
    }

    void ins2(){
        //for (int i = 0; i <n ; i++) {
        //    //a[k]
        //    //找到比他大的
        //    //前面确实是小的呀
        //    //4(k 3（i 2 1
        //    if(a[k]<a[i]){
        //        //所有的往后移动
        //        for (int j = n-1; j >k ; j--) {
        //            a[j]=a[j-1];
        //        }
        //        a[k]=
        //    }
        //
        //
        //    for (int j = k; j <n ; j++) {
        //
        //    }
        //}
    }

    public ListNode insertionSortList(ListNode head) {

        ListNode dumm=new ListNode() ;

        dumm.next=head;
        //ListNode pre=dumm;
        for(ListNode node=head.next;node!=null;node=node.next){
            ListNode target=node;
            //node.
            //pre=pre.next;
            ListNode pre=dumm;
            while (pre.next.val<=target.val){
                pre=pre.next;
            }
            ListNode a=pre.next;
            //target.next=pre.next;
            //从后往前的next 设置
            a.next=target.next;
            target.next=a;
            pre.next=target;

            //swap
            //lastSorted.next = curr.next;
            //curr.next = prev.next;
            //prev.next = curr;

            //作者：LeetCode-Solution
            //链接：https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/
            //来源：力扣（LeetCode）
            //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
            //pre.next=
            //node.next=pre;
            while (target.val<pre.val){

            }

        }

        return  null;
    }
}