import java.util.HashMap;

public class NonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNonRepeatedChar("noon"));
		System.out.println(findNonRepeatedChar("moo"));
		System.out.println(findNonRepeatedChar("f0fi"));
		System.out.println(findNonRepeatedChar("\0"));
		System.out.println(findNonRepeatedChar("SleepOrSleep"));
		

	}
	
	//Solution using a Map
	public static char findNonRepeatedChar(String s){
		if(s.length() < 1){
			return '\0';
		}
		HashMap<Character, Integer> charOccurences = new HashMap<>();
		char currLetter;
		for(int i = 0; i < s.length(); i++){
			currLetter = s.charAt(i);
			if(!charOccurences.containsKey(currLetter)){
				charOccurences.put(currLetter, 1);
			}else{
				charOccurences.put(currLetter, charOccurences.get(currLetter) + 1);
			}
			
		}
		char repeatedChar = '\0';
		for(int j = 0; j < s.length(); j++){
			if(charOccurences.get(s.charAt(j)) == 1){
				repeatedChar = s.charAt(j);
				break;
			}
		}
		return repeatedChar;
	}

}
