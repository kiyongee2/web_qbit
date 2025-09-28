//switch문
const result = document.getElementById("result");
let floor = prompt("몇 층으로 가실건가요?", "1~3");  
console.log(typeof(floor)); //string

switch(floor){
    case '1':
        result.innerHTML = `<span>1층</span>을 눌렀습니다.`;    
        break;
    case '2':
        result.innerHTML = `<span>2층</span>을 눌렀습니다.`;          
        break;  
    case '3':
        result.innerHTML = `<span>3층</span>을 눌렀습니다.`;          
        break; 
    default:
        result.innerHTML = `건물에 없는 층입니다.`; 
        break;  
}

