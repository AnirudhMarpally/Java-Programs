package hackerRankprograms;

import java.util.*; 

class GroupAnagrams 
{ 
	public static void main(String[] args) 
	{ 
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String strs[] = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = scanner.next();
		}
		

		List<List<String> > answer = groupAnagrams(strs); 
		for(int i=0; i<answer.size(); i++) 
		{ 
			System.out.print("["); 
			for(int j=0; j<answer.get(i).size(); j++) 
			{ 
				System.out.print(answer.get(i).get(j)); 
				if(j!=answer.get(i).size()-1) 
					System.out.print(", "); 
			} 
			System.out.print("]"); 
			System.out.println(); 
		}
		scanner.close();
	}

	static List<List<String> > groupAnagrams(String strs[]) 
	{ 
		// To store all the anagrams together 
		List<List<String> > answer = new ArrayList<>(); 

		// To keep a track if the string is 
		// already added in the answer 
		HashMap<String, Integer> map = new HashMap<>(); 

		for(int i=0; i<strs.length; i++) 
		{ 
			// Get the char array from the string 
			char c[] = strs[i].toCharArray(); 

			// Sort the char array 
			Arrays.sort(c); 

			// Convert the sorted char array 
			// to the new string 
			String s = new String(c); 

			// Check if the string is already 
			// added in the answer 
			if(map.containsKey(s)) 
			{ 
				// If already added then get the 
				// index and add the new string 
				// in the list at that index 
				int index = map.get(s); 
				answer.get(index).add(strs[i]); 
			} 

			// If not added then add a new list 
			// and add the string in the newly 
			// created list and add it to the answer 
			// and add the index of the newly 
			// created list in the hashmap 
			else
			{ 
				List<String> temp = new ArrayList<>(); 
				temp.add(strs[i]); 
				answer.add(temp); 
				int index = answer.size()-1; 
				map.put(s, index); 
			} 
		} 
		return answer; 
	}
}