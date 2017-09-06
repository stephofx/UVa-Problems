import java.util.Scanner;

public class relationalop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while(--num != -1) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a < b) {
				System.out.println("<");
			} else if(a > b) {
				System.out.println(">");
			} else {
				System.out.println("=");
			}
		}

	}

}
