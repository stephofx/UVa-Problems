import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		int n = Integer.parseInt(bin.readLine());
		while(--n != -1) {
			StringTokenizer st = new StringTokenizer(bin.readLine());
			int i = Integer.parseInt(st.nextToken());
			int[] polyn = new int[i+1]; 
			i = 0;
			while(st.hasMoreTokens()) {
				polyn[i] =Integer.parseInt(st.nextToken());
				i++;
			}
			int sum = 0;
			int diff= Integer.parseInt(bin.readLine());
			int k = Integer.parseInt(bin.readLine());
			int x = 0;
			for(int j = 0; j < 1000001; j++) {
				sum = (j+1)*(diff + diff*(j+1))/2; //sum of arithmetic series to find j+1th sum >= k-value
				if(sum >= k) {
					x = j+1;
					break;
				}
			}
			BigInteger tot = new BigInteger("0");
			for(int l = 0; l < polyn.length; l++) {
				tot = tot.add(BigInteger.valueOf((long)(polyn[l]*(Math.pow(x, l)))));
			}
			String res = tot.toString() + "\n";
			bout.write(res.getBytes());
		}
		bout.flush();
		bout.close();

	}

}
