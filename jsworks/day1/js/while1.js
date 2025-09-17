//1부터 10까지 더하기
let i = 0;
let sum = 0;
while(true){
  i += 1;
  if(i > 10)
    break;
  sum += i;
  console.log(i)
}
console.log("합계:", sum);

//키 반복
/*while(true){
  let key = prompt("계속할까요?", 'y/n');
  if(key == 'y'){
    //console.log("반복합니다.");
    alert("반복합니다.");
  }else if(key == 'n'){
    //console.log("반복을 중단합니다.");
    alert("중단합니다.");
    break;
  }else{
    console.log("잘못된 입력입니다.")
  }
}
console.log("프로그램 종료")*/