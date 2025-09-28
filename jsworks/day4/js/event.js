
//보기 버튼을 누르면 설명 텍스트가 보이고, 
//닫기 버튼을 누르면 설명 텍스트가 숨기짐
let button = document.getElementById("show");
let text = document.getElementById("detail");

function showText(){
  text.style.display = "block";   //텍스트 보이기
  button.style.display = "none";  //버튼 숨기기
}

function hideText(){
  button.style.display = "block";  //버튼 보이기
  text.style.display = "none";     //텍스트 숨기기
}

