import java.io.*;
import java.util.*;
import java.math.*;

class Main {

	static int[] ring;
	static TreeSet<Integer> used;
	static PrintWriter pw;

	public static void main(String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str = bin.readLine();
		int caseN = 1;
		while(str != null) {
			ring = new int[Integer.parseInt(str)];
			ring[0] = 1;
			used = new TreeSet<Integer>();
			used.add(1);
			pw.format("Case %d:\n", caseN);
			if(ring.length == 1)  pw.println("1");
			fill(1);
			caseN++;
			str = bin.readLine();
			if(str != null)	pw.println();
			used.clear();
		}
		pw.flush();



	}

	public static void fill(int k) {
		if(k == ring.length-1) {
			for(int i = 2; i <= ring.length; i++) {
				boolean reach = false;
				if(isPrime(ring[0] + i) && isPrime(ring[k-1] + i) && !used.contains(i)) {
					ring[k] = i;
					used.add(i);
					reach = true;
					for(int j = 0; j < ring.length; j++) {
						pw.print(ring[j]);
						if(j != ring.length-1) pw.print(" ");
					}
					pw.print("\n");
					
				}
				if(reach) used.remove(i);
			}
		} else {
			for(int i = 2; i <= ring.length; i++) {
				boolean reach = false;
				if(isPrime(ring[k-1] + i) && !used.contains(i)) {
					ring[k] = i;
					used.add(i);
					reach = true;
					fill(k+1);
				}
				if(reach) used.remove(i);
			}
		}
		
	}

	public static boolean isPrime(int k) {
		for(int i = 2; i <= Math.sqrt(k); i++) {
			if(k % i == 0) return false;
		}
		return true;
	}

}