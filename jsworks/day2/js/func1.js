//function 함수이름(){}

let result1 = document.getElementById("result");
let result2 = document.getElementById("result2");

//함수 정의
function sayHello(){
  result.innerTEXT = "안녕~";
}

function sayHello2(name){
  result2.innerTEXT = `안녕~ ${name}`;
}

//호출
sayHello();

sayHello2("영우");
sayHello2("Elsa")

//구구단
let display = document.querySelector(".display")
display.innerHTML = "<br>";

function gugudan(x){ //x는 매개변수
  for(let i = 1; i <= 9; i++){
    display.innerHTML += `${x} x ${i} = ${x*i}<br>`
  }
}
