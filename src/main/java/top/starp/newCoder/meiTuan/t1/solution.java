package top.starp.newCoder.meiTuan.t1;
import top.starp.util.ArrayUtil;

import java.util.Scanner;
import java.util.Stack;

//https://blog.csdn.net/zy854816286/article/details/105174896
public class solution{
//    void prin
//    ListU

    static  boolean contains(int [] arr,int val){
        for (int i : arr) {
            if(i==val){
                return true;
            }
        }
        return false;
    }
   static void printArrMark(String[] strings,int [] markIdxs){
        int idx=0;
        for (String string : strings) {
            if(contains(markIdxs,idx)){
                System.out.print(String.format("(%s) ",string ));
            }else{
                System.out.print(string+ " ");
            }
            idx++;
        }
       System.out.println();
    }
	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		scan.close();
		String[] str=s.split(" ");
		if(str[str.length-1].equals("and")||str[str.length-1].equals("or")||str[0].equals("and")||str[0].equals("or")){
			System.out.println("error");
			return;
		}
		if(str.length%2==0){
			System.out.println("error");
			return;
		}
		Stack<String> stack=new Stack<String>();
		for(int i=str.length-1;i>=0;i--){
			if(i%2==0&&(str[i].equals("and")||str[i].equals("or"))){
				System.out.println("error");
				return;
			}
			else if(i%2==1&&(str[i].equals("true")||str[i].equals("false"))){
				System.out.println("error");
				return;
			}
			else{
                System.out.println("=========");
				String temp=str[i];
                printArrMark(str,new int[]{i});
//                ArrayUtil.
				if(temp.equals("and")){
//				    之前的 是从尾部开始的
					temp=stack.pop();
//					只有都是false 才会是false
					if(temp.equals("false")||str[i-1].equals("false")){
						temp="false";
//						这是什么判断
//                        str[i-1] 是栈里的东西吗 但是栈是会push的 所以不是
					}
					else{
						temp="true";
					}
//					打印栈 java
//                    处理完后面的 false and false 就会变成 false


                    System.out.println("stack 一开始");
                    System.out.println(stack);
					stack.push(temp);
                    System.out.println("stack 放入了");
                    System.out.println(stack);
					i--;
//					-- 是干嘛
				}
				else{
					stack.push(temp);
				}
			}
            System.out.println(stack);
		}
//		or 没有处理 只要有一个true 就是true
		while(!stack.isEmpty()){
			if(stack.pop().equals("true")){
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
		return;
	}
}
