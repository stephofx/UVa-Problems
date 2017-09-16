import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str,res;
		StringTokenizer st;
		BitSet bs;
		while((str = bin.readLine()) != null) {
			bs = new BitSet(1000000);
			st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n == 0 && m == 0) break;
			boolean conflict = false;
			check1:
			for(int i = 0; i < n; i++) {
				str = bin.readLine();
				st = new StringTokenizer(str);
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				for(int k = start; k < end; k++) {
					if(bs.get(k)) {
						conflict = true;
						for(int a = i+1; a < n; a++) str = bin.readLine();
						break check1;
					}
					bs.set(k);
				}
			}
			if(!conflict) {
				check2:
				for(int j = 0; j < m; j++) {
					str = bin.readLine();
					st = new StringTokenizer(str);
					int start = Integer.parseInt(st.nextToken());
					int end = Integer.parseInt(st.nextToken());
					int interval = Integer.parseInt(st.nextToken());
					for(int i = start; i < 1000000; i += interval) {
						int newEnd = i+(end-start);
						if(end > 1000000) end = 1000000;
						for(int k = i; k < newEnd; k++) {
							if(bs.get(k)) {
								conflict = true;
								for(int a = j+1; a < m; a++) str = bin.readLine();
								break check2;
							}
							bs.set(k);
						}
					}
				}
			} else {
				for(int i = 0; i < m; i++) {
					str = bin.readLine();
				}
			}
			if(conflict) {
				res = "CONFLICT\n";
			} else {
				res = "NO CONFLICT\n";
			}
			bout.write(res.getBytes());
		}
		bout.flush();
		bout.close();

	}

}
