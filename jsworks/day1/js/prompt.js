// var yourName = prompt("이름을 입력하세요", '아무개');
// document.write(yourName);

let num = prompt("숫자를 입력하세요", '1');
// num = parseInt(num) + 10;
// document.write(num);

// 짝수/홀수 판별
let result = (parseInt(num) % 2 == 0) ? '짝수' : '홀수';
document.write(result);