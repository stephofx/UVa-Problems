import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		StringTokenizer st;
		int t = Integer.parseInt(bin.readLine());
		while(--t != -1) {
			int databaseSize = Integer.parseInt(bin.readLine());
			maker[] list = new maker[databaseSize];
			for(int i = 0; i < list.length; i++) {
				st = new StringTokenizer(bin.readLine());
				list[i] = new maker(st.nextToken(), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			int[] queries = new int[Integer.parseInt(bin.readLine())];
			for(int j = 0; j < queries.length; j++) {
				queries[j] = Integer.parseInt(bin.readLine());
			}
			String res = "";
			for(int k = 0; k < queries.length; k++) {
				boolean onlyOne = false;
				for(int l = 0; l < list.length; l++) {
					if(queries[k] <= list[l].high && queries[k] >= list[l].low && !onlyOne) {
						res = list[l].name + "\n";
						onlyOne = true;
					} else if(queries[k] <= list[l].high && queries[k] >= list[l].low && onlyOne) {
						onlyOne = false;
						res = "UNDETERMINED\n";
						break;
					}
				}
				if(!onlyOne) {
					res = "UNDETERMINED\n";
				}
				bout.write(res.getBytes());
			}
			if(t != 0){
				res = "\n";
				bout.write(res.getBytes());
			}
		}
		bout.flush();
		bout.close();
	}

}

class maker{
	public String name;
	public int low;
	public int high;
	
	public maker(String n, int l, int h) {
		name = n;
		low = l;
		high = h;
	}
}
