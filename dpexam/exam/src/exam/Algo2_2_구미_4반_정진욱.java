package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo2_2_구미_4반_정진욱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BigInteger big = new BigInteger("100009");
		BigInteger big2 = new BigInteger("100008");
		BigInteger a = new BigInteger("6");
		
		BigInteger res;
		res = big.multiply(big);
		res = res.multiply(big);
		res= res.subtract(big2);
		res = res.remainder(a);
		System.out.println(res);
	}

}
