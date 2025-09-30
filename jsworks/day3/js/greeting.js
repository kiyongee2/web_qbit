// greeting.js
// 2초마다 인사말 변경
let message = ["안녕~", "잘 지내니?", "좋은 하루!", ];
let msgIdx = 0;
const greet = document.getElementById("greet");

// 2초마다 인사말 변경
setInterval(() => {
  greet.textContent = message[msgIdx];
  msgIdx = (msgIdx + 1) % message.length; // 순환
}, 2000);


// 최초 1회 호출
//greeting(); 
/*
function greeting(){
  document.getElementById("greet").innerHTML = message[msgIdx];
  msgIdx++;
  if(msgIdx == message.length)
    msgIdx = 0;

  setTimeout(greeting, 2000); // 2초마다 greeting 함수 호출
}
*/

