//익명함수
let greeting = function(){
  document.getElementById("result").innerText = "안녕하세요~";
}

let greeting2 = function(name){
  document.getElementById("result2").innerText = "안녕~ " + name;
}

greeting(); //호출

greeting2("선화");


