import java.util.*;
import java.io.*;
class Main {
	static ArrayList<Integer> fin = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken());
			int numTracks = Integer.parseInt(st.nextToken());
			int[] tracks = new int[numTracks];
			int i = 0;
			while(--numTracks != -1) {
				tracks[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			i = -1;
			int closestSum = 0;
			int curSum = 0;
			int closest = fit(tracks, i, n, closestSum, (ArrayList<Integer>) fin.clone(), curSum);
			String res = fin.toString().replaceAll("\\,|\\[|\\]", "");
			pw.format("%s sum:%d\n", res, closest);
			fin.clear();
		}
		pw.flush();
		pw.close();
	}
	
	public static int fit(int[] t, int i, int n, int cSum,  ArrayList<Integer> fin, int cur) {
		if(cur ==n) {
			return n;
		} else {
			if((n-cur) > 0 && (n-cur) < (n-cSum)) {
				cSum = cur;
			} 
			while(i != t.length-1 && cSum != n) {
				fin.add(t[i+1]);
				int temp = fit(t, i+1, n, cSum, (ArrayList<Integer>) fin.clone(), cur+t[i+1]);
				if(Math.abs(temp-n) < Math.abs(cSum-n)) {
					cSum = temp;
					int sum = 0;
					for(int x: fin) {
						sum+= x;
					}
					if(sum == cSum) {
						Main.fin = (ArrayList<Integer>) fin.clone();
					}
				} 
				i++;
				if(fin.size() > 0) fin.remove(fin.size()-1);
			}
		}
		return cSum;
	}

}
