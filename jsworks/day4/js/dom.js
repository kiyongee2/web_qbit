
// ID 선택
let title = document.getElementById("title");

//title.textContent = "Hello, DOM!";  // 텍스트 변경
title.innerText = "안녕, DOM!";

// CSS 선택자 방식
let p = document.querySelector(".desc");  // 첫 번째 요소

p.innerHTML = "<b>강조된 문장</b>";  // HTML 포함 변경

