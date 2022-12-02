package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static int b,w;
	public static void main(String[] args) throws NumberFormatException, IOException {
		String p = "()))((()";
		System.out.println(solution(p));
		
	}
	
    static String solution(String p) {
    	char[] arr = new char[p.length()];
    	for(int i=0;i<p.length();i++) {
    		arr[i]=p.charAt(i);
    	}
    	boolean v[]=new boolean[p.length()];
    	for(int i=0;i<arr.length-1;i++) {
    		if(arr[i]=='('&&arr[i+1]==')') {
    			v[i]=true;
    			v[i+1]=true;
    		}
    			
    	}
    	for(int i=0;i<arr.length;i++) {
    		if(v[i]) continue;
    		if(arr[i]=='(') {
    			for(int j=i+1;j<arr.length;j++) {
    				if(arr[j]==')'&&v[j]==false) {
    					v[j]=true;
    					v[i]=true;
    					break;
    				}
    			}
    		}
    	}
    	for(int i=0;i<arr.length;i++) {
    		if(v[i]==false) {
    			if(arr[i]=='(') {
    				arr[i]=')';
    			}
    			else if(arr[i]==')') {
    				arr[i]='(';
    			}
    		}
    	}
        String answer = "";
        for(int i=0;i<arr.length;i++) {
        	answer+=arr[i];
        }
        return answer;
    }
	
}
