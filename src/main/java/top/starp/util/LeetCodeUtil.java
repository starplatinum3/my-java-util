package top.starp.util;

//import top.starp.LeetCode.t148.ListNode;

import com.alibaba.fastjson.JSON;

public class LeetCodeUtil {
    public  static ListNode arrToLinkedList(Integer[] arr){
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

    public static  void  printList(ListNode startNode){
        for(ListNode n=startNode;n!=null;n=n.next){
            System.out.print(n.val+" ");
        }
        System.out.println();
    }
   public static ListNode strToLinkedList(String string){
        //String str1="[4,2,1,3]";
//        JSO
        Integer[]strings = JSON.parseObject(string, Integer[].class);
      return   arrToLinkedList(strings);

    }
}
