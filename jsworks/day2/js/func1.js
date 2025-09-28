
//function 함수이름(){}

let result1 = document.getElementById("result");
let result2 = document.getElementById("result2");

//함수 정의
function sayHello(){
  result.innerHTML = "안녕~";
}

function sayHello2(name){
  result2.innerHTML = `안녕~ ${name}`;
}

//호출
sayHello();

sayHello2("영우");
sayHello2("Elsa")

//구구단
function gugudan(x){ //x는 매개변수
  for(let i = 1; i <= 9; i++){
    console.log(`${x} x ${i} = ${x*i}`);
  }
}

gugudan(6);