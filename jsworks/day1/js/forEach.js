//forEach.js

//배열.forEach(함수) : 배열의 요소를 하나씩 꺼내서 함수에 전달하면서 함수 실행
//함수는 콜백함수(Callback function) : 나중에 불려지는 함수
//배열.forEach(function(value, index, array){})
//value : 배열 요소값, index : 배열 인덱스, array : 배열 자체

const result = document.getElementById('result');
result.innerHTML = '';  
const students = ['Hwang', 'Choi', 'Lee', 'Park'];

//출력
students.forEach(function(student, index, array){
  console.log(`${index+1}. ${student}`);
  result.innerHTML += `${index+1}. ${student} <br>`;
});

//합계
const arr = [10, 20, 30, 40, 50];
let sum = 0;

arr.forEach(value => {
  sum += value;
});
console.log('합계 : ' + sum);  
result.innerHTML += `합계 : ${sum} <br>`;
