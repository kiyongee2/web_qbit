
const display = document.getElementById("display");

//1초 간격으로 myWatch 호출
/*const watch = setInterval(myWatch, 1000); 

function myWatch(){
  const date = new Date();
  let time = date.toLocaleTimeString();
  display.textContent = time;
}*/

//실행 함수
setInterval(() => {
  const date = new Date();
  let time = date.toLocaleTimeString();
  display.textContent = time;
},1000);


