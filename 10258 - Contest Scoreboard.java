import java.util.*;
import java.io.*;
public class contestscoreboard {

	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("scoreboard.txt"));
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		StringTokenizer st;
		String str,res;
		int n = Integer.parseInt(bin.readLine());
		str = bin.readLine();
		for(int i = 0; i < n; i++) {
			contestant[] comp = new contestant[100];
			while((str = bin.readLine()) != null && !str.isEmpty()) {
				st = new StringTokenizer(str);
				int index = Integer.parseInt(st.nextToken(" "))-1;
				if(comp[index] == null ) {
					comp[index] = new contestant(index+1);
				}
				comp[index].problems[Integer.parseInt(st.nextToken(" "))-1].update(Integer.parseInt(st.nextToken(" ")), st.nextToken());
				comp[index].update();
			}
			Arrays.sort(comp, new Comparator<contestant>() {

				public int compare(contestant a, contestant b) {
					if(null == a && null == b) return 0;
					else if(null == a) return 1;
					else if(null == b) return -1;
					int aSol = a.numSolved();
					int bSol = b.numSolved();
					int aPen = a.totalPenalty();
					int bPen = b.totalPenalty();
					if(aSol != bSol) return Integer.valueOf(bSol).compareTo(Integer.valueOf(aSol));
					else if(aPen != bPen) return Integer.valueOf(aPen).compareTo(Integer.valueOf(bPen));
					else return Integer.valueOf(a.num).compareTo(Integer.valueOf(b.num));
					
				}
				
			});
			
			for(int j = 0; j < comp.length; j++) {
				if(comp[j] != null) {
					res = "" + (comp[j].num) + " "+ comp[j].numSolved() +" "+ comp[j].totalPenalty() + "\n";
					bout.write(res.getBytes());
				}
			}
			if(i != n-1) {
				res = "\n";
				bout.write(res.getBytes());
			}
		}
		bout.flush();
		bout.close();
	}

}

class contestant {
	public problem[] problems;
	public int numSolved;
	public int penalty;
	public int num;
	
	public contestant(int index) {
		problems = new problem[9];
		for(int i = 0; i < 9; i++) {
			problems[i] = new problem();
		}
		num = index;
	}
	
	public int numSolved() {
		numSolved = 0;
		for(problem i: problems) {
			if(i.status.equals("C")) numSolved++;
		}
		return numSolved;
	}
	
	public int totalPenalty() {
		penalty = 0;
		for(problem i: problems) {
			penalty += i.time;
		}
		return penalty;
	}
	
	public void update(){
		int n = numSolved();
		int p = totalPenalty();
	}
	
}
class problem {
	public int time;
	public String status;
	int count;
	boolean alreadyAC;
	
	public problem() {
		time = 0;
		status = "";
		count = 0;
		alreadyAC = false;
	}
	
	public void update(int t, String s) {
		if(s.equals("I")) {
			count++;
		} else if(s.equals("C") && !alreadyAC) {
			status = "C";
			time += t + 20*count;
			alreadyAC = true;
		}
	}

}