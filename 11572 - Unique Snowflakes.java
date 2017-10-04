import java.util.*;
import java.io.*;
class Main{

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		int n = Integer.parseInt(bin.readLine());
		while(--n != -1) {
			int numFlakes = Integer.parseInt(bin.readLine());
			long[] flake = new long[numFlakes];
			for(int i = 0; i < numFlakes; i++) {
				flake[i] = Integer.parseInt(bin.readLine());
			}
			int end = 0;
			TreeSet<Long> tm = new TreeSet<Long>();
			for(int i = 0; i < numFlakes; i++) {
				while(tm.contains(flake[i])) {
					tm.remove(flake[i-tm.size()]);
				}
				tm.add(flake[i]);
				if(tm.size() > end) {
					end = tm.size();
				}
				
			}
			
			String res = end + "\n";
			bout.write(res.getBytes());
		}
		bout.flush();
		bout.close();
	}

}
