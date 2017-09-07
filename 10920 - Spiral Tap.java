import java.util.*;
import java.io.*;
import java.math.BigInteger;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bs = new BufferedOutputStream(System.out);
		StringTokenizer st;
		String str;
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			int size = Integer.parseInt(st.nextToken(" "));
			BigInteger pos = new BigInteger((st.nextToken(" ")));
			int row = (size+1)/2;
			int col = (size+1)/2;
			if(size == 0 && pos.equals(BigInteger.ZERO)) break;
			if(pos.equals(BigInteger.ONE)) {
				String res = "Line = " + row + ", " + "column = " + col + ".\n";
				bs.write(res.getBytes());
				continue;
			}
			int rt =sqrt(pos).intValue();
			int maxRow = row + rt/2;
			int maxCol = maxRow;
			if(rt % 2 ==0) rt++;
			BigInteger topRight = BigInteger.valueOf((long)(Math.pow((double)rt, 2)));
			int distance = topRight.subtract(pos).intValue();
			rt--;
			if(distance/(rt) == 0) {
				row = maxRow - (distance % (rt));
				col = maxCol;
			} else if(distance/rt == 1) {
				row = maxRow - rt;
				col = maxCol - (distance % rt);
			} else if(distance/rt == 2) {
				row = maxRow - (rt-(distance % rt));
				col = maxCol - rt;
			} else {
				row = maxRow;
				col = maxCol - (rt-(distance % rt));
			}
			String res = "Line = " + row + ", " + "column = " + col + ".\n";
			bs.write(res.getBytes());
			
		}
		bs.flush();
		bs.close();
		
	}
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger two = BigInteger.valueOf(2L);
	    BigInteger y;
	    for (y = x.divide(two); y.compareTo(x.divide(y)) > 0; y = ((x.divide(y)).add(y)).divide(two));
	    if (x.equals(y.multiply(y))) {
	        return y;
	    } else {
	        return y.add(BigInteger.ONE);
	    }
	}
	
	/* Ditched method after large input
	 * while((str = br.readLine()) != null) {
		st = new StringTokenizer(str);
		int size = Integer.parseInt(st.nextToken(" "));
		int pos = Integer.parseInt(st.nextToken(" "));
		if(size == 0 && pos == 0) break;
		int[][] spiral = new int[size][size];
		int num = 2;
		int numSteps = 1;
		int row = (size+1)/2;
		int col = (size+1)/2;
		 search:
	for(int i = 0; i < size; i++) {
		for(int j = 1; j <= numSteps; j++) {
			if(pos == 1) break search;
			if(numSteps % 2 == 0) {
				spiral[++row-1][col-1] = num;
			} else {
				spiral[--row-1][col-1] = num;
			}
			if(num == pos) break search;
			num++;
		}
		for(int k = 1; k <= numSteps; k++) {
			if(numSteps % 2 == 0) {
				spiral[row-1][++col-1] = num;
			} else {
				spiral[row-1][--col-1] = num;
			}
			if(num == pos) break search;
			num++;
		}
		if(i == size-1) {
			if(numSteps % 2 == 0) {
				spiral[++row-1][col-1] = num;
			} else {
				spiral[--row-1][col-1] = num;	
			}
			if(num == pos) break search;
			num++;
		}
		numSteps++;
	}
	String res = "Line = " + (size-row+1) + ", " + "Column = " + col + ".\n";
	bs.write(res.getBytes()); 
	bs.flush();
	bs.close();

} */
	 

}
