//함수 정의
function myPow(x, y){
  let num = 1;
  for(let i = 0; i < y; i++){
    num = num * x;
    return num;
  }
  /*
    x = 2, y = 3이 입력
    i = 0, 2 = 1 * 2
    i = 1, 4 = 2 * 2
    i = 2, 8 = 4 * 2 (=2 * 2* 2)
  */
}

let difference = function(a, b){
  return Math.abs(a-b);
}

let dice = function(){
  return Math.floor(Math.random()*6) + 1;
}

//함수 호출
console.log(Math.pow(2, 3));
console.log(myPow(2, 3));

//console.log(Math.abs(-7));
console.log(difference(4, 7))
console.log(difference(7, 4))

//dice() 호출
for(var i=1; i<=10; i++){
 console.log(dice());
}

