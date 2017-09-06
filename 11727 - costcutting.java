import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.math.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a, b, c, n;
		n = Integer.parseInt(st.nextToken(""));
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			Arrays.sort(arr);
			System.out.println("Case " + i + ": " + arr[1]);
		}
	}

}
