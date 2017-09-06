import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class armybuddies {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bw = new BufferedOutputStream(System.out);
		StringTokenizer st;
		int s, b, L, subL, R, subR;
		StringBuilder sb = new StringBuilder(25000);
		int left[] = new int[100002];
		int right[] = new int[100002];
		String str;
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			s= Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(s == 0 && b == 0 ) break;
			left[0] = right[0] = 0;
			for(int k = 1; k < s; k++) { 
				left[k] = k-1;
				right[k] = k+1;
			}
			left[s] = right[s] = 0;
			for(int i = 0; i < b; i++) {
				st = new StringTokenizer(br.readLine());
				L =  Integer.parseInt(st.nextToken());
				subL = left[L];
				R =  Integer.parseInt(st.nextToken());
				subR = right[R];
				if(subL == 0) {
					sb.append('*');
				} else {
					sb.append(subL);
				}
				sb.append(' ');
				if(subR == 0) {
					sb.append('*');
				} else {
					sb.append(subR);
				}
				sb.append('\n');
				left[subR] = subL;
				right[subL] = subR;
			}
			sb.append("-\n");
			if (sb.length() >= 12000) {
                bw.write(sb.toString().getBytes());
                sb = new StringBuilder(25000);
            }
		}
		bw.write(sb.toString().getBytes());
		bw.flush();
        bw.close();
	}

}
