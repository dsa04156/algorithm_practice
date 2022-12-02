package com.ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 칠공주 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] arr = new char[5][5];
	static boolean [] v= new boolean[25];
	static int res=0;
	static int max=0;
	static int[] dx= new int[] {1,0,-1,0};
	static int[] dy= new int[] {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		for(int i=0;i<5;i++) {
			String s= br.readLine();
			for(int j=0;j<5;j++) {
				arr[i][j]=s.charAt(j);
				}
			}
		dfs(0,0,0);
		System.out.println(res);
		
		}
	static void dfs(int index,int start,int y) {
		if(index==7) {
			if(bfs())
				res++;
			return;
		}
		for(int i=start;i<25;i++) {
			if(arr[i/5][i%5]=='Y'&&y+1<4) {
				v[i]=true;
				dfs(index+1,i+1,y+1);
				v[i]=false;
			}
			if(arr
					[i/5][i%5]=='S') {
				v[i]=true;
				dfs(index+1,i+1,y);
				v[i]=false;
			}
		}
		}

static class pair{
	int x,y;
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}

static boolean bfs() {
	Queue<pair> q = new LinkedList<>();
	boolean[][] check = new boolean[5][5];
	for(int i=0;i<25;i++) {
		if(v[i]) {
			check[i/5][i%5]=true;
			q.add(new pair(i/5,i%5));
			break;
		}
	}
	
	int count=1;
	while(!q.isEmpty()) {
		pair p = q.poll();
		for(int c=0;c<4;c++) {
			int nx= p.x +dx[c];
			int ny = p.y+dy[c];
			if(nx<0||nx>4||ny<0||ny>4) continue;
			if(!v[nx*5+ny]||check[nx][ny]) continue;
			check[nx][ny]=true;
			q.add(new pair(nx,ny));
			count++;
		}
	}
	if(count ==7)
		return true;
	else
		return false;
}


	
	
}
	


	


