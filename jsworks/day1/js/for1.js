/*let sum = 0;
for(var i=1; i<=10; i++){
  sum += i;
  console.log(i);
}
console.log(sum);*/

/*let facto = 1;
let i = 0;
for(i = 1; i<=5; i++){
  facto *= i;
  console.log(i, facto);
}
console.log((i-1) + "!=" + facto);*/

//구구단 출력
while(true){
  let dan = prompt("단 입력:", '1');

  if(dan == null){
    alert("입력이 취소되었습니다.");
    break;
  }else if(isNaN(dan)){
    alert("올바른 수를 입력하세요")
  }else{
    dan = parseInt(dan);
    document.write(dan + "단<br>")
    for(var i=1; i<=9; i++){
      //console.log(dan + "x" + i + "=" + (dan*i));
      document.write(dan + "x" + i + "=" + (dan*i) + '<br>');
    } 
    break; 
  }
}

