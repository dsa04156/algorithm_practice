package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		
		int [] arr = new int [n+1];
		arr[1]=2;
		arr[2]=3;
		
		for(int i=3;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		System.out.println(arr[n]);
		
	}
}
