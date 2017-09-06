import java.util.*;
import java.io.*;
import java.math.*;
public class jolly {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("jolly.txt"));
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] diff = new int[n-1];
			BitSet bs = new BitSet(n-1);
			boolean jolly = true;
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			} 
			for(int j = 0; j < n-1; j++) {
				bs.set(Math.abs(arr[j] - arr[j+1])-1, true);
			}
			for(int j = 0; j < n-1; j++) {
				if(!bs.get(j)) jolly = false; 
			}
			if(jolly) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}
			
		}
		

	}

}
