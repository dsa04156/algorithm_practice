import java.util.*;
import java.io.*;
 
/**
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법
 * 1. 1일 이용권
 * 2. 한달 이용권 (1일부터 시작~
 * 3. 3달 이용권 ( 11, 12, 1 이런식으로 안되고 1~12만 가능)
 * 4. 1년 이용권 (1월 1일부터 ~~
 *
 * 1~12까지 배열에 해당 달에 이용할 날의 수가 주어짐
 * 가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾자
 *
 *
 */
public class Solution {
    static int T,day,month,three,year,min;
    static int[] plan = new int[12];
    public static void main(String[] args) throws Exception{
       	Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
 
        for(int t=1; t<=T; t++){
            day = sc.nextInt();
            month = sc.nextInt();
            three = sc.nextInt();
            year =sc.nextInt(); 
            int daydata = 0;
 
            for(int i=0; i<12; i++) {
                plan[i] = sc.nextInt();
                if(plan[i] > 0){
                    daydata += plan[i];
                }
            }
 
            min = Math.min(year , day*daydata);
 
            dfs(0,0);
            plan = new int[12];
            System.out.println("#"+t+" "+min);
        }
    }
 
    private static void dfs(int depth, int sum) {
        if(sum > min){
            return;
        }
        if(depth > 11){
            min = Math.min(sum,min);
            return;
        }
 
        if(plan[depth] == 0)
            dfs(depth+1, sum);
        else{
            dfs(depth + 1, sum + month);
            dfs(depth + 1, sum + plan[depth] * day);
            dfs(depth + 3, sum + three);
        }
    }
}