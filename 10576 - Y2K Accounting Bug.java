import java.io.*;
import java.util.*;

class Main {

	static int[] status;
	static int max;
	static int surplus, deficit;
	static PrintWriter pw;

	public static void main(String args[]) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			surplus = Integer.parseInt(st.nextToken());
			deficit = Integer.parseInt(st.nextToken());
			int index = 0; //current index of status
			status = new int[12];
			max = 0;
			generate(index);
			if(max > 0)	pw.println(max);
			else pw.println("Deficit");
		}
		pw.flush();
	}

	public static void generate(int i) {
		if(i == 12) { //ending case
			int s = 0;
			for(int j = 0; j < 12; j++) {
				s += status[j];
			}
			if(s > max) {
				max = s;
			}
			return;
		}
		
		//add surplus first
		status[i] = surplus;
		if(i > 5) {
			int temp = 0;
			for(int j = i; j > i-5; j--) {
				temp += status[j];
			}
			if(temp > 0) {
				return;
			}
		}
		generate(i+1);
		status[i] = 0;

		//add deficit
		status[i] -= deficit;
		if(i > 5) {
			int temp = 0;
			for(int j = i; j > i-5; j--) {
				temp += status[j];
			}
			if(temp > 0) {
				return;
			}
		}
		generate(i+1);
		status[i] = 0;
	}

}