//무한 반복

/*while(true){
  console.log("반복합니다.");
}*/

/*let i = 0;
while(true){
  i += 1;
  if (i > 10)
    break;
  console.log(i);
}
console.log("i:", i); //11*/

//1부터 10까지 더하기
/*let i = 0;
let sum = 0; //합계 초기화
while(true){
  i += 1;
  if(i > 10)
    break;
  sum += i;
  console.log(i)
}
console.log("합계:", sum);*/

//키 반복
while(true){
  let key = prompt("계속할까요?", 'y/n');
  if(key == 'y' || key == 'Y'){
    alert("반복합니다.");
  }else if(key == 'n' || key == 'N'){
    alert("중단합니다.");
    break;
  }else{
    alert("잘못된 입력입니다.")
  }
}
console.log("프로그램 종료")

