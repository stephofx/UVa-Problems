import java.util.*;
import java.io.*;

public class horror {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("horror.txt"));
		int t = sc.nextInt();
		int c = 1;
		while(--t != -1) {
			int min = Integer.MIN_VALUE;
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int v = sc.nextInt();
				if(min < v) {
					min = v;
				}
			}
			System.out.println("Case " + c + ": " + min);
			c++;
		}
	}

}
