import java.util.*;
import java.io.*;
class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		ArrayList<Stack<Character>> list = new ArrayList<Stack<Character>>();
		String str, res;
		int caseNum = 1;
		while(!(str = bin.readLine()).equals("end")) {
			char[] arr = str.toCharArray();
			list.add(new Stack<Character>());
			list.get(0).push(arr[0]);
			boolean added;
			for(int i = 1; i < arr.length; i++) {
				added = false;
				for(int j = 0; j < list.size(); j++) {
					if(arr[i] <= list.get(j).peek()) { 
						list.get(j).push(arr[i]);
						added = true;
						break;
					} 
				}
				if(!added) {
					list.add(new Stack<Character>());
					list.get(list.size()-1).push(arr[i]);
				}
			}
			res = "Case " + caseNum + ": " + list.size() + "\n";
			bout.write(res.getBytes());
			list.clear();
			caseNum++;
		}
		bout.flush();
		bout.close();
	}

}
