//화살표 함수
let greeting = () => {
  document.getElementById("result").innerHTML = "안녕하세요~";
}

let greeting2 = (name) => {
  document.getElementById("result2").innerHTML = `안녕~ ${name}`;
}

greeting();
greeting2("상진");

