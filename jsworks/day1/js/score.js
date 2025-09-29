// if ~ else if ~ else
const result = document.getElementById("result");
let score = prompt("점수를 입력하세요.", "80");   

if(score == null || isNaN(score)) {
    result.textContent = "유효한 숫자를 입력하세요.";
}else {
    score = parseInt(score); //문자열 -> 숫자 변환  
    let grade = "";
    if(score >= 90 && score <= 100){
        grade = 'A';
    } else if(score >= 80){
        grade = 'B';
    } else if(score >= 70){
        grade = 'C';
    } else if(score >= 60){
        grade = 'D';
    } else {
        grade = 'F';
    }
    result.innerHTML = `점수: ${score}, 학점: <span>${grade}</span>입니다.`;
}

