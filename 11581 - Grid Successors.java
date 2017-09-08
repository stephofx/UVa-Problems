import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bs = new BufferedOutputStream(System.out);
		StringTokenizer st;
		String str,res;
		int cases = Integer.parseInt(br.readLine());
		while(--cases != -1) {
			str = br.readLine();
			int totalSum = 0;
			int index = 0;
			int[][] grid = new int[3][3];
			int[][] temp = new int[3][3];
			for(int i = 0; i < grid.length; i++) {
				str = br.readLine();
				str = str.replaceAll("", " ");
				st = new StringTokenizer(str);
				for(int j = 0; j < grid[i].length; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken(" "));
					totalSum += grid[i][j];
				}
			}
			if(totalSum == 0) {
				res = "-1\n";
				bs.write(res.getBytes());
				continue;
			}
			while(true) {
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j<3; j++) {
						temp[i][j] = 0;
						if(i+1 < grid.length) {
							temp[i][j] += grid[i+1][j];
						} 
						if(j+1 < grid.length) {
							temp[i][j] += grid[i][j+1];
						} 
						if(i-1 > -1) {
							temp[i][j] += grid[i-1][j];
						} 
						if(j-1 > -1) {
							temp[i][j] += grid[i][j-1];
						}
						temp[i][j] %= 2;
						totalSum += temp[i][j];
					}
				}
				if(!equality(grid, temp)) {
					index++;
					for(int k = 0; k < 3; k++) {
						for(int l = 0; l < 3; l++) {
							grid[k][l] = temp[k][l];
						}
					}
				} else {
					break;
				}
			}
			res = "" + (index-1) + "\n";
			bs.write(res.getBytes());
		}
		bs.flush();
		bs.close();
	}
	
	public static boolean equality(int[][] grid, int[][] temp) {
		for(int k = 0; k < 3; k++) {
			for(int l = 0; l < 3; l++) {
				if(grid[k][l] != temp[k][l]) {
					return false;
				} 
			}
		}
		return true;
	}

}
