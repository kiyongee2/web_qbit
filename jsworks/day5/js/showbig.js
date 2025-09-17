
let bigPic = document.querySelector("#cup");
let smallPics = document.querySelectorAll(".small");

//smallPics[1].onclick = showBig;
for(let i=0; i<smallPics.length; i++){
  smallPics[i].onclick = showBig;
}

function showBig(){
  let newPic = this.src;
  console.log(bigPic.getAttribute(this.src));
  bigPic.setAttribute("src", newPic);
}

//onclick의 실행 함수로 구현
for(let i=0; i<smallPics.length; i++){
  smallPics[i].onclick = function(){
    bigPic.setAttribute("src", this.src);
  };
}
