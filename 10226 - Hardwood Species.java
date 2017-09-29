import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		DecimalFormat df = new DecimalFormat("0.0000");
		int n = Integer.parseInt(bin.readLine());
		bin.readLine();
		String str, res;
		while(--n != -1) {
			Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
			int total = 0;
			str = bin.readLine();
			while(str != null && !str.equals("")) {
				if(ht.containsKey(str)) ht.put(str, ht.get(str)+1);
				else ht.put(str, 1);
				total++;
				str = bin.readLine();
			}
			List<String> tmp = Collections.list(ht.keys());
			Collections.sort(tmp);
			Iterator<String> it = tmp.iterator();
			while(it.hasNext()) {
				String cur = it.next();
				int appearances = ht.get(cur);
				double percent = (double)appearances*100/total;
				res = cur + " " + df.format(percent) + "\n";
				bout.write(res.getBytes());
			}
			if(n != 0) {
				res = "\n";
				bout.write(res.getBytes());
			}
		}
		bout.flush();
		bout.close();
	}

}
