import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String str, res;
		StringTokenizer st;
		boolean first = true;
		while((str = bin.readLine()) != null) {
			st = new StringTokenizer(str);
			int k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			if(!first) {
				pw.println();
			}
			int[] set = new int[k];
			for(int i =0 ; i < k; i++) {
				set[i] = Integer.parseInt(st.nextToken());
			}
			for(int a = 0; a < k-5; a++) {
				for(int b = a+1; b < k-4; b++) {
					for(int c = b+1; c < k-3; c++) {
						for(int d = c+1; d < k-2; d++) {
							for(int e = d+1; e < k-1; e++) {
								for(int f = e+1; f < k; f++) {
									pw.format("%d %d %d %d %d %d\n", set[a], set[b], set[c], set[d], set[e], set[f]);
								}
							}
						}
					}
				}
			}
			first = false;
		}
		pw.flush();
		pw.close();
	}

}
