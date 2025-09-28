// if ~ else if ~ else
const result = document.getElementById("result");
let score = prompt("점수를 입력하세요.", "80");   

if(score != null){
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
    //console.log(`score = ${score}, grade = ${grade}`);
    result.innerHTML = `점수: ${score}, 학점: <span>${grade}</span>입니다.`;
} else {
    console.log("입력이 취소되었습니다.");
}

