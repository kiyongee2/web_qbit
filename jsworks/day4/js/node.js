//node.js

//속성이 있는 노드 추가하기
let newImg = document.createElement("img");

//속성값 연결하기
newImg.setAttribute("src", "images/doit.jpg"); 
newImg.setAttribute("alt", "학생");

document.body.appendChild(newImg); //body에 연결하기

