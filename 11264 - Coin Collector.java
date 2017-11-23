import java.util.*;
import java.io.*;
import java.math.*;
class Main {

	static int[] c;

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		int cases = Integer.parseInt(bin.readLine());
		while(--cases != -1) {
			int coins = Integer.parseInt(bin.readLine());
			StringTokenizer st = new StringTokenizer(bin.readLine());
			c = new int[coins];
			int sum = 0;
			for(int i = 0; i < coins; i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}
			long max = 1;
			int count = 2; //can always make at least two
			for(int i = 1; i < coins-1; i++) {
				if(max + c[i] < c[i+1]) { //choosing a coin must not add up to be more than the coin above it, so that all coins are taken.
					max += c[i];
					count++;
				}
			}
			pw.println(count);
		}
		pw.flush();
		pw.close();
	}

}