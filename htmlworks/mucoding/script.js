//텍스트 애니메이션 - 즉시 실행 함수
(function(){
  const spanEl = document.querySelector('main h2 span');
  //console.log(spanEl);
  const textArr = ['Web Front-End Developer', 'Software Engineer',
            'Web Back-End Developer'];
  //console.log(textArr[0]);

  let index = 0;
  let currentText = textArr[index].split("");
  //console.log(currentText);
  function writeText(){
    spanEl.textContent += currentText.shift();
    //console.log(currentText);
    if(currentText.length !== 0){
      setTimeout(writeText, Math.floor(Math.random() * 100));
    }else{
      currentText = spanEl.textContent.split("");
      //console.log('복구');
      //console.log(currentText);
      setTimeout(deleteText, 3000);
    }
  }

  function deleteText(){
    currentText.pop();
    //console.log(currentText.join(""));
    spanEl.textContent = currentText.join("");
    
    if(currentText.length !== 0){
      setTimeout(deleteText, Math.floor(Math.random() * 100));
    }else{
      index = (index + 1) % textArr.length;
      currentText = textArr[index].split("");
      writeText();
      //console.log(index);
    }
  }

  writeText();
})();

// 수직 스크롤이 발생하면 header 태그에 'active' 클래스 추가 및 삭제
(function(){
  const headerEl = document.querySelector('header');
  window.addEventListener('scroll', function(){
    scrollCheck();
  });

  function scrollCheck(){
    //const browserScrollY = window.scrollY;
    console.log(window.scrollY);
    if(window.scrollY > 0){
      headerEl.classList.add('active');
    }else{
      headerEl.classList.remove('active');
    }
  }
})();

// 애니메이션 스크롤
const animationMove = function(seletor){
  const target = document.querySelector(seletor);
  console.log(target);
  const targetScrollY = target.getBoundingClientRect().top + window.scrollY;
  window.scrollTo({top: targetScrollY, behavior: 'smooth'});
}

const scrollMoveEl = document.querySelectorAll("[data-animation-scroll='true']");
console.log(scrollMoveEl);

for(let i = 0; i < scrollMoveEl.length; i++){
  scrollMoveEl[i].addEventListener('click', function(e){
    //console.log(e.target);
    //console.log(e.target.dataset.target);
    console.log(this.dataset.target);

    animationMove(this.dataset.target);
  })
}