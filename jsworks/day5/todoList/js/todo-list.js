//js > todo-list.js

//태그 요소 선택
const todoInput = document.getElementById("todoInput");
const addBtn = document.getElementById("addBtn");
const todoList = document.getElementById("todo-list");

//버튼 클릭 이벤트
addBtn.addEventListener("click", () => {
  const todoText = todoInput.value; //입력값 가져오기

  //새로운 <li> 생성
  const newItem = document.createElement("li");
  newItem.textContent = todoText;

  todoList.appendChild(newItem); //리스트에 추가

  //입력창 초기화
  todoInput.value = "";
  todoInput.focus();
})

//엔터로 할 일 추가
todoInput.addEventListener("keydown", (event) => {
  if(event.key == "Enter"){
    addBtn.click();  //버튼 클릭 실행
  }
})

