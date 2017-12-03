import java.util.*;
import java.io.*;
class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(bin.readLine()); //n test cases <= 50
		int cNum = 1; //case num
		while(--t != -1) {
			StringTokenizer st = new StringTokenizer(bin.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int[][] grid = new int[r][c]; // -1 water, 0 unvisited, 1 visited
			int odd = 0; int even = 0; 
			int w = Integer.parseInt(bin.readLine());
			for(int i = 0; i < w; i++) { //fills water holes
				st = new StringTokenizer(bin.readLine());
				grid[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
			}
			Pair[] pos = {new Pair(m, n), new Pair(-m, n), new Pair(m, -n), new Pair(-m, -n),
							new Pair(n, m), new Pair(-n, m), new Pair(n, -m), new Pair(-n, -m)}; //easy for iteration
			HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>> ();

			Queue<Pair> q = new LinkedList<Pair>();
			q.add(new Pair(0,0));
			grid[0][0] = 1;
			while(!q.isEmpty()) {
				int k = 0; //num reachABLE nodes.
				Pair cur = q.remove();
				for(int i = 0; i < 8; i++) {
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(pos[i].r+cur.r); tmp.add(pos[i].c+cur.c);
					if(pos[i].r+cur.r > -1 && pos[i].r+cur.r < r && pos[i].c+cur.c > -1 && pos[i].c+cur.c < c && grid[pos[i].r+cur.r][pos[i].c+cur.c] != -1 && !hs.contains(tmp)) { //checks for reachability and validity in grid and prevents exact same nodes from being said as reachable
						k++;
						hs.add(tmp);
						if(grid[pos[i].r+cur.r][pos[i].c+cur.c] == 0) { //actual nodes that are unvisited for bfs
							q.add(new Pair(pos[i].r+cur.r, pos[i].c+cur.c));
							grid[pos[i].r+cur.r][pos[i].c+cur.c] = 1;
						}
					}
				}
				hs.clear();
				if(k % 2 == 0) {
					even += 1;
				} else {
					odd += 1;
				}

			}
			pw.println("Case " + cNum + ": " + even + " " + odd);
			cNum++;
		}	
		pw.flush();
		pw.close();

	}

}

class Pair{
	int r;
	int c;
	public Pair(int x, int y) {
		r = x;
		c = y;
	}


}

