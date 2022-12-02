package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SkillCheck2_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Solutio s = new Solutio();
		int n = 5;
		String words[] = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		System.out.println(Arrays.toString(s.solution(n,words)));
	    }
}

class Solutio {
    public int[] solution(int n, String[] words) {
    	int cnt=1;
    	int k=1;
    	int[] answer= {cnt,k};
    	ArrayList<String> list = new ArrayList<>();
    	loop:
    		for(int i=1;i<words.length;i++) {
	    			cnt+=1;
	    			if(cnt==n+1) {
	    				cnt=1;
	    				k+=1;
	    			}
	    		
	    		for(int j=0;j<list.size();j++) {
	    			if(list.get(j).equals(words[i])) {
	    				break loop;
	    			}
	    		}
	    		
	    		list.add(words[i-1]);
	    		char a = words[i-1].charAt(words[i-1].length()-1);
	    		char b = words[i].charAt(0);
	    		if(a!=b) {
	    			break;
	    		}
	    	}
    	
    	if(list.size()+1==words.length) {
    		cnt=0;
    		k=0;
    	}
    	
        answer = new int[] {cnt,k};
        return answer;
    }
}
	


