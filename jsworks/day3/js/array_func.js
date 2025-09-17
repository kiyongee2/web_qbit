
let nums = [1, 2, 3];

nums.unshift(0);  //맨 앞 추가
console.log(nums);

nums.shift();
console.log(nums); //맨 앞 삭제

for(let i in nums){
  console.log(nums[i]);
}

document.write(nums.join(":") + '<br>');

//배열 복사
const numbers = [4, 9, 16, 25];
//1. 복사1
let numbers2 = [];
numbers2 = numbers;
console.log("복사 후");
console.log(numbers2);

//2. 복사2
let numbers3 = new Array(4);
numbers3 = numbers;
console.log("복사 후");
console.log(numbers3);

//3. 복사3
let newNumbers = numbers.map(numbers);
console.log("복사 후");
console.log(newNumbers);