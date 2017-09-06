import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class sonar {
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(new FileReader("sonar.txt"));
		int num = sc.nextInt();
		while(--num != -1) {
			System.out.println((sc.nextInt()/3)*(sc.nextInt()/3));
		}
	}
}
