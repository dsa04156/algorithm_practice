package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo2_1_구미_4반_정진욱 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V,P;//V 마을수, P 경찰서 수
	static boolean[] v;//방문 배열
	static int res; //조합할 수 있는 모든 경우의 수
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			st=new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());//마을 수 입력
			P = Integer.parseInt(st.nextToken());//경찰서 수 입력
			v=new boolean[V];
			res=0;//조합의 수
			dfs(0,0);//조합구하기
			
			System.out.println("#"+tc+" "+res);
		}
	}
	static void dfs(int idx,int cnt) {//조합
		if(cnt==P) {//경찰서의 개수만큼 골랐으면
			res++;
			return;
		}
		if(idx==V) return;//마을을 끝까지 탐색했으면 리턴
		
		v[idx]=true;//고르기
		dfs(idx+1,cnt+1);//다시 고르기
		v[idx]=false;//다른 조합을 찾기 위해 고른 것 취소
		dfs(idx+1,cnt);//다시 고르기
	}

}
