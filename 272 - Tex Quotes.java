import java.io.*;
import java.util.Scanner;
public class texquotes {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("texquotes.txt"));
		boolean first = true;
		while(sc.hasNextLine()) {
			String current = sc.nextLine();
			String copy = "";
			if(!current.contains("\"")) {
				copy = current;
				System.out.println(copy);
				continue;
			}
			for(int i = 0; i < current.length(); i++) {
				if(current.charAt(i) == '\"' && first) {
					copy += "``";
					first = false;
				} else if(current.charAt(i) == '\"' && !first) {
					copy += "\'\'";
					first = true;
				} else {
					copy += current.charAt(i);
				}
			}
			System.out.println(copy);
		}
		
	}

}
