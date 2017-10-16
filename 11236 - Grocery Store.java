import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
class Main {

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
		DecimalFormat df = new DecimalFormat("0.0000");
		for(int i = 1; i < 2001; i++) {
			for(int j = i; j < 2001-i; j++) {
				for(int k = j; k < 2001-i-j; k++) {
					int l = 0;
					if(i*j*k == 1000000) continue;
					if(((i+j+k)*1000000) % ((i*j*k)-1000000) == 0) {
						l = ((i+j+k)*1000000)/(i*j*k-1000000);
					} else {
						continue;
					}
					if(k > l) continue;
					if(i + j + k + l <= 2000 && l > 0 && i + j + k + l == i*j*k*l/1000000) {
						pw.format("%.2f %.2f %.2f %.2f\n", i/100.00, j/100.00, k/100.00, l/100.00);
					}
				}
			}
		}
		pw.flush();
		pw.close(); 
	}

}
