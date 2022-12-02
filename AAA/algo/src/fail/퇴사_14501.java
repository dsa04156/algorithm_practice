package fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] t;
	static int[] p;
	static int N,max=0;;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		t= new int[N+1];
		p = new int[N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			t[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1,0);
		
		System.out.println(max);
		
		
	}
	static void dfs(int day, int money) {
		if(day>N) {
			max = Math.max(money,max);
			return;
		}
		if(day+t[day]<=N+1)
			dfs(day+t[day],money+p[day]);
		else
			dfs(day+t[day],money);
		
		dfs(day+1,money);
	}
}
