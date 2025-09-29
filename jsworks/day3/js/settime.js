function welcome(){
  setTimeout(() => {
    alert("환영합니다.")
  }, 1000);
}

function changePic(){
  let img = document.getElementById("pic");

  setTimeout(() => {
    img.src = "images/cup-2.png";
  }, 1000);
}

