//자료형 변환
//Number() 함수 사용
let numString = "123";
let convertedNumber = Number(numString); //문자열 -> 숫자
console.log(numString, convertedNumber); //123 123
console.log(typeof(numString), typeof(convertedNumber));

//String() 함수 사용
let strNumber = 456;
let convertedString = String(strNumber); //숫자 -> 문자열
console.log(strNumber, convertedString); //456 "456"
console.log(typeof(strNumber), typeof(convertedString));  

//toString() 메서드 사용
let num = 789;  
let str = num.toString(); //숫자 -> 문자열
console.log(num, str); //789 "789"
console.log(typeof(num), typeof(str)); //number string

//parseInt() 함수 사용
let floatString = "123.45"; 
let intNumber = parseInt(floatString); //문자열 -> 정수
console.log(floatString, intNumber); //123.45 123
console.log(typeof(floatString), typeof(intNumber)); //string number

//parseFloat() 함수 사용
let floatNumber = parseFloat(floatString); //문자열 -> 실수
console.log(floatString, floatNumber); //123.45 123.45
console.log(typeof(floatString), typeof(floatNumber)); //string number

//prompt() 함수로 입력받은 값은 항상 문자열임
let age = prompt("나이를 입력하세요:"); //string
console.log(age, typeof age); //string  

//나이를 숫자로 변환
//let numericAge = Number(age);
let numericAge = parseInt(age); //정수로 변환
console.log(numericAge, typeof numericAge); //number    

if(numericAge >= 20){
  console.log("성인입니다.");
} else {
  console.log("미성년자입니다.");
}   

//isNaN() 함수 사용
if(isNaN(numericAge)){ //NaN이면 true, 숫자이면 false
  console.log("숫자가 아닙니다.");    
} else {
  console.log("숫자입니다.");
}   

