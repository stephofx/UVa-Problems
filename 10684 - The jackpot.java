import java.io.*;
import java.util.*;
import java.math.*;
class Main{

	public static void main (String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			if(str.equals("")) continue;
			int n = Integer.parseInt(str);
			if(n == 0) break;
			int[] seq = new int[n];
			int count = 0;
			while(count != n) {
				str = bin.readLine();
				if(str.equals("")) continue;
				StringTokenizer st = new StringTokenizer(str);
				while(st.hasMoreTokens()) {
					seq[count] = Integer.parseInt(st.nextToken());
					count++;
					if(count == n) break;
				}
			} 
			int curSum = 0;
			int maxSum = 0;
			for(int i = 0; i < n; i++) {
				curSum = Math.max(0, curSum+seq[i]);
				maxSum = Math.max(maxSum, curSum);
			}
			if(maxSum <= 0) pw.println("Losing streak.");
			else pw.println("The maximum winning streak is " + maxSum + ".");
		}
		pw.flush();
		pw.close();
	}


}