import java.util.*;
import java.io.*;
public class rotatedsquare {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("rotsq.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bs = new BufferedOutputStream(System.out);
		StringTokenizer st;
		String str;
		StringBuilder sb = new StringBuilder(100);
		
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			int bigSq = Integer.parseInt(st.nextToken());
			int smallSq = Integer.parseInt(st.nextToken());
			if(bigSq == 0 && smallSq == 0) break;
			String[][] big = new String[bigSq][bigSq];
			String[][] small = new String[smallSq][smallSq];
			String[][] temp = new String[smallSq][smallSq];
			for(int i = 0; i < bigSq; i++) {
				big[i] = br.readLine().split("");
			}
			for(int i = 0; i < smallSq; i++) {
				small[i] = br.readLine().split("");
			}
			for(int n = 0; n < 4; n++) {
				int count = 0;
				for(int i = 0; i < bigSq; i++) {
					for(int j = 0; j < bigSq; j++) {
						if((big[i][j]).equals(small[0][0])) {
							smallsqCheck:
							for(int k = 0; k < smallSq; k++) {
								for(int l = 0; l < smallSq; l++) {
									if((i+k >= bigSq || j+l >= bigSq) || !(big[i+k][j+l]).equals(small[k][l])) {
										break smallsqCheck;
									}
									if(k == smallSq-1 && l == smallSq-1) count++;
								}
							}
						}
					}
				}
				for(int m = 0; m < smallSq; m++) {
					for(int o = 0; o < smallSq; o++) {
						temp[o][small[o].length-m-1] = small[m][o];
						
					}
				}
				for(int m = 0; m < smallSq; m++) {
					for(int o = 0; o < smallSq; o++) {
						small[m][o] = temp[m][o];
						
					}
				}
				sb.append(count);
				if(n != 3) sb.append(' ');
				else sb.append("\n");
				if (sb.length() >= 75) {
	                bs.write(sb.toString().getBytes());
	                sb = new StringBuilder(100);
	            }
			}
		}
		bs.write(sb.toString().getBytes());
		bs.flush();
        bs.close();
	}

}
