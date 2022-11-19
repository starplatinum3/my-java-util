package top.starp.newCoder.meiTuan.t2;

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);

		String p=sc.nextLine();
		String s=sc.next();

		if(ispattern(p,0,s,0))
			System.out.println(1);
		else
			System.out.println(0);
	}

	//   ?  return s+1,p+1
	//    *  return s+1,p  and s,p+1
	public static boolean ispattern(String p,int i,String s,int j){

//	    长度一样是到了最后吗
		if(s.length()==j){
//		    最后前面一个  模式是* 可以匹配所有
            return p.length()==i||(p.length()==i+1&&p.charAt(i)=='*');

        }

//		匹配玩了 但是s有没匹配完的？
		if(i==p.length())
			return false;

		if(p.charAt(i)=='?'||p.charAt(i)== s.charAt(j))
			return ispattern(p,i+1,s,j+1);
		if(p.charAt(i)=='*')
			return ispattern(p,i,s,j+1)||ispattern(p,i+1,s,j);
//		可以匹配一个 也可以不匹配

		return false;
	}
}

