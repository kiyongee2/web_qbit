const MONTH = 12;
const RATE_KPH_MPH = 1.609;
const CURRENT_YEAR = 2023;

//MONTH = 13;
//console.log("1년은 " + MONTH + "달이 있습니다.");

/*let kph = prompt("공의 속도 입력", '140.4');
let mph = parseFloat(kph) / RATE_KPH_MPH;
console.log(mph.toFixed(2));*/

let birthYear = prompt("태어난해 입력:", 'YYYY');
let age = CURRENT_YEAR - birthYear;
console.log(age);