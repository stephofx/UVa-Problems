import java.util.*;
import java.io.*;
class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken()); //num heads
			int m = Integer.parseInt(st.nextToken()); //num knights
			if(n == 0 && m == 0) break;
			int[] heads = new int[n]; int[] knights = new int[m];
			for(int i = 0; i < n; i++) {
				heads[i] = Integer.parseInt(bin.readLine());
			}
			for(int j = 0; j < m; j++) {
				knights[j] = Integer.parseInt(bin.readLine());
			}
			Arrays.sort(heads);
			Arrays.sort(knights);
			int gold = 0;
			int k = 0;
			boolean killed = false;
			for(int i = 0; i < n; i++) {
				int cur = heads[i];
				while(k < m && knights[k] < cur) k++;
				if(k == m) break;
				gold += knights[k];
				k++;
				if(i == n-1) killed = true;
			}
			if(killed) pw.println(gold);
			else pw.println("Loowater is doomed!");
		}
		pw.flush();
		pw.close();
	}
}