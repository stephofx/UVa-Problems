import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		int[] list = new int[10000];
		int curLength = 0;
		String str;
		while((str = bin.readLine()) != null) {
			str = str.trim();
			int cur = Integer.parseInt(str);
			for(int i = 0; i <= curLength; i++) {
				if(cur < list[i]) {
					shift(list, i, curLength);
					list[i] = cur;
					curLength++;
					break;
				}
				if(i == curLength) {
					list[curLength] = cur;
					curLength++;
					break;
				}
			}
			String res = "";
			if(curLength % 2 == 0 && curLength != 0) {
				res += (long)(list[(curLength/2)-1] + (long)list[curLength/2])/2;
			} else {
				res += list[curLength/2];
			}
			res += "\n";
			bout.write(res.getBytes());
		}
		bout.flush();
		bout.close();

	} 
	
	static void shift(int[] list, int i, int curLength) {
		for(int j = curLength; j > i; j--) {
			list[j] = list[j-1];
		}
	}

}
