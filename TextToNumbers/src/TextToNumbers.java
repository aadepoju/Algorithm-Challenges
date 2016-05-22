import java.util.*;
import java.io.*;
public class TextToNumbers {
	static HashMap<String, Integer> mapper;
	static String[] dict = {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen",
			"fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety",
			"hundred","thousand","million"};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//populating the map dictionary. 
		mapper = new HashMap<>();
		populateMap();
		
		File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
        	
            line = line.trim();
            // Process line of input Here
            String[] text = line.split(" ");
            int number = getNumValue(text);
            System.out.println(number);
        }
	}
	
	//This method is built to populate the word to number mapper. 
	public static void populateMap(){
		mapper.put("negative", -1);
		int i = 0;
		for(; i < 21; i++){
			mapper.put(dict[i], i);
		}
		int counter = 30;
		for(; i < dict.length; i++){
			if(dict[i].equals("thousand")){
				mapper.put(dict[i], 1000);
				continue;
			}else if(dict[i].equals("million")){
				mapper.put(dict[i], 1000000);
				continue;
			}else{
				mapper.put(dict[i], counter);
				counter += 10;
			}
		}
	}
	
	
	public static int getNumValue(String[] input){
		boolean isNeg = false;
		int sol = 0;
		int index1 = 0;
		if(input[0].equals("negative")){
        	isNeg = true;
        	index1++;
        }
		//temp variable to store values up to hundred's place.
		int val = 0;
		while(index1 < input.length){
			//if approached a multiplier that's a thousand or million
			//then add the temp value (val) to the solution
			if(input[index1].endsWith("and") || input[index1].endsWith("ion")){
				//multiply the temp value you have so far by the multiplier before
				//adding to solution.
				val *= mapper.get(input[index1]);
				sol += val;
				val = 0;
				index1++;
			}else if(input[index1].endsWith("ed")){
				//if you approach a multiplier that's a hundred
				//then multiply temp value by it, but don't add it to 
				//solution yet, since you can still run into bigger multipliers. 
				val *= mapper.get(input[index1]);
				index1++;
			}else{
				//just add non-multiplier values to solution. 
				val += mapper.get(input[index1]);
				index1++;
			}
		}
		//any remainder hundreds or lower values not stored to solution is added here.
		sol += val;

		return isNeg? (sol * -1) : sol;
	}

}
