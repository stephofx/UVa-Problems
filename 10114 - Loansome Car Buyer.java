
import java.util.*;

public class loansome {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int months = sc.nextInt();
		while(months > 0) {
			double down = sc.nextDouble();
			double total = sc.nextDouble();
			int numDep = sc.nextInt();
			double percentage = 0.0;
			double prevPercentage = 0.0;
			int totalMonths, currentMonth, i;
			totalMonths = currentMonth = 0;
			double value = down + total; 
			double payment = total;
			if(months > 0) {
				payment = total/months;
			}
			
			for(i = 0; i < numDep; i++) { //while there are still depreciation records
				currentMonth = sc.nextInt();
				percentage = sc.nextDouble();
				if(currentMonth == totalMonths) {
					prevPercentage = percentage;
					value *= (1-percentage);
					if(currentMonth != 0) total -= payment;
					if(total < value) {
						break;
					}
					totalMonths++;
				} else {
					for(totalMonths = totalMonths; totalMonths < currentMonth; totalMonths++) {
						value *= (1-prevPercentage);
						if(currentMonth != 0) total -= payment;
						if(total < value) {
							break;
						}
					}
					if(total < value) {
						break;
					}
					value *= (1-percentage);
					if(currentMonth != 0) total -= payment;
					prevPercentage = percentage;
					if(total < value) {
						break;
					}
					totalMonths++;
				}
				
				
			}
			
			if(i < numDep-1) {
				for(i = i; i < numDep-1; i++) {
					currentMonth = sc.nextInt();
					prevPercentage = sc.nextDouble();
				}
			}
			
			while(total >= value) { //no more depreciation records left
				value *= 1-percentage;
				total -= payment;
				if(total >= value) totalMonths++;
			}
			
			if(totalMonths == 1) {
				System.out.println(totalMonths + " month");
			} else {
				System.out.println(totalMonths + " months");
			}
			
			months = sc.nextInt();
		} 
	}
	
	

}