//return이 있는 함수

//객체에 접근
let result = document.getElementById("result")
let result2 = document.getElementById("result2");
let display = document.querySelector(".display");

//제곱수 계산 함수
function square(x){
  return x * x;
}

//절대값 계산 함수
function myAbs(n){
  if(n < 0)
    return -n;
  else
    return n;
}

//메시지 출력
function showMessage(){
  return display.innerHTML = "<em>Good Luck!!</em>";
}

//함수 호출
let num = square(4);
result.textContent = "4의 제곱: " + num;

let val = myAbs(-10);
result2.textContent = "-10의 절대값: " + val;



