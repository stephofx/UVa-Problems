import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		StringBuilder sb;
		int n;
		while((n = Integer.parseInt(str = bin.readLine())) != 0) {
			sb = new StringBuilder();
			int a = 0;
			int b = 0;
			int[] indices = new int[32];
			int count = 0;
			for(int i = 0; i < 32; i++) {
				if((n & (1 << i)) != 0) {
					indices[count] = i;
					count++;
				}
			}
			for(int i = 0; i < indices.length; i++) {
				if(indices[i] == 0 && i != 0) break;
				if(i % 2 == 0) {
					a |= (1 << (indices[i]));
				} else {
					b |= (1 << (indices[i]));
				}
			}
			sb.append(a + " " + b + "\n");
			bout.write(sb.toString().getBytes());			
		}
		bout.flush();
		bout.close();
	}

}
