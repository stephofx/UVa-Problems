import java.io.*;
import java.util.*;
import java.math.*;

class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str; 
		int c = 1;
		while((str = bin.readLine()) != null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			BigInteger max = BigInteger.valueOf(-999999);
			BigInteger cur = BigInteger.ONE;
			for(int i =0 ; i < list.size()-1; i++) {
				cur = BigInteger.ONE;
				for(int j = i; j < list.size()-1; j++) {
					cur = cur.multiply(BigInteger.valueOf(list.get(j)));
					if(cur.compareTo(max) == 1) {
						max = cur;
					}
				}
			}
			pw.println(max);
		}
		pw.flush();
		pw.close();
	}
}