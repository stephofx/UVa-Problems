import java.util.*;
import java.io.*; 
public class snail {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean success = false;
		int height = sc.nextInt();
		double up, down, fatigue, curH, fat;
		int day;
		while(height != 0) {
			up = sc.nextDouble();
			down = sc.nextDouble();
			fatigue = sc.nextDouble();
			curH = 0;
			day = 1;
			fat = up*(fatigue/100);
			while(curH <= height) {
				curH += up;
				if(curH <= height) {
					curH -= down;
				} else {
					success = true;
					break;
				}
				if(curH < 0) {
					success = false;
					break;
				}
				up -= fat;
				if(up < 0) up = 0;
				day++;
			}
			if(success) {
				System.out.println("success on day " + day);
			} else {
				System.out.println("failure on day " + day);
			}
			height = sc.nextInt();
		}
		
		
	}

}
