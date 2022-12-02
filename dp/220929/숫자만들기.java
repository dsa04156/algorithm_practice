package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[] cal = new char[] {'+','-','*','/'};
	static int[] calNum = new int[4];
	static int[] number;
	static char[] sam;
	static boolean[] v;
	static int N;
	static long max;
	static long min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				calNum[i]=Integer.parseInt(st.nextToken());
			}
			number = new int[N];
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				number[i]=Integer.parseInt(st.nextToken());
			}
			v=new boolean[N-1];
			max= Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			dfs(number[0],0);
			System.out.println("#"+t+" "+(max-min));
		}
	}
	
	static void dfs(int num,int cnt) {
		if(cnt ==N-1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}
		
		if(calNum[0]>0) {
			calNum[0]--;
			dfs(num+number[cnt+1],cnt+1);
			calNum[0]++;
		}
		if(calNum[1]>0) {
			calNum[1]--;
			dfs(num-number[cnt+1],cnt+1);
			calNum[1]++;
		}
		if(calNum[2]>0) {
			calNum[2]--;
			dfs(num*number[cnt+1],cnt+1);
			calNum[2]++;
		}
		if(calNum[3]>0) {
			calNum[3]--;
			dfs(num/number[cnt+1],cnt+1);
			calNum[3]++;
		}
		
	}

}
