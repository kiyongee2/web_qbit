//자료형 (Data Type)
  //1. 숫자형 (Number)  
  let age = 26; //정수형 (Integer)
  let temperature = 24.5; //실수형 (Float)  

  console.log("나이:" + age + "세");
  console.log("온도:", temperature + "도");
  console.log(typeof(age)); //number
  console.log(typeof(temperature)); //number

  //2. 문자열형 (String)
  let player = "이정후"; //큰따옴표 사용
  let city = '샌프란시스코'; //작은따옴표 사용
  console.log("선수이름:", player + ", 도시: " + city);
  console.log('선수이름:', player, ', 도시:', city);
  console.log(typeof(player));  //string 
  //백틱(`) 사용 (템플릿 문자열)
  console.log(`선수이름: ${player}, 도시: ${city}`); 
  

  //3. 불린형 (Boolean)
  let isStudent = false; //불리언형(Boolean), true or false  
  let hasLicense = true;  
  console.log("Is Student:", isStudent);
  console.log("Has License:", hasLicense);
  console.log(typeof(hasLicense)); //boolean

  //4. null과 undefined
  let emptyValue = null; //값이 없음
  let notAssigned; //값이 할당되지 않음
  console.log("Empty Value:", emptyValue); //null
  console.log("Not Assigned:", notAssigned); //undefined
  console.log(typeof(emptyValue)); //object (null은 object로 나옴)
  console.log(typeof(notAssigned)); //undefined
  
  //4. 배열형 (Array)
  let fruits = ["Apple", "Banana", "Cherry"]; //배열 (Array)
  console.log(fruits); //["Apple", "Banana", "Cherry"]
  console.log(fruits[0]); //Apple
  console.log(fruits[1]); //Banana
  console.log(fruits[2]); //Cherry    
  console.log("배열의 크기", fruits.length);  //3

  //5. 객체형 (Object)
  let person = {
    name: "우상혁",
    age: 29,
    isStudent: false
  };
  console.log(person); //{name: '우상혁', age: 29, isStudent: false}
  console.log("이름:", person.name); //우상혁
  console.log("나이:", person.age); //29
  console.log("학생여부:", person.isStudent); //false
  console.log(typeof(person)); //object
  console.log(person.name + "은 " + person.age + "세 입니다.");
  console.log(`${person.name}은 ${person.age}세 입니다.`); //템플릿 문자열 (Template String)
  
    
