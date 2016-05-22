import java.io.*;
import java.util.*;

public class StringPermutations {
	
	static Set<String> permutations = new TreeSet<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File(args[0]);
		try{
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				//turning string into array of characters for ease of permutation with
				//recursion formula.
				char[] currWord = line.toCharArray();
				permutate(currWord, currWord.length);
				Iterator it = permutations.iterator();
             
				System.out.print(it.next());
				while(it.hasNext()){
					System.out.print("," + it.next());
				}
				System.out.println();
				permutations.clear();
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
	
	//generating permutations.
	public static void permutate(char[] word, int end){
		if(end == 1){
			permutations.add(new String(word));
			return;
		}
		for(int index = 0; index < end; index++){
			char curr = word[index];
			word[index] = word[end-1];
			word[end-1] = curr;
			permutate(word, end-1);
			curr = word[index];
			word[index] = word[end-1];
			word[end-1] = curr;
		}
	}

}
