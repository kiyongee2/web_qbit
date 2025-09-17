
let customer = prompt("입장객 수를 입력하세요:");
let colNum = prompt("좌석열의 수를 입력하세요:");
let rowNum;

if(isNaN(customer) || isNaN(colNum)){
  document.write("숫자를 입력하세요.");
}else if(customer == null || colNum == null){
  document.write("입력이 취소되었습니다.");
}else{
  if(customer % colNum == 0){
    rowNum = customer / colNum;
  }else{
    rowNum = parseInt(customer / colNum) + 1;
  }
  // document.write(rowNum + "줄이 필요합니다.");
  document.write("<table>")
  for(var i=0; i<rowNum; i++){
    document.write("<tr>")
    for(var j=1; j<=colNum; j++){
      let seat = i*colNum+j;
      if(seat > customer) break;
      document.write("<td>좌석" + seat + "</td>");
    }
    document.write("</tr>");
  }
  document.write("</table>");
}

