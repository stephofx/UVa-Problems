import java.util.*;

import java.io.*;
class Main {

	
	public static void main(String args[]) throws IOException{
		

		BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedOutputStream bout = new BufferedOutputStream(System.out);
		
		String str;
		
		StringTokenizer st;

		final int MOVEMENT_TIME = 2;
		
		final int SUCCESS_UNLOAD = 1;
		
		final int SUCCESS_LOAD = 1;
		
		int sets = Integer.parseInt(bin.readLine());
		
		while(--sets != -1) {
			
			ArrayList<LinkedList> stations = new ArrayList<LinkedList>(102);
			
			Stack<Integer> cargoStack = new Stack<Integer>();
			
			int totalTime = 0;
			
			st = new StringTokenizer(bin.readLine());
			
			int nStations = Integer.parseInt(st.nextToken());
			
			int carrierCapacity = Integer.parseInt(st.nextToken());
			
			int maxQueueB = Integer.parseInt(st.nextToken()); 
			
			BitSet bs = new BitSet(nStations);
			
			boolean initial = true;
			
			while(bs.cardinality() != nStations || (!cargoStack.isEmpty() && !initial) ) {
				
				for(int i = 1; i <= nStations; i++) { 
					
				if(initial) {
						
				st = new StringTokenizer(bin.readLine());
						
				int numCargo = Integer.parseInt(st.nextToken());
						
				LinkedList<Integer> list = new LinkedList<Integer>();
						
				while(--numCargo != -1) list.add(Integer.parseInt(st.nextToken()));
						
				stations.add(list);
					
			}
					
			while(!cargoStack.isEmpty() &&  (stations.get(i-1).size() < maxQueueB || cargoStack.peek() == i)) {
						
				if(cargoStack.peek() == i) {
							
					cargoStack.pop();
							
					totalTime += SUCCESS_UNLOAD;
						
				} else  {
							
					stations.get(i-1).add(cargoStack.pop());
							
					totalTime += SUCCESS_UNLOAD;
						
				}
				
					
			}
					
			while(!stations.get(i-1).isEmpty() &&  cargoStack.size() < carrierCapacity) {
						
				cargoStack.push((Integer) stations.get(i-1).pop());
						
				totalTime += SUCCESS_LOAD;
					
			}
					
			if(stations.get(i-1).isEmpty()) bs.set(i-1);
					
			else bs.set(i-1, false);
					
			if(bs.cardinality() == nStations && cargoStack.isEmpty()) break;
				
			totalTime += MOVEMENT_TIME;

			}
				
			initial = false;
			
		}
			
		String res = totalTime + "\n";
			
		bout.write(res.getBytes());
		
	 }
		
	bout.flush();
	
	bout.close();
	
	}

}	
			
