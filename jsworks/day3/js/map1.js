
const numbers = [4, 9, 16, 25];

//제곱근 계산 - Math.sqrt() 호출
const numbers2 = numbers.map(Math.sqrt);
console.log(numbers2)

//p태그에 넣기
document.getElementById("sqrt").innerHTML = numbers2;

//배수 계산 - MyFunction() 호출
const newNumbers = numbers.map(MyFunction);

//수를 입력받아 2의 배수를 반환함
function MyFunction(num){
  return num * 2;
}

console.log(newNumbers);

