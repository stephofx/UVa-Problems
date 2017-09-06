import java.util.*;
import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class newspaper {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("newspaper.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
		DecimalFormat df = new DecimalFormat("0.00");
		int n = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < n; i++) {
			int nPaid = Integer.parseInt(br.readLine()); 
			double total = 0.0;
			Hashtable<String, Double> ht = new Hashtable<String, Double>(nPaid);
			for(int j = 0; j < nPaid; j++) {
				String[] next = br.readLine().split(" ");
				double nextAmt = Double.parseDouble(next[1])*0.01;
				ht.put(next[0], nextAmt);
			}
			int nLines = Integer.parseInt(br.readLine());
			for(int k = 0 ; k < nLines; k++) {
				String[] cur = br.readLine().split("");
				for(int l = 0; l < cur.length; l++) {
					if(ht.containsKey(cur[l])) total += ht.get(cur[l]);
				}
			}
			System.out.println(df.format(total) + "$");
		}
	}
}
