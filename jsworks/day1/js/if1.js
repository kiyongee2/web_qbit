//짝수, 홀수 판별
const result = document.getElementById("result");

/*let num = 11;
if(num % 2 == 0){
    //console.log(num + "은(는) 짝수입니다.");
    result.textContent = `${num}은 짝수입니다.`;
} else {
    //console.log(num + "은(는) 홀수입니다.");
    result.textContent = `${num}은 홀수입니다.`;
} */

let num = prompt("숫자를 입력하세요.", "1");

if(num != null){
   num = parseInt(num); //문자열 -> 숫자 변환

  if(num % 2 == 0){
      result.textContent = `${num}는(은) 짝수입니다.`;
  } else {
      result.textContent = `${num}는(은) 홀수입니다.`;
  } 
}else{
    console.log("입력이 취소되었습니다.");
}
