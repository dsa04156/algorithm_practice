import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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



public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int X=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			int[] arr= new int [N+1];
			arr[X]=1;
			for(int j=0;j<K;j++) {
				st=new StringTokenizer(br.readLine());
				int A =Integer.parseInt(st.nextToken());
				int B =Integer.parseInt(st.nextToken());
				if(A==X)
					X=B;
				else if(B==X)
					X=A;
			}
			System.out.println(X);
		
			
		}
		
	}
		
	}
