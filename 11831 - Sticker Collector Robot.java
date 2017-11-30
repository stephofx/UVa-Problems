import java.util.*;
import java.io.*;
class Main {

	static char[] cardinal = {'N', 'L', 'S', 'O'};

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		String str;
		while((str = bin.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken()); int s = Integer.parseInt(st.nextToken());
			if(n == 0 && s == 0 && m == 0) break;
			char[][] arena = new char[n][m]; //arena of stickers, pillars
			int orientation = 0;
			int r = 0;
			int c = 0;
			int stickers = 0;
			for(int i = 0; i < n; i++) {
				char[] arr = bin.readLine().toCharArray();
				for(int j = 0; j < m; j++) {
					arena[i][j] = arr[j];
					if(arena[i][j] == 'N' ||arena[i][j] == 'S' ||arena[i][j] == 'L'||arena[i][j] == 'O') {
						r = i;
						c = j;
					}
					if(arena[i][j] == 'S') {
						orientation = 2;
					} else if(arena[i][j] == 'L') {
						orientation = 1;
					} else if(arena[i][j] == 'O'){
						orientation = 3;
					}
				}
			}
			char[] dir = bin.readLine().toCharArray(); //directions for robot
			for(int i = 0; i < dir.length; i++) {
				if(dir[i] == 'D') { //rotate 90 to right
					if(orientation == 3) {
						orientation = 0;
					} else {
						orientation++;
					}
					arena[r][c] = cardinal[orientation];
				} else if(dir[i] == 'E') { //rotate 90 to left
					if(orientation == 0) {
						orientation = 3;
					} else {
						orientation--;
					}
					arena[r][c] = cardinal[orientation];
				}
				if(dir[i] == 'F') {
					if( r > 0 && cardinal[orientation] == 'N' && arena[r-1][c] != '#') {
						if(arena[r-1][c] == '*') {
							stickers++;
							arena[r-1][c] = cardinal[orientation];
							arena[r][c] = '.';
						} else {
							arena[r-1][c] = cardinal[orientation];
							arena[r][c] = '.';
						}
						r--;
					} else if(c < m-1 && cardinal[orientation] == 'L' && arena[r][c+1] != '#') {
						if(arena[r][c+1] == '*') {
							stickers++;
							arena[r][c+1] = cardinal[orientation];
							arena[r][c] = '.';
						} else {
							arena[r][c+1] = cardinal[orientation];
							arena[r][c] = '.';
						}
						c++;
					} else if(r < n-1  && cardinal[orientation] == 'S' && arena[r+1][c] != '#') {
						if(arena[r+1][c] == '*') {
							stickers++;
							arena[r+1][c] = cardinal[orientation];
							arena[r][c] = '.';
						} else {
							arena[r+1][c] = cardinal[orientation];
							arena[r][c] = '.';
						}
						r++;
					} else if(c > 0 && cardinal[orientation] == 'O' && arena[r][c-1] != '#') {
						if(arena[r][c-1] == '*') {
							stickers++;
							arena[r][c-1] = cardinal[orientation];
							arena[r][c] = '.';
						} else {
							arena[r][c-1] = cardinal[orientation];
							arena[r][c] = '.';
						}
						c--;
					}
				}
			}
			pw.println(stickers);
		}
		pw.flush();
		pw.close();

	}

}