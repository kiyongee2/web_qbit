/**
 * time.js
 * 시계 만들기
 */

/*setInterval(myWatch, 1000);

function myWatch(){
	let date = new Date();
	let now = date.toLocaleTimeString();
	document.getElementById("display").innerHTML = now;
}*/

setInterval(()=>{
	let date = new Date();
	let now = date.toLocaleTimeString();
	document.getElementById("display").innerHTML = now;
}, 1000);


