import java.util.Scanner;
public class parking {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int max, min;
		while(--t != -1) {
			int stores = sc.nextInt();
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for(int i = 0; i < stores; i++) {
				int current = sc.nextInt();
				if(max < current) {
					max = current;
				} 
				if(min > current) {
					min = current;
				}
			}
			System.out.println(2*(max-min));
		}
	}

}
