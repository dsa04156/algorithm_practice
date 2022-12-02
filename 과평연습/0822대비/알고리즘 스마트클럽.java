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

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;



public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int cnt=0;
		int[] arr =new int[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int x3=Integer.parseInt(st.nextToken());
			if(x1+x2+x3>=S&&x1>=M&&x2>=M&&x3>=M) {
				cnt+=1;
				queue.add(x1);
				queue.add(x2);
				queue.add(x3);
	
			}
		}
		bw.write(cnt+"\n");
//		System.out.println(cnt);
		for(int i: queue) {
//			System.out.print(i+" ");
			bw.write(i+" ");
		}
		bw.flush();
		bw.close();
		
	}
		
	}
