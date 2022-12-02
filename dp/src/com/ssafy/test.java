package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][3];
		min = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<3;i++) {
			dp(0,i,0);
		}
		System.out.println(min);
		
	}
	static void dp(int x,int y,int cost) {
		if(x==N) {
			min=Math.min(min, cost);
			return;
		}
		if(cost>min)return;
		if(y==0) {
			dp(x+1,1,cost+arr[x][y]);
			dp(x+1,2,cost+arr[x][y]);
		}
		if(y==1) {
			dp(x+1,0,cost+arr[x][y]);
			dp(x+1,2,cost+arr[x][y]);
		}
		if(y==2) {
			dp(x+1,0,cost+arr[x][y]);
			dp(x+1,1,cost+arr[x][y]);
		}
	}
}
