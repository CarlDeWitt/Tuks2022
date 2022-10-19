//carl de Witt u21444928
class FactorialChecker
{
	constructor(){}

	printFactorial = (num) =>  
	{	
		let i=1;
		let fact =1;
		for (; i <= num; i++) 
		{
			fact *= i;
		}
		return `The factorial value of ${num} is ${fact}`;	

	}//end function

	fillArray = (num) =>
	{
		let start=num;
		let init=1
		let i=1;
		const arr = [];
		let fac=true;
		while (true){
			init = init*i; 
		  	if (init%2==0 || init==1){        
				if(init>start){
				  	fac=false;
					break;
			  	}
			arr.push(i);
			i++; 
			if(init==start)
				break; 
		  }
		}
		return (fac) ? `The values that make up the factorial ${num}: ${arr}` : `This is not a factorial`;
	}//end function

}//end FactorialChecer

PigLatinEncrypt = (str) =>
{
	const regexPattern = /^[aeiou]/;
	const regexPattern2 = /[aeiou]/;
    str = str.toLowerCase();
    result = regexPattern.test(str);
    if(result){
        return `The result when converting ${str} to pig latin is: ${str}way`;
    }else{
        result = regexPattern2.test(str);
        if(result){
            let letter = str.substring(0,1);
            str = str.substring(1, str.length);
            return `The result when converting ${str} to pig latin is: ${str}${letter}ay`;
            
        }else{
            return `The result when converting ${str} to pig latin is: ${str}ay`;
        }
    }
}

checkUniqueLetters = (str) =>{	
	const letters = [...str];
	const newarr= []
	letters.reduce((old,current)=>{
		if(!newarr.includes(current)){
			newarr.push(current);
		}
	},0);
	return `The word ${str} has ${newarr.length} unique letters`;
}



const checker = new FactorialChecker();

document.getElementById("GenerateFactorial").onclick = function()
{
	document.getElementById("FactorialResult").innerHTML = checker.printFactorial(document.getElementById("FactorialValue").value);
}

document.getElementById("GenerateFactorialList").onclick = function()
{
	document.getElementById("FactorialListResult").innerHTML = checker.fillArray(document.getElementById("FactorialInput").value);
}

document.getElementById("PigLatinEncrypt").onclick = function()
{
	document.getElementById("PigLatinResult").innerHTML = PigLatinEncrypt(document.getElementById("SentenceToConvert").value);
}

document.getElementById("checkRecurringChars").onclick = function()
{
	document.getElementById("recurringCharsResult").innerHTML = checkUniqueLetters(document.getElementById("charChecker").value);
}