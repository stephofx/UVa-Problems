import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		int n = Integer.parseInt(bin.readLine());
		StringTokenizer st;
		while(--n != -1) {
			int size_A = Integer.parseInt(bin.readLine());
			int[] a = new int[size_A];
			int total = 0;
			st = new StringTokenizer(bin.readLine());
			for(int i = 0; i < size_A; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 1; i < a.length; i++) {
				int localCount = 0;
				for(int j = 0; j < i; j++) {
					if(a[j] <= a[i]) localCount++;
				}
				total += localCount;
			}
			String res = total + "\n";
			bout.write(res.getBytes());
		}
		bout.flush();
		bout.close();
	}

}
