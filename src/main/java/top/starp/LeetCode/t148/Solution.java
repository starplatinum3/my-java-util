package top.starp.LeetCode.t148;


import com.alibaba.fastjson.JSON;
import top.starp.util.LeetCodeUtil;

import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
//ac
//https://leetcode-cn.com/problems/sort-list/
class Solution {
     public  static  ListNode arrToLinkedList( Integer[] arr){
        ListNode newHead=new ListNode();
        newHead.val=arr[0];
        //ListNode newHead=strings[0];
        ListNode newHeadOut=newHead;
        //newHead=list.get(0);
        //newHead.next=list.get(1);
        //for (ListNode node : list) {
        //    newHead.next=
        //}
        for (int i = 1; i < arr.length; i++) {
            newHead.next=new ListNode();

            newHead.next.val=arr[i];
            newHead= newHead.next;
        }
        newHead.next=null;
        return  newHeadOut;
    }
    ListNode strToLinkedList(String string){
        //String str1="[4,2,1,3]";
//        JSO
        Integer[]strings = JSON.parseObject(string, Integer[].class);
        ListNode newHead=new ListNode();
        newHead.val=strings[0];
        //ListNode newHead=strings[0];
        ListNode newHeadOut=newHead;
        //newHead=list.get(0);
        //newHead.next=list.get(1);
        //for (ListNode node : list) {
        //    newHead.next=
        //}
        for (int i = 1; i < strings.length; i++) {
            newHead.next=new ListNode();

            newHead.next.val=strings[i];
            newHead= newHead.next;
        }
        newHead.next=null;
        return  newHeadOut;
    }
    public static void main(String[] args) {
        String str1="[4,2,1,3]";
//        JSO

        Integer[]strings = JSON.parseObject(str1, Integer[].class);
        ListNode newHead=new ListNode();

        //top.starp.util.ListNode listNode = LeetCodeUtil.arrToLinkedList(strings);

        newHead.val=strings[0];
        //ListNode newHead=strings[0];
        ListNode newHeadOut=newHead;
        //newHead=list.get(0);
        //newHead.next=list.get(1);
        //for (ListNode node : list) {
        //    newHead.next=
        //}
        for (int i = 1; i < strings.length; i++) {
            newHead.next=new ListNode();

            newHead.next.val=strings[i];
            newHead= newHead.next;
        }
        newHead.next=null;
        Solution solution=new Solution();
        ListNode nodeHead = solution.sortList(newHeadOut);

        for (ListNode node=nodeHead;node!=null;node=node.next){
            //list.add(node.val);
            //list.add(node);
            System.out.print(node.val+" ");
        }
    }
    public ListNode sortList(ListNode head) {
        //head.next;
        //List<Integer> list=new ArrayList<>();
        if(head==null){
            return null;
        }

        List<ListNode> list=new ArrayList<>();

        for (ListNode node=head;node!=null;node=node.next){
            //list.add(node.val);
            list.add(node);
        }
        list.sort((o1,o2)->{
            return o1.val-o2.val;
        });
        //ListNode newHead=new ListNode();
        ListNode newHead=list.get(0);
        ListNode newHeadOut=newHead;
        //newHead=list.get(0);
        //newHead.next=list.get(1);
        //for (ListNode node : list) {
        //    newHead.next=
        //}
        for (int i = 1; i < list.size(); i++) {
            newHead.next=list.get(i);
            //newHead=list.get(i);
            newHead= newHead.next;
        }
        newHead.next=null;
        //return newHead;
        return newHeadOut;
    }
}