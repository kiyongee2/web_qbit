
//비교 연산자
console.log(10 > 5); //true
console.log(10 < 5); //false
console.log(10 >= 5); //true
console.log(10 <= 5); //false
console.log(10 == 5); //false
console.log(10 != 5); //true
console.log(10 == '10'); //true (값만 비교)
console.log(10 === '10'); //false (값과 타입 모두 비교)
console.log(10 !== '10'); //true (값과 타입 모두 비교)    

//논리 연산자
let a = 10;
console.log(a > 5 && a < 15); //true (AND)
console.log(a > 5 && a > 15); //false
console.log(a > 5 || a > 15); //true (OR)
console.log(a < 5 || a > 15); //false
console.log(!(a > 5)); //false (NOT)
console.log(!(a < 5)); //true (NOT)

//조건(삼항) 연산자
let age = 20;
let result = (age >= 18) ? "성인" : "미성년자";
//console.log("age = " + age + ", result = " + result); // age = 20, result = 성인
console.log(`age = ${age}, result = ${result}`); // age = 20, result = 성인

let result2 = (age < 13) ? "어린이" : (age < 20) ? "청소년" : "성인";
console.log(`age = ${age}, result2 = ${result2}`); // age = 20, result2 = 성인

//논리 연산자와 조건 연산자 활용
let score = 85;
let grade = (score >= 90) ? 'A' : (score >= 80) ? 'B' : (score >= 70) ? 'C' : (score >= 60) ? "D" : "F";
console.log(`score = ${score}, grade = ${grade}`); // score = 85, grade = B

//짝수/홀수 판별
// let number = 7;
let number = prompt("숫자를 입력하세요:");
//number = Number(number); //문자열 -> 숫자 변환
number = parseInt(number); //문자열 -> 숫자 변환

let type = (number % 2 == 0) ? "짝수입니다." : "홀수입니다.";
console.log(`number = ${number}, type = ${type}`); // number = 7, type = 홀수