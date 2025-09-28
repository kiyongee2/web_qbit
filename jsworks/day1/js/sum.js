
const result = document.getElementById("result");

let num = prompt("몇까지의 합을 계산할까요?", "1");
let sum = 0;

num = parseInt(num);
for(var i = 1; i <= num; i++){
  sum += num;
}
result.textContent = `1부터 ${num}까지의 합은 ${sum}입니다.`;

