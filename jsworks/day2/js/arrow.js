//화살표 함수
//객체에 접근
let total = document.querySelector(".total");

const greeting = () => {
  document.getElementById("result").innerText = "안녕하세요~";
}

const greeting2 = (name) => {
  document.getElementById("result2").innerText = `안녕~ ${name}`;
}

//덧셈 함수 
const add = (x, y) => {  
  return x + y;
};

//add()를 호출
const showAdd = (a, b) => {
  total.textContent = `덧셈 결과: ${add(a, b)}`
}

//함수 호출
greeting();
greeting2("상진");



