//문자를 저장할 배열 선언
let result = document.getElementById("result");
let arr = ['사과', '배', '포도', '바나나'];
console.log(arr.length); //5

//배열 요소 출력
for(let i=0; i<arr.length; i++){
  console.log(arr[i]); //사과, 배, 포도, 바나나
  //result.innerHTML = result.innerHTML + arr[i];
  //result.innerHTML += (arr[i] + " ");
  result.innerHTML += arr[i] + (i<arr.length-1 ? ", " : ""); 
}

//향상된 for문(배열 요소를 순차적으로 접근)
//for(변수 of 배열){}
for(let item of arr){ //let 생략 가능
  console.log(item);
}

//배열 요소 추가
arr[4] = '딸기'; //5번째 요소 추가

//배열 요소 추가2
arr.push('망고'); //마지막 요소로 추가
console.log(arr);

result.innerHTML += `<br>배열 요소 추가 후 : ${arr}`;

//배열 요소 삭제
arr[1] = undefined; //2번째 요소 삭제
console.log(arr); //['사과', undefined, '포도', '바나나', '딸기']
console.log(arr.length); //5

//배열 요소 삭제2
arr.splice(1, 1); //2번째 요소부터 1개 삭제
console.log(arr); //['사과', '포도', '바나나', '딸기']
console.log(arr.length); //4  
//result.innerHTML += "<br>배열 요소 삭제 후 : " + arr; 
result.innerHTML += `<br>배열 요소 삭제 후 : ${arr}`; 

//배열 요소 수정
arr[2] = '키위'; //3번째 요소 수정
console.log(arr);
result.innerHTML += `<br>배열 요소 수정 후 : ${arr}`;

//배열 요소 수정2
arr.splice(2, 1, '수박'); //3번째 요소부터 1개를 '수박'으로 수정
console.log(arr);
result.innerHTML += `<br>배열 요소 수정2 후 : ${arr}`;  


