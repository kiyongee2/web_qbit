//return이 있는 함수

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

//객체에 접근
let result = document.getElementById("result")
let result2 = document.getElementById("result2");

let num = square(4);
result.innerHTML = "4의 제곱: " + num;

let val = myAbs(-10);
result.innerHTML = "-10의 절대값: " + val;

