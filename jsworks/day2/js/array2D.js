
//이차원 배열
const result = document.getElementById("result");
const result2 = document.getElementById("result2"); 
let arr = [
  [1, 2, 3],
  [4, 5, 6]
];  
console.log(arr.length); //2
console.log(arr[0].length); //3 //0번 인덱스의 길이
console.log(arr[1].length); //3 //1번 인덱스의 길이   
//배열 요소 출력
for(let i=0; i<arr.length; i++){  //행
  for(let j=0; j<arr[i].length; j++){ //열    
    console.log(arr[i][j]);
    result.innerHTML += arr[i][j] + " "; 
    //result.innerHTML += arr[i][j] + (j<arr[i].length-1 ? ", " : ""); 
  }
  result.innerHTML += "<br>";
} //1, 2, 3<br>4, 5, 6<br>

//배열 요소 출력(향상된 for문)  
/*for(let row of arr){  //행
  for(let col of row){ //열    
    console.log(col);
    // result.innerHTML += col + (col<row.length ? ", " : "");
    result.innerHTML += col + (col<row[row.length-1] ? ", " : "");
  }   
  result.innerHTML += "<br>";
} //1, 2, 3<br>4, 5, 6<br>*/

//2행 5열 이차원 배열 생성 
let number = new Array(2); //길이가 2인 배열 생성
for(let i=0; i<number.length; i++){
  number[i] = new Array(5); //각 요소에 길이가 5인 배열 생성
} //2행 5열

let num = 1;    
//배열에 저장
for(let i=0; i<number.length; i++){  //행
  for(let j=0; j<number[i].length; j++){ //열
    number[i][j] = num;
    num++;
  } 
} 

//배열 출력
for(let i=0; i<number.length; i++){  //행
  for(let j=0; j<number[i].length; j++){ //열
    console.log(number[i][j]);
    result2.innerHTML += number[i][j] + (j<number[i].length-1 ? ", " : "");
  }   
  result2.innerHTML += "<br>";
} //1, 2, 3, 4, 5<br>6, 7, 8, 9, 10<br>
