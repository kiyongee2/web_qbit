//arrayfunc.js
//배열의 요소 추가, 삭제
let arr = [1, 2, 3];

arr.push(4); //요소 추가(맨 뒤)
console.log(arr); //배열 출력(객체)

arr.pop();  //요소 삭제(맨 뒤)
console.log(arr)

for(let a in arr){  //배열 요소값 전체 출력
  console.log(arr[a]);
}

// 특정 요소 삽입 및 삭제
let animal = ['pig', 'chicken', 'dog', 'cat'];
document.write(animal + "<br>")

animal.splice(2, 2);

document.write(animal + "<br>");

//0번 인덱스에서 1개 삭제하고 'cow' 삽입
animal.splice(0, 1, 'cow');  

document.write(animal + "<br>");

//test
let a = [1, 3, 5, 7, 9]

let sum = 0;
for(let i=0; i<a.length; i++){
  sum += a[i];
}

a.push(sum);
console.log(a);