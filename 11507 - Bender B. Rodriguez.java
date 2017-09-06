import java.util.*;
import java.io.*;

public class bender {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String curDir = "+x";
		while(n != 0) {
			curDir = "+x";
			for(int i = 0; i < n-1; i++) {
				String nextDir = sc.next();
				if(nextDir.equals("No")) {
					continue;
				} else if(nextDir.equals("+y")) {
					if(curDir.equals("+z") || (curDir.equals("-z"))) continue;
					if(curDir.equals("+x")) {
						curDir = "+y";
					} else if(curDir.equals("-x")){
						curDir = "-y";
					} else if(curDir.equals("-y")) {
						curDir = "+x";
					} else if(curDir.equals("+y")) {
						curDir = "-x";
					}
						
				} else if(nextDir.equals("-y")) {
					if(curDir.equals("+z") || (curDir.equals("-z"))) continue;
					if(curDir.equals("+x")) {
						curDir = "-y";
					} else if(curDir.equals("-x")){
						curDir = "+y";
					} else if(curDir.equals("-y")) {
						curDir = "-x";
					} else if(curDir.equals("+y")) {
						curDir = "+x";
					}
				} else if(nextDir.equals("+z")) {
					if(curDir.equals("+y") || (curDir.equals("-y"))) continue;
					if(curDir.equals("+x")) {
						curDir = "+z";
					} else if(curDir.equals("-x")){
						curDir = "-z";
					} else if(curDir.equals("+z")) {
						curDir = "-x";
					} else if(curDir.equals("-z")) {
						curDir = "+x";
					}
				} else if(nextDir.equals("-z")) {
					if(curDir.equals("+y") || (curDir.equals("-y"))) continue;
					if(curDir.equals("+x")) {
						curDir = "-z";
					} else if(curDir.equals("-x")){
						curDir = "+z";
					} else if(curDir.equals("+z")) {
						curDir = "+x";
					} else if(curDir.equals("-z")) {
						curDir = "-x";
					}
				} 
			}
			System.out.println(curDir);
			n = sc.nextInt();
		}
	}

}
