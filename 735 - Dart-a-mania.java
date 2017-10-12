import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		int[] possibleScores = new int[62];
		for(int i = 1; i <= 20; i++) {
			possibleScores[i] = i;
			possibleScores[i*2] = i*2;
			possibleScores[i*3] = i*3;
		}
		possibleScores[61] = 50;
		HashMap<Integer, HashSet<ArrayList<Integer>>> com = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		HashMap<Integer, HashSet<ArrayList<Integer>>> per = new HashMap<Integer, HashSet<ArrayList<Integer>>>();
		for(int i = 0; i < 62; i++) {
			for(int j = 0; j < 62; j++) {
				for(int k = 0; k < 62; k++) {
					int totalScore = possibleScores[i] + possibleScores[j] + possibleScores[k];
					ArrayList<Integer> cur = new ArrayList<Integer>();
					cur.add(possibleScores[i]);
					cur.add(possibleScores[j]);
					cur.add(possibleScores[k]);
					if(per.containsKey(totalScore)) {
						per.get(totalScore).add(cur);
					} else {
						HashSet<ArrayList<Integer>> totalPer = new HashSet<ArrayList<Integer>>();
						totalPer.add(cur);
						per.put(totalScore, totalPer);
					}
					ArrayList<Integer> cur2 = new ArrayList<Integer>();
					cur2.add(possibleScores[i]);
					cur2.add(possibleScores[j]);
					cur2.add(possibleScores[k]);
					Collections.sort(cur2);
					if(com.containsKey(totalScore)) {
						com.get(totalScore).add(cur2);
					} else {
						HashSet<ArrayList<Integer>> totalCom = new HashSet<ArrayList<Integer>>();
						totalCom.add(cur2);
						com.put(totalScore, totalCom);
					}
				}
			}
		}
		while((str = bin.readLine()) != null) {
			int sc = Integer.parseInt(str);
			if(sc <= 0) break;
			if(!com.containsKey(sc)) {
				pw.format("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", sc);
				pw.println("**********************************************************************");
				continue;
			}
			pw.format("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", sc, com.get(sc).size());
			pw.format("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", sc, per.get(sc).size());
			pw.println("**********************************************************************");
			
		}
		pw.println("END OF OUTPUT");
		pw.flush();
		pw.close();
	}

}
