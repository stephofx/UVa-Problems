import java.io.*;
import java.util.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st;
		String str;
		while((str = bin.readLine()) != null) {
			st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken()); //num bus drivers
			int d = Integer.parseInt(st.nextToken()); //max route length per day
			int r = Integer.parseInt(st.nextToken()); //overtime rate in money/hour
			if(n == 0 && d == 0 && r == 0) break;
			int[] morn = new int[n];
			int[] even = new int[n];
			st = new StringTokenizer(bin.readLine());
			for(int i = 0; i < n; i++) {
				morn[i] = (Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(bin.readLine());
			for(int i = 0; i < n; i++) {
				even[i] = (Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(morn);
			Arrays.sort(even);
			int cost = 0;
			for(int i = 0; i < n; i++) {
				int length = d;
				length -= morn[i] + even[n-1-i];
				if(length < 0) {
					cost += length*-1*r;
				}
			}
			pw.println(cost);

 		}
 		pw.flush();
 		pw.close();
	}
}