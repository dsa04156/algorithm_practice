import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.function.BinaryOperator;



public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,M,ans;
	public static void main(String[] args) throws IOException {
		int x;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		int[] arr = new int[1000001];
		Arrays.fill(arr, Integer.MIN_VALUE);
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			x=Integer.parseInt(st.nextToken());
			arr[x]=0;
			dq.offerLast(x);
			}
		while(!dq.isEmpty()) {
			System.out.println(dq);
			x=dq.pollFirst();
			System.out.print(x+" ");
			for(int i=0;i<20;i++) {
				int nx=x^(1<<i);
				System.out.println(nx);
				if(nx>N||arr[nx]!=Integer.MIN_VALUE)	continue;
				arr[nx]=arr[x]+1;
				dq.offerLast(nx);
				ans = Math.max(ans, arr[nx]);
			}
		}
		System.out.println(ans);
	}
}
