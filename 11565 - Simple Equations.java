import java.util.*;
import java.io.*;
public class simpleequations {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("simple.txt"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		int n = Integer.parseInt(bin.readLine());
		while(--n != -1) {
			StringTokenizer st = new StringTokenizer(bin.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			boolean reached = false;
			for(int i = -100; i <= 100; i++) {
				for(int j = -100; j <= 100; j++) {
					for(int k = -100; k <= 100; k++) {
						if(i != k && i != j && k != j && (i+j+k) == a && i*j*k == b && i*i+j*j+k*k == c) {
							if(!reached) pw.format("%d %d %d\n", i,j,k);
							reached = true;
						}
					}
				}
			}
			if(!reached) {
				pw.println("No solution.");
			}
		}
		pw.flush();
		pw.close();

	}

}
