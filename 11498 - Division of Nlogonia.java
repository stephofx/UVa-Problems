import java.util.Scanner;
public class nlogonia {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0) {
			int divX = sc.nextInt();
			int divY = sc.nextInt();
			for(int i = 0; i < t; i++) {
				int curX = sc.nextInt();
				int curY = sc.nextInt();
				if(curX == divX || curY == divY) {
					System.out.println("divisa");
				} else {
					if(curX > divX && curY < divY) {
						System.out.println("SE");
					} else if(curX > divX && curY > divY) {
						System.out.println("NE");
					} else if(curX < divX && curY > divY) {
						System.out.println("NO");
					} else {
						System.out.println("SO");
					}
				}
			}
			t = sc.nextInt();
		}

	}

}
