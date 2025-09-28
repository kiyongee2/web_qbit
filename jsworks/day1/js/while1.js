
//while 문
//1. while(조건식) { ... }
//2. while(true) { ... breaj; }

//1~10까지 출력
let i = 0;  
while(i < 10){
  i++; 
  console.log(i);
}
console.log("i =", i); //10

//1~10까지 짝수 출력
let j = 0;  
while(j < 10){
  j++;
  if(j % 2 == 0)
    console.log(j);
}
console.log("j =", j); //10

//1~5까지 더하기
let k = 0;
let total = 0;
while(k < 5){
  k++;
  total += k;
  console.log(`k=${k}, total=${total}`)
}
console.log("total =", total); //15
