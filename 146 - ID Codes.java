import java.util.*;
import java.io.*;
class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str,res;
		res = "No Successor\n";
		while((str = bin.readLine()) != null) {
			if(str.equals("#")) break;
			String[] arr = str.split("");
			int firstIndex = 0;
			firstIndex = -1;
			int swap = 0;
			String temp;
			for(int i = arr.length-2; i >= 0; --i) {
				if(arr[i].compareTo(arr[i+1]) < 0) {
					firstIndex = i;
					break;
				}
			}
			if(firstIndex == -1) {
				bout.write(res.getBytes());
				continue;
			}
			for(int i = arr.length-1; i > firstIndex; --i) {
				if(arr[i].compareTo(arr[firstIndex]) > 0){
					swap = i;
					break;
				}
			}
			swap(arr, firstIndex, swap);
			swap = arr.length-1;
			firstIndex++;
			while(firstIndex < swap) {
				swap(arr, firstIndex++, swap--);
			}
			String r= "";
			for(int i = 0; i < arr.length; i++) {
				r += arr[i];
			}
			r += "\n";
			bout.write(r.getBytes());
			
		}
		bout.flush();
		bout.close();
	}
	
	public static void swap(String[] a, int k, int l) {
		String temp = a[k];
		a[k] = a[l];
		a[l] = temp;
	}
}
