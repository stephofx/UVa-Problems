import java.io.*;
import java.util.*;
class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str, res;
		int caseNum = 1;
		while((str = bin.readLine()) != null) {
			int size_set = Integer.parseInt(str);
			if(size_set == 0) break;
			int[] set = new int[size_set];
			for(int i = 0; i < set.length; i++) {
				set[i] = Integer.parseInt(bin.readLine());
			}
			String caseList = "Case " + caseNum + ":\n";
			bout.write(caseList.getBytes());
			caseNum++;
			Arrays.sort(set);
			int size_queries = Integer.parseInt(bin.readLine());
			for(int i = 0; i < size_queries; i++) {
				int q = Integer.parseInt(bin.readLine());
				int sum = 0;
				int curDist = Integer.MAX_VALUE;
				for(int j = 0; j < size_set-1; j++) {
					for(int k = j+1; k < size_set; k++) {
						if(Math.abs(set[j] + set[k] - q) < curDist) {
							sum = set[j] + set[k];
							curDist = Math.abs(set[j] + set[k] - q);
						}
					}
				}
				res = "Closest sum to " + q + " is " + sum + ".\n";
				bout.write(res.getBytes());
			}
		}
		bout.flush();
		bout.close();
	}

}
