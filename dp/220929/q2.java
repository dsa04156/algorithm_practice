package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2 {
	static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[1]=2;
		arr[2]=5;
		arr[3]=12;
		for(int i=4;i<=n;i++) {
			arr[i]=(int) (arr[i-1]+Math.pow(2, i));
		}
		System.out.println(arr[n]);
		
	}

}
