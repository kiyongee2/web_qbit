//calc_age.js
function calcAge(){
  const CURRENT_YEAR = 2023;
  let birthYear, age;

  birthYear = prompt("태어난 해를 입력하세요", "yyyy");

  if(birthYear == null){
    document.getElementById("print").innerHTML = "입력이 취소되었습니다.";
  }else if(isNaN(birthYear)){
    document.getElementById("print").innerHTML = "숫자를 입력해주세요";
  }else{
    birthYear = parseInt(birthYear);
    age = CURRENT_YEAR - birthYear;
    document.getElementById("print").innerHTML =  
                          "당신의 나이는 " + age + "세입니다.";
  }
}
