package top.starp.LeetCode.t174;

import top.starp.util.LeetCodeUtil;
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

    int []a;
    void findLittle(int idx){

    }
    void test(){

        //int k=1;
        int idx=0;
        //1 2

        //4 3 2 1
        //找到比他小的 放到前面
        //放了之后 idx++
        //3 4(idx 2 1
        //for(i=idx;;i++)
        //for (int i = 0; i < n; i++) {
        //    int val=a[i];
        //    //for (int j = 0; j < ; j++) {
        //    //
        //    //}
        //    //if(a[i]<a[idx]){
        //    //
        //    //}
        //    int j=i;
        //    for (; j >i&&a[j]>val; j--) {
        //        a[j]=a[j-1];
        //    }
        //    a[j]=val;
        //}
    }
    void insBack(ListNode src,ListNode ins){

        ListNode next=src.next;

        String format = String.format("ins back  src %d ins %d next %d", src.val, ins.val,next.val);
        System.out.println(format);
        //System.out.println("ins back %d %d".format(src.val,ins.val));


        //ins.next=next;
        ins.next=next.next;
        src.next=ins;
        //src
        //String formatAfter = String.format("ins back after fr %d  back %d", src.val, ins.val);
        String formatAfter = String.format("ins back after fr %d  back %d next ", src.val, ins.val,next.val);
        System.out.println(formatAfter);

    }

    public static void main(String[] args) {
        ListNode node = LeetCodeUtil.strToLinkedList("[4,2,1,3]");
        Solution solution=new Solution() ;
        ListNode node1 = solution.insertionSortList(node);
        //for(ListNode n=node1;n!=null;n=n.next){
        //    System.out.println(n.val);
        //}
        System.out.println("node1");
        LeetCodeUtil.printList(node1);
    }
    public ListNode insertionSortList(ListNode head) {

        ListNode dummyHead=new ListNode();
        dummyHead.next=head;
        //2 (srot 4 1(wan 3
        //soeted 的next不要变 sorted 的后面还有可能有东西啊
        //wantSort =1
        //waSopre=4
        // (sopre 2(soted 4 (waspre) 1(wanSor 3
        //wantSortPre.ne=wasor.ne
        //sotedPre.ne=wanSo
        //wanSo.ne=sopted
        //for(ListNode wantSort=head;wantSort!=null;wantSort=wantSort.next){
        //for(ListNode wantSort=head.next;wantSort!=null;wantSort=wantSort.next){
        for(ListNode wantSortPre=head;wantSortPre!=null;wantSortPre=wantSortPre.next){
            System.out.println("======");
            ListNode wantSort=wantSortPre.next;
            System.out.println(String.format("want sort %d",wantSort.val));
            //LeetCodeUtil.printList(wantSort);
            System.out.println("wantSort");
            LeetCodeUtil.printList(wantSort);
            System.out.println("all");
            LeetCodeUtil.printList(dummyHead.next);
            //ListNode sorted=dummyHead.next;
            ListNode sortedPre=dummyHead;
            //ListNode sorted=dummyHead;
            //System.out.println();
            //LeetCodeUtil.printList(dummyHead.next);
            //&&sorted.next!=wantSort
            //for(;sorted.next!=null
            //        ;sorted=sorted.next){
            //    for(;sorted.next!=null
                for(;sortedPre.next!=null
                        ;sortedPre=sortedPre.next){
                //if(sorted.next.val>wantSort.val){
                    ListNode sorted=sortedPre.next;
                if(sorted.val>wantSort.val){
                //if(sorted.val>wantSort.val){
                    //System.out.println(String.format("change val %d %d ", sorted.next.val,wantSort.val));
                    System.out.println(String.format("change val %d %d ", sorted.val,wantSort.val));
                    //前面找到比这个大了
                    //就是这个位置
                    //sorted.next=wantSort;
                    //wantSort.next=sorted.next;
                    //insBack(sorted,wantSort);
                    //insBack(sorted.next,wantSort);
                    //4(sorted 3(want 2 1
                    //insBack(sorted,wantSort);
                    //insBack(wantSort,sorted);
                    //4 sot 2 wa 1 wa.ne
                    //sorted.pre.next=wantSort

                    //ListNode next=wantSort.next;
                    //sortedPre.next=wantSort;
                    //
                    //sorted.next=next;
                    ////wantSort.next=sorted.next;
                    //wantSort.next=sorted;

                    //sorted.next=want
                    //want.next=sorted.next


                    // (sopre 2(soted 4 (waspre) 1(wanSor 3
                    //wantSortPre.ne=wasor.ne
                    //sotedPre.ne=wanSo
                    //wanSo.ne=sopted
                    wantSortPre.next=wantSort.next;
                    sortedPre.next=wantSort;
                    wantSort.next=sorted;
                    break;
                }
            }
        }
        return dummyHead.next;
    }
}