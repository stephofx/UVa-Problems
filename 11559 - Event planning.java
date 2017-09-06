import java.util.*;
import java.io.*;

public class event {

	public static void main (String args[]) throws IOException {
		Scanner sc = new Scanner(new FileReader("event.txt"));
		while(sc.hasNextInt()) {
			int nParticipants = sc.nextInt();
			int budget = sc.nextInt();
			int nHotels = sc.nextInt();
			int nWeeks = sc.nextInt();
			int minPrice = budget;
			boolean withinBudget = false;
			for(int i = 0; i < nHotels; i++) {
				int price = sc.nextInt();

				for(int j = 0; j < nWeeks; j++) {
					int nBeds = sc.nextInt(); 
					if(nBeds >= nParticipants && price*nParticipants <= minPrice) {
						minPrice = price*nParticipants;
						withinBudget = true;
					}
				}
			}
			if(withinBudget) {
				System.out.println(minPrice);
			} else {
				System.out.println("stay home");
			}
		}
	}
}
