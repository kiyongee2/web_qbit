// changeImg2.js

let pic = document.querySelector("#pic") //이미지 요소에 접근

//객체.addEventListener(이벤트, 함수){}
// pic.addEventListener("click", () => {
//   pic.src = "images/cup-2.png";
// });

//토글(toggle) 구현
let sw = false; //상태 변수
pic.addEventListener("click", () => {
  if(!sw){
    pic.src = "images/cup-2.png";
    sw = true;
  }else{
    pic.src = "images/cup-1.png";
    sw = false;
  }
});

//mouseover, mouseout 사용
// pic.addEventListener("mouseover", () => {
//   pic.src = "images/cup-2.png";
// });

// pic.addEventListener("mouseout", () => {
//   pic.src = "images/cup-1.png";
// });

//event 정보 보기
/*pic.addEventListener("click", (e) => {
  console.log(e);
  alert(`클릭한 위치: ${e.pageX}, ${e.pageY}`)
});*/

