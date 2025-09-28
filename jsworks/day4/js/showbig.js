
//큰 이미지 선택
let bigPic = document.querySelector("#big"); 

//작은 이미지를 큰 이미지로 변경
function showBig(){
  let newPic = this.src; //클릭된 작은 이미지 경로
  console.log(bigPic.getAttribute("src"));
  bigPic.setAttribute("src", newPic);
}

//모든 작은 이미지 선택
let smallPics = document.querySelectorAll(".small");

//smallPics[1].onclick = showBig; //1번 이미지 이벤트

//모든 작은 이미지에 이벤트 등록
for(let i=0; i<smallPics.length; i++){
  smallPics[i].onclick = showBig;
}

//onclick의 실행 함수로 구현
/*for(let i=0; i<smallPics.length; i++){
  smallPics[i].onclick = function(){
    bigPic.setAttribute("src", this.src);
  };
}*/
