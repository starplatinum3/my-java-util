package top.starp.newCoder.meiTuan.t4;

import java.util.*;

//https://blog.csdn.net/Napom/article/details/105543088
public class Main {
	static Scanner sc = new Scanner(System.in);
	static int N = 1005;
	static String word[] = new String[N];
	static int deg[] = new int[30];
	static boolean mp[][] = new boolean[30][30];
	static boolean vis[] = new boolean[30];
	static int cnt = 0;
	static int sum = 0;

	public static void main(String[] args) {
		String str;
		str = sc.nextLine();
		init();
		get_word(str);
		get_deg();
		tuopu();
	}

	static void init() {
		for(int i = 0; i < N; i++) {
			word[i] = ""; // 初始值是null
		}
	}

	static void get_word(String str) { // 把每个单词取出来
		char c;
		int num;
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if(c != ' ') {
				word[cnt] += c;
				num = (int)(c - 'a');
				if(vis[num] == false) {
					vis[num] = true;
					sum++; // 统计出现了多少种字符
				}
			} else {
				cnt++;
			}
		}
        System.out.println("word");
        System.out.println(Arrays.toString(word));
	}

	static void get_deg() {
		int a, b;
		for(int i = 0; i < cnt; i++) {
//		    单词的个数
			for(int j = 0; j < word[i].length(); j++) {
//			    每个单词的每个字符
				if(word[i + 1].length() - 1 >= j) {
//				    后面的长
//				    之后单词的最后一个
					a = (int)(word[i].charAt(j) - 'a');
					b = (int)(word[i + 1].charAt(j) - 'a');
//					两个单词的同一个位置
                    System.out.println("word[i]");
                    System.out.println(word[i]);
                    System.out.println("word[i + 1]");
                    System.out.println(word[i + 1]);
					if(a != b) {
						if(mp[a][b] == false) { // 确保不会重复
							mp[a][b] = true;
							deg[b]++;
//							进入他 的
						}
						break;
					}
				}
			}
		}
	}

	static void tuopu() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add((int)(word[0].charAt(0) - 'a'));
		int count = 0, tmp;
		String ans = "";
		while(queue.isEmpty() == false) {
			tmp = queue.peek();
			queue.remove();
			ans += (char)(tmp + 'a');
			count++;
//			现在数的有多少种字符
//			为什么30
			for(int i = 0; i < 30; i++) {
				if(mp[tmp][i]) {
					deg[i]--;
					if(deg[i] == 0) {
						queue.add(i);
					}
				}
			}
		}
//		sum 不同种类的字符
		if(count != sum) {
			System.out.println("invalid");
		} else {
			System.out.println(ans);
		}
	}
}
