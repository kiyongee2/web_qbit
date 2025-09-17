
let book = {
  title: "웹 표준의 정석",
  author: "고경희",
  price: 30000,
  
  info: function(){
    alert(this.title + this.price);
  }
}

book.info();


function Book(title, author, price){
  this.title = title;
  this.author = author;
  this.price = price;
}

let java = new Book("자바 프로그래밍 입문", "박은종", 30000);
let web = new Book("웹 표준의 정석", "고경희", 30000);
let jsp = new Book("JSP 웹 프로그래밍", "황희정", 27000);

let bookList = [java, web, jsp];

//console.log(bookList[0].title);

document.write("<h1>책 제목으로 살펴보기</h1>");
for(let i=0; i<bookList.length; i++){
  document.write("<p>" + bookList[i].title + "</p>");
}
