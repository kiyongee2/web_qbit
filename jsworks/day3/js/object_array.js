
// 여러 명의 person 객체를 배열로 저장
let people = [
  {
    name: "이정후",
    age: 26,
    isMarried: false,
    play() {
      return `${this.name}이(가) 야구를 합니다.`;
    }
  },
  {
    name: "김연아",
    age: 34,
    isMarried: true,
    play() {
      return `${this.name}이(가) 피겨 스케이팅을 합니다.`;
    }
  },
  {
    name: "손흥민",
    age: 32,
    isMarried: false,
    play() {
      return `${this.name}이(가) 축구를 합니다.`;
    }
  }
];

const demo = document.getElementById("demo");

// 배열 반복 출력
people.forEach(person => {
  demo.innerHTML += `
      <h4>${person.name}</h4>
      나이: ${person.age} <br>
      결혼여부: ${person.isMarried ? "기혼" : "미혼"} <br>
      ${person.play()}
    </div>
  `;
});

