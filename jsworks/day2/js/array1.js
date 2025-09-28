
//Array1
let result = document.getElementById("result");
let arr = new Array(5); //길이가 5인 배열 생성
console.log(arr.length);  //5
for(let i=0; i<arr.length; i++){
  arr[i] = (i+1) * 10;
  result.innerHTML += arr[i] + " ";
} //10, 20, 30, 40, 50

//Array2
//1~10 자연수 저장
let result2 = document.getElementById("result2");
let number = new Array(10); //길이가 10인 배열 생성
for(let i=0; i<number.length; i++){
  number[i] = i+1;
  console.log(number[i])
  result2.innerHTML += number[i] + (i<number.length-1 ? ", " : "");
} //1, 2, 3, ..., 10

//알파벳 대문자 저장      
let alphabet = new Array(26); //길이가 26인 배열 생성
let ch = 'A'; //A의 아스키코드값 65
ch = ch.charCodeAt(0);  //65
//console.log(ch); //65
//console.log(String.fromCharCode(ch)); //A //아스키코드값 65에 해당하는 문자

for(let i=0; i<alphabet.length; i++){
  alphabet[i] = ch; //65, 66, 67, ..., 90
  ch++;
} //A~Z까지 아스키코드값 저장

for(let i=0; i<alphabet.length; i++){
  console.log(alphabet[i] + ", " + String.fromCharCode(alphabet[i]));
} //65, A 66, B 67, C ... 90, Z



