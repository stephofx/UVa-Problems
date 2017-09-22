import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException {
			BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
			BufferedOutputStream bout = new BufferedOutputStream(System.out);
			String str, res;
			StringTokenizer st;
			Stack<Integer> s = new Stack<Integer>();
			while((str = bin.readLine()) != null) {
				int n = Integer.parseInt(str);
				test:
				while(n != 0) {
					boolean possible = false;
					res = "";
					str = bin.readLine();
					st = new StringTokenizer(str);
					int train = 1;
					while(st.hasMoreTokens()) {
						int cur = Integer.parseInt(st.nextToken());
						if(cur == 0) break test;
						if(cur == train) {
							if(train == n && s.isEmpty()) possible = true;
							train++;
							if(train > n) train = n;
							continue;
						}
						else {
							if(s.isEmpty() || (cur != train && (!s.isEmpty() && s.peek() != cur))) {
								for(int i = train; i <= cur; i++) {
									s.push(i);
								}
								train = cur+1;
								if(train > n) train = n;
								if(cur != train && (!s.isEmpty() && s.peek() != cur)) {
									possible = false;
									while(st.hasMoreTokens()) cur = Integer.parseInt(st.nextToken());
									break;
								}
							}
							if(s.peek() == cur) {
								s.pop();
							} else if (s.peek() != cur && train != cur) {
								possible = false;
							}
						}
						if(train == n && s.isEmpty()) possible = true;
					}
					if(possible) {
						res = "Yes\n";
					} else {
						res = "No\n";
					}
					
					bout.write(res.getBytes());
					s.clear();
				}
				String newline = "\n";
				if(n != 0) bout.write(newline.getBytes());
			}
			bout.flush();
			bout.close();
	}

}
