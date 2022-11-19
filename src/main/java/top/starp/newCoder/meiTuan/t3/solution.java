package top.starp.newCoder.meiTuan.t3;
import top.starp.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//https://blog.csdn.net/zy854816286/article/details/105157995
public class solution {
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		String str=s.next();
		s.close();
		int start=0;
		int i=1;
        List<Integer> lenLst=new ArrayList<>();
		while(i<=str.length()){
			String temp=str.substring(start,i);
            System.out.println("=========");
            System.out.println("temp");
            System.out.println(temp);
//            截取前面一部分
			int j=0;
			for(;j<temp.length();j++){
				if(str.indexOf(temp.charAt(j),i)>0){
//				    出现了
//                    去看看后面有没有
                    System.out.println("i "+i);
//                    Array.as
                    System.out.println("temp");
                    System.out.println(temp);

//                    ArrayUtil.printListHighLight(str,new int[]{i});
                    ArrayUtil.printListHighLight(str,Arrays.asList(i,j));
//                    ArrayUtil.pr
//                    ArrayUtil.printListHighLight(str,Arrays.asList(j));
                    System.out.println("temp.charAt(j) "+temp.charAt(j));
					break;
				}
			}
//			这里跳出 说明这一整个字符串 在后面都没有找到一样的 所以是可以的
//			到了这里 去判断现在找到的字符串 是不是没有重复的
			if(j==temp.length()){
//			    循环完了 才跳出的 说明没有找到一样的
				start=i;
//				新的开始
                lenLst.add(temp.length());
//				System.out.print(temp.length()+" ");
                ArrayUtil.printListCut(str,start,j);
			}
			i++;
		}
        System.out.println("lenLst");
        System.out.println(lenLst);
		return;
	}
}
