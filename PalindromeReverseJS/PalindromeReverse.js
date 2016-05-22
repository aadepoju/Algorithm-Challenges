
var fs  = require("fs");
fs.readFileSync(process.argv[2]).toString().split('\n').forEach(function (line) {
    if (line != "") {
        //do something here
    	var count = 0;
    	var currString = line;
    	while(!isPalindrome(currString)){
    		count++;
    		
    		var revString = reverse(currString);
    		var val1 = Number(currString);
    		var val2 = Number(revString);
    		
    		currString = (val1 + val2).toString();
    	}
        console.log(count + " " + currString);
    	
    }
});

function isPalindrome(value){
	var first = 0, last = value.length - 1;
	while(first <= last){
		if(value.charAt(first) != value.charAt(last)){
			return false;
		}else{
			first++;
			last--;
		}
	}
	return true;
}

function reverse(myString) {
	var output = '';
	for (var i = myString.length - 1; i >= 0; i--)
	  output += myString[i];
	return output;
}