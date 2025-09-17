//1~10 자연수 저장
let number = new Array(10);
for(var i=0; i<number.length; i++){
  number[i] = i+1;
  console.log(number[i])
}

//알파벳 대문자 저장
let alphabet = new Array(26);
let ch = 'A';
ch = ch.charCodeAt(0);  //65
//console.log(ch);
//console.log(String.fromCharCode(ch));

for(var i=0; i<alphabet.length; i++){
  alphabet[i] = ch;
  ch++;
}

/*for(var i=0; i<alphabet.length; i++){
  console.log(alphabet[i] + ", " + String.fromCharCode(alphabet[i]));
}*/

//2차원 배열
let numbers = [
  [1, 2, 3], 
  [4, 5, 6, 4]
]

console.log(numbers.length);
console.log(numbers[0].length);
console.log(numbers[1].length);

let sum = 0;
let count = 0;
for(let i=0; i<numbers.length; i++){
  for(let j=0; j<numbers[i].length; j++){
    sum += numbers[i][j]
    count++;
    //console.log(numbers[i][j]);
  }
}
let avg = sum / count;
console.log(sum, avg.toFixed(2));
document.write(sum + "<br>", avg.toFixed(2));
