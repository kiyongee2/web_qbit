//구구단 전체

const result = document.getElementById("result");
/*
let output = "";

for (let i = 2; i <= 9; i++) {
  output += `<h3>${i}단</h3>`;
  for (let j = 1; j <= 9; j++) {
    output += `${i} x ${j} = ${i * j}<br>`;
  }
  output += "<br>";
}

result.innerHTML = output;
*/

let output = "";

for (let i = 2; i <= 9; i++) {
  output += "<div>"
  output += `<h3>${i}단</h3>`;
  for (let j = 1; j <= 9; j++) {
    output += `${i} x ${j} = ${i * j}<br>`;
  }
  output += "</div>";
}

result.innerHTML = output;

