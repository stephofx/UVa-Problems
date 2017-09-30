import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str = bin.readLine();
		int n;
		TreeMap<String, Integer> tm;
		TreeSet<Integer> ts;
		StringTokenizer st;
		
		while((n = Integer.parseInt(str)) != 0) {
			tm = new TreeMap<String, Integer>();
			int max = 1;
			for(int i = 0; i < n; i++) {
				ts = new TreeSet<Integer>();
				st = new StringTokenizer(bin.readLine());
				for(int j = 0; j < 5; j++) {
					ts.add(Integer.parseInt(st.nextToken()));
				}
				if(tm.containsKey(ts.toString())){
					int val = tm.get(ts.toString());
					tm.put(ts.toString(), val+1);
					if(val+1 > max) max = val+1; 
				}
				else tm.put(ts.toString(), 1);
			}
			Collection<Integer> c = tm.values();
			Iterator it = c.iterator();
			boolean first = true;
			int sum = max;
			while(it.hasNext()) { //if values are same for two combos, both are equally as popular; must add together in total.
				int next = (int)it.next();
				if(next == max && !first) {
					sum += next;
				} else if(first && next == max) {
					first = false;
					continue;
				}
			}
			String res = sum + "\n";
			bout.write(res.getBytes());
			str = bin.readLine();
		}
		bout.flush();
		bout.close();
	}

}
