import java.util.*;
import java.io.*;

public class rfp {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("rfp.txt"));
		String[] cur = bf.readLine().split(" ");
		int nReq = Integer.parseInt(cur[0]);
		int nProp = Integer.parseInt(cur[1]);
		String bestProp = "";
		int maxReq = 0;
		double minPrice = Integer.MAX_VALUE;
		int count = 1;
		while(nReq != 0 && nProp != 0) {
			bestProp = "";
			maxReq = 0;
			minPrice = Integer.MAX_VALUE;
			for(int i = 0; i < nReq; i++) {
				String skip = bf.readLine();
			}
			for(int k = 0; k < nProp; k++ ) {
				String curName = bf.readLine(); //does not account for spaces.
				cur = bf.readLine().split(" ");
				double curPrice = Double.parseDouble(cur[0]);
				int curReq = Integer.parseInt(cur[1]);
				if(curReq > maxReq) {
					bestProp = curName;
					minPrice = curPrice;
					maxReq = curReq;
				} else if(curReq == maxReq) {
					if(minPrice > curPrice) {
						bestProp = curName;
						minPrice = curPrice;
					}
				}
				for(int j = 0; j < curReq; j++) {
					String skip = bf.readLine();
				}
			}
			System.out.println("RFP #" + count);
			count++;
			System.out.println(bestProp);
			cur = bf.readLine().split(" ");
			nReq = Integer.parseInt(cur[0]);
			nProp = Integer.parseInt(cur[1]);
			if(nReq != 0 && nProp != 0) System.out.println();
		}

	}

}
