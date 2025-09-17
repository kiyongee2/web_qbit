//alert("test")

let horizontalUnderline = document.getElementById("horizontal-underline");
let horizontalMenus = document.querySelectorAll("nav:first-child a");
console.log(horizontalUnderline);
console.log(horizontalMenus);

horizontalMenus.forEach(menu => 
  menu.addEventListener('click', (e) => {
    horizontalIndicator(e);
  }));

function horizontalIndicator(e){
  horizontalUnderline.style.left = e.currentTarget.offsetLeft + "px";
  horizontalUnderline.style.width = e.currentTarget.offsetWidth + "px";
  horizontalUnderline.style.top = 
      e.currentTarget.offsetTop + e.currentTarget.offsetHeight + "px";
  console.log(horizontalUnderline.style.left);
  console.log(horizontalUnderline.style.top);
}