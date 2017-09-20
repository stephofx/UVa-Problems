import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		boolean atBack;
		LinkedList<String> line = new LinkedList<String>();;
		while((str = bin.readLine()) != null) {
			String[] arr = str.split("");
			atBack = true;
			int pos = 0;
			for(String x: arr) {
				String nextChar = x;
				if(nextChar.equals("[")) {
					atBack = false;
					pos = 0;
					continue;
				}
				else if(nextChar.equals("]")) {
					atBack = true;
					continue;
				}
				if(atBack) {
					line.add(nextChar);
				} else {
					line.add(pos, nextChar);
					pos++;
				}
			}
			String res = line.toString();
			res = res.replaceAll(", ", "");
			res = res.replace("[", "");
			res = res.replace("]", "");
			res += "\n";
			bout.write(res.getBytes());
			line.clear();
		}
		bout.flush();
		bout.close();
	}

}
