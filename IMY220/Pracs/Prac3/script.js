//Carl de Witt U21444928
function FactorialChecker() {}

FactorialChecker.prototype.printFactorial = function(num){
    var result = num;
    if (num === 0 || num === 1) 
        return 1; 
    while (num > 1) { 
        num--;
        result *= num;
    }
    return result;
}


FactorialChecker.prototype.fillArray = function(num){
    num = parseInt(num);
        var sum = 1;
       var output = "[";
       var i = 1;

       if(num == 1){
        return `[1]`;
       }

       while(sum < num){
        output += i + ",";
        sum = sum * i;
        i++;
       }  
       if(sum != num){
            return "This is not a factorial";
       }else {
            return output.substring(0 ,output.length -1) + "]";  
       }
}
/*-----------------Task1.1-------------------------*/

const fc = new FactorialChecker()

const factorialButton = document.getElementById("GenerateFactorial");

factorialButton.onclick = function(){
    document.getElementById("FactorialResult").innerHTML = fc.printFactorial(document.getElementById("FactorialValue").value);
}

/*-----------------Task1.2-------------------------*/

const unfactorialButton = document.getElementById("GenerateFactorialList");

unfactorialButton.onclick = function(){
    document.getElementById("FactorialListResult").innerHTML = fc.fillArray(document.getElementById("FactorialInput").value);
}


/*----------------Task2-----------------------*/
const pigBtn = document.getElementById("PigLatinEncrypt");

pigBtn.onclick = function(){
    document.getElementById("PigLatinResult").innerHTML = PigLatinEncrypt(document.getElementById("SentenceToConvert").value);
}


function PigLatinEncrypt(str){
    str = str.toLowerCase();
    regexPattern = /^[aeiou]/;
    regexPattern2 = /[aeiou]/;
    result = regexPattern.test(str);
    if(result){
        console.log("threre is a vowel at the begining")
        return str + "way";
    }else{
        result = regexPattern2.test(str);
        if(result){
            var letter = str.substring(0,1);
            str = str.substring(1, str.length);
            return str + letter + "ay";
            
        }else{
            return str + "ay";
        }
    }
}