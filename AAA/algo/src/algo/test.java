package algo;

public class test {
	static char[] arr = new char[] {'a','b','c','d'};
	static boolean[] v=new boolean[arr.length];
	static int max = 0;
	public static void main(String[] args) {
		s(0,0);
		
	}
	static void s(int idx,int cnt) {
		if(cnt==2) {
			for(int i=0;i<arr.length;i++) {
				if(v[i]==true) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		if(idx==arr.length) return;
		
		v[idx]=true;
		s(idx+1,cnt+1);
		v[idx]=false;
		s(idx+1,cnt);
	}

}
