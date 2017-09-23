import java.util.*;
import java.io.*;
class Main{
	static StringBuilder sb = new StringBuilder();
	static String first, second;
	public static void main(String[] args) throws IOException {
		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		String str;
		Stack<Character> s = new Stack<Character>();
		LinkedList<Boolean> curPath = new LinkedList<Boolean>();
		while((str = bin.readLine()) != null) {
			first = str;
			second = bin.readLine();
			sb.append("[\n");
			if(first.length() != second.length()) {
				sb.append("]\n");		
				continue;
			}
			int numPush, numPop, curIn, curOut;
			numPush = numPop = curIn = curOut = 0;
			boolean curOp = true;
			int length = first.length();
			path(s, curPath, curOp, curIn, curOut, numPush, numPop, length);
			s.clear();
			curPath.clear();
			sb.append("]\n");
			bout.write(sb.toString().getBytes());
			sb = new StringBuilder();
		}
		bout.flush();
		bout.close();
	}
	
	
	public static void path(Stack<Character> s, LinkedList<Boolean> curPath, boolean curOp, int curIn, int curOut, int numPush, int numPop, int length) throws IOException {
		curPath.push(curOp);
		if(curOp) {
			numPush++;
			s.push(first.charAt(curIn));
			curIn++;
		} else {
			if(s.isEmpty())	return;
			numPop++;
			char x = s.pop();
			if(x != second.charAt(curOut)) return;
			curOut++;
		}
		if(curPath.size() == 2*length) {
			while(!curPath.isEmpty()) {
				boolean x = curPath.pollLast();
				char a;
				if(x) {
					a = 'i';
				} else {
					a = 'o';
				}
				sb.append(a);
				if(curPath.size() != 0) sb.append(" ");
			}
			sb.append("\n");
		
		} else {
			if(numPush < length) {
				curOp = true;
				path((Stack<Character>)s.clone(), (LinkedList<Boolean>)curPath.clone(), curOp, curIn, curOut, numPush, numPop, length);
			} 
			if(numPop < length) {
				curOp = false;
				path((Stack<Character>)s.clone(), (LinkedList<Boolean>)curPath.clone(), curOp, curIn, curOut, numPush, numPop, length);
			}
		}
		
	}

}
