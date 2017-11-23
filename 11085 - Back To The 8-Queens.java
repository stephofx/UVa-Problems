import java.util.*;
import java.io.*;
import java.math.*;
class Main{

	static int[] pos, cpy;
	static int moves;

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str = "";
		int caseNum = 1;
		while((str = bin.readLine()) != null) {
			moves = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(str);
			pos = new int[8];
			for(int i = 0;i < 8; i++) {
				int cur =  Integer.parseInt(st.nextToken());
				pos[i] = cur-1;
			}
			cpy = pos.clone();
			move(0);
			pw.println("Case " + caseNum + ": " + moves);
			caseNum++;
		}
		pw.flush();
		pw.close();
	}

	public static void move(int c) {
		if(c == 8) {
			int cur = 0;
			for(int i = 0; i < 8; i++) {
				if(pos[i] != cpy[i]) cur++;
			}
			if(cur < moves) {
				moves = cur;
			}
		}
		for(int i = 0; i < 8; i++) {
			if(possible(i, c)) {
				pos[c] = i;
				if(c < 8) move(c+1);
			}
		}
	}

	public static boolean possible(int r, int c) {
		for(int i = 0; i < c; i++) {
			if(pos[i] == r || Math.abs(pos[i]-r) == Math.abs(c-i)) {
				return false;
			}
		}
		return true;
	}

}
