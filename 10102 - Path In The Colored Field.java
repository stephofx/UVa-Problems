import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			int n = Integer.parseInt(str);
			int[][] g = new int[n][n];
			for(int i = 0; i < n; i++) {
				String[] s = bin.readLine().split("");
				for(int j = 0; j < n; j++) {
					g[i][j] = Integer.parseInt(s[j]);
				}
			}
			int minDistances[] = new int[10000];
			int finDistance = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(g[i][j] == 1) {
						int distance = Integer.MAX_VALUE;
						for(int k = 0; k < n; k++) {
							for(int l = 0; l < n; l++) {
								if(g[k][l] == 3) {
									if(distance > Math.abs(i-k) + Math.abs(j-l)) {
										distance = Math.abs(i-k) + Math.abs(j-l);
									}
								}
							}
						}
						if(finDistance < distance) {
							finDistance = distance;
						}
					}
				}
			}
			pw.println(finDistance);
			
		}
		pw.flush();
		pw.close();
	}

}
