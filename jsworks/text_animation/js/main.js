
window.onload = function(){
  let text = document.querySelector("h1");

  window.addEventListener('scroll', function(){
    let value = this.window.scrollY;
    console.log('scrollY', value);

    if(value > 200){
      text.style.animation = "backward 1s ease-out forwards";
    }else{
      text.style.animation = "forward 1s ease-out";
    }
  })
}
