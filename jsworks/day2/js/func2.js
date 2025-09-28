//익명함수
let greeting = function(){
  console.log("안녕하세요~");
  document.getElementById("result").innerHTML = "안녕하세요~";
}

let greeting2 = function(name){
  document.getElementById("result2").innerHTML = "안녕~ " + name;
}

greeting(); //호출
greeting2("선화");

