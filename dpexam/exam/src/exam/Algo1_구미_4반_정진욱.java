package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo1_구미_4반_정진욱 {
	static int N,S,M;//N: 신청한 동아리 수, S: 동아리를 구성할 수 있는 팀원 3명의 능력 합의 최소값, M: 개인 능력치에 대한 스마트 클럽 가입조건
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] grade;//학생들의 성적 배열
	static int[] sum;//학생들의 성적 합 배열
	static ArrayList<Integer> list;//조건에 맞는 학생들의 점수를 저장할 arraylist
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//동아리수 입력
		S = Integer.parseInt(st.nextToken());//능력 합의 최소값 입력
		M = Integer.parseInt(st.nextToken());//개인의 최소 능력치 입력
		grade = new int[N][3];//동아리 별로 입력받을 학생들의 성적. 
		list = new ArrayList<>();//그룹을 만들 수 있는 성적을 저장할 수 있는 공간
		int res =0;//만들수 있는 그룹의 수
		for(int i=0;i<N;i++) {//성적 입력
			st=new StringTokenizer(br.readLine());
			grade[i][0]=Integer.parseInt(st.nextToken());//i행의 동아리를 만들 학생1
			grade[i][1]=Integer.parseInt(st.nextToken());//i행의 동아리를 만들 학생2
			grade[i][2]=Integer.parseInt(st.nextToken());//i행의 동아리를 만들 학생3
			if(grade[i][0]>=M&&grade[i][1]>=M&&grade[i][2]>=M) {//그룹에 속하는  모든 학생들의 성적이 M이상이면
				if(grade[i][0]+grade[i][1]+grade[i][2]>=S) {//성적 합이 S 이상이면
					list.add(grade[i][0]);//성적 저장
					list.add(grade[i][1]);//성적 저장
					list.add(grade[i][2]);//성적 저장
					res++;//만들 수 있는 그룹 +1
				}
			}
		}
		System.out.println(res);//그룹 수 출력
		for(int i=0;i<list.size();i++) {//점수 출력
			System.out.print(list.get(i)+" ");
		}
		
	}

}
