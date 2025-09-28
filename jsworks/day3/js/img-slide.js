
let picture = ["images/coffee-blue.jpg", "images/coffee-gray.jpg", 
      "images/coffee-pink.jpg"];
let picIdx = 0;

showSlide();

function showSlide(){
  document.getElementById("pic").src = picture[picIdx];
  picIdx++;
  if(picIdx == picture.length)
    picIdx = 0;
  setTimeout(showSlide, 2000);
}