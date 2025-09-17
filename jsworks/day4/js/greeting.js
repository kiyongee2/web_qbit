
let message = ["안녕하세요", "좋은 하루되세요!", "잘 지내니?"];
let msgIdx = 0;

greeting();

function greeting(){
  document.getElementById("greet").innerHTML = message[msgIdx];
  msgIdx++;
  if(msgIdx == message.length)
    msgIdx = 0;
  setTimeout(greeting, 2000);
}



