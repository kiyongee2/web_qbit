// changeImg.js

let pic = document.querySelector("#pic") //이미지 요소에 접근

function changePic(){
  pic.src = "images/cup-2.png";
}

//객체의 onclick 속성 사용 - 호출된 함수의 ()는 생략함
pic.onclick = changePic;

//실행 함수로 구현
pic.onclick = () => {
  pic.src = "images/cup-2.png";
}

