// myfunc.js

function calcAge(){
  const CURRENT_YEAR = 2023;
  let birthYear = prompt("태어난해 입력:", 'YYYY');
  let age = CURRENT_YEAR - birthYear;
  document.getElementById("demo").innerHTML = 
      "당신의 나이는 " + age + "세 입니다.";
}