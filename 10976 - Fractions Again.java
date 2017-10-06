import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str, res;
		while((str = bin.readLine()) != null) {
			int k = Integer.parseInt(str);
			int pairs = 1;
			int index = 1;
			for(int y = k+2; y <= k*2; y++) {
				if((k*y) % (y-k) == 0) {
					pairs++;
				}			
			}
			res = pairs + "\n";
			bout.write(res.getBytes());
			res = "1/" + k + " = " + "1/" +  k*(k+1) + " + " + "1/" + (k+1) + "\n";
			bout.write(res.getBytes());
			index = 1;
			for(int y = k+2; y <= k*2; y++) {
				if((k*y) % (y-k) == 0) {
					res = "1/" + k + " = " + "1/" + ((long)(k*y)/(y-k)) + " + " + "1/" + y + "\n";
					bout.write(res.getBytes());
					index++;
				}
			}
		}
		bout.flush();
		bout.close();
	}

}
