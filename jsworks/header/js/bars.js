// 자바스크립트 - classList 객체 사용
/*let toggleBtn = document.querySelector(".navbar_toggleBtn");
let menu = document.querySelector('.navbar_menu');

toggleBtn.addEventListener('click', function(){
  menu.classList.toggle('active');
});*/

// 제이쿼리로 구현
$(function(){
  $(".navbar_toggleBtn").click(function(){
    //alert("test");
    //show(), hide(), toggle()
    $(".navbar_menu").toggle("active");
  });

  //상단메뉴의 크기가 모바일 버전보다 크면..
  $(window).resize(function(){
    if(parseInt($("nav").css("width")) > 768){
      $(".navbar_menu").css("display", "flex");
    }
  });
})
