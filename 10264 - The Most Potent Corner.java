import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		while((str = bin.readLine()) != null) {
			int dim = Integer.parseInt(str);
			int[] weights = new int[1 << dim];
			int potencies[] = new int[weights.length];
			int maxPotency = -1;
			for(int i = 0; i < weights.length; i++) {
				weights[i] = Integer.parseInt(bin.readLine());
			}
			int v = 0;
			while(v < (1 << dim)) {
				int temp = 0;
				for(int j = 0; j < dim; j++) {
					v ^= (1 << j);
					temp += weights[v];
					v^= (1 << j);
				}
				potencies[v] = temp;
				v++;
				
			}
			v = 0;
			while(v < (1 << dim)) {
				int temp = potencies[v];
				for(int j = 0; j < dim; j++) {
					v ^= (1 << j);
					temp += potencies[v];
					if(temp > maxPotency) maxPotency = temp;
					temp -= potencies[v];
					v^= (1 << j);
				}
				v++;
			}
			bout.write(Integer.valueOf(maxPotency).toString().getBytes());
			String newline = "\n";
			bout.write(newline.getBytes());
		}
		bout.flush();
		bout.close();
		
	}

}
