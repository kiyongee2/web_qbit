//구구단 출력
const result = document.getElementById("result");
const dan = 7;

result.innerHTML = `<h3>${dan}단</h3>`
for(var i=1; i<=9; i++){
  result.innerHTML += `${dan} x ${i} = ${dan * i}<br>`;
} 

/*
const result = document.getElementById("result");
let dan = prompt("단 입력:", '1');

if(dan === null || isNaN(dan)){ //취소 버튼 클릭시
  result.textContent = `유효한 숫자가 아닙니다.`;
}else{
  dan = parseInt(dan);

  result.innerHTML = `<h3>${dan}단</h3>`
  for(var i=1; i<=9; i++){
    //console.log(`${dan} x ${i} = ${dan * i}`);
    result.innerHTML += `${dan} x ${i} = ${dan * i}<br>`;
  } 
}*/
